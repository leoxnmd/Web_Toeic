package com.leo.webCore.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    //generic list là các list có đối tượng vd List<String>

    //interface  viết phương thức nhưng không có thân hàm '{}'
    //interface hiển thị thuộc tính riêng
    List<T> findAll();
    T update(T entity);
    void  save(T entity);
    T findById(ID id);
    Object[] findByProperty(String property, Object value, String sortExpession, String sortDerection);
    int delete(List<ID> id);
}
