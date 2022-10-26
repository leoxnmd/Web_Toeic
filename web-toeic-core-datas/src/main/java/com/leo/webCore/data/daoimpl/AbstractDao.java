package com.leo.webCore.data.daoimpl;

import com.leo.webCore.common.constant.CoreConstant;
import com.leo.webCore.common.utils.HibernateUtil;
import com.leo.webCore.data.dao.GenericDao;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {

    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        // ParameterizedType get tất cả các tham số trong <ID extends Serializable, T> tương ứng vtri (0,1)
        //getActualTypeArguments lấy đứng vi trí <ID extends Serializable, T> ở lấy 1 tương ứng là T
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
        //chuyển tên class (type: Class) -> String name
    }


    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        //Nên mở lại Session mỗi hàm truy vấn
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction

        try {
            //HQL:
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());//nên trỏ this : đứng tại class, chứa class
            list = session.createQuery(sql.toString(), persistenceClass).getResultList();
            //chuyển tên class không phai tên bảng sql
            transaction.commit();
        } catch (HibernateError e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public T findById(ID id) {
        T reuslt = null;
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction
        try {
            reuslt = session.get(persistenceClass, id);
            if (reuslt == null) {
                throw new ObjectNotFoundException("Not Found " + id, null);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return reuslt;
    }

    @Override
    public Object[] findByProperty(String property, Object value, String sortExpession, String sortDerection) {
        List<T> list = new ArrayList<>();
        Object totalItem=0;
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction
        try {
            StringBuilder sqlList = new StringBuilder("from ");
            sqlList.append(this.getPersistenceClassName());
            if (property != null && value != null) {
                sqlList.append(" where ").append(property).append("=:value ");
            }
            if (sortExpession != null && sortDerection != null) {
                sqlList.append(" order by ").append(sortExpession);
                sqlList.append(" ").append(sortDerection.equals(CoreConstant.SORT_ASC) ? "asc" : "desc");
            }
            Query queryList =session.createQuery(sqlList.toString());
            if (value != null) {
                queryList.setParameter("value",value);
            }
            list=queryList.getResultList();

            StringBuilder sqlSize=new StringBuilder("select count(*) from ");
            sqlSize.append(this.getPersistenceClassName());
            if (property != null && value != null) {
                sqlSize.append(" where ").append(property).append("=:value");
            }
            Query query= session.createQuery(sqlSize.toString());
            if (value != null) {
                queryList.setParameter("value",value);
            }
           totalItem= query.list().get(0);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItem,list};
    }

    @Override
    public int delete(List<ID> id) {
        int count=0;
        Session session = HibernateUtil.getSessionFactory().openSession();//mở session
        Transaction transaction = session.beginTransaction();//mở đối tượng transaction
        try{
            for (ID item:id) {
                T t= (T) session.get(this.persistenceClass,item);
                session.delete(t);
                count++;
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return count;
    }

}
