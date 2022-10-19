package com.leo.webCore.data.daoimpl;

import com.leo.webCore.common.utils.HibernateUtil;
import com.leo.webCore.data.dao.GenericDao;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        Transaction transaction = null;
        transaction = getSession().beginTransaction();//mở đối tượng transaction

        try {
            //HQL:
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());//nên trỏ this : đứng tại class, chứa class
            list = this.getSession().createQuery(sql.toString(),persistenceClass).getResultList();

            transaction.commit();
        } catch (HibernateError e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }
}
