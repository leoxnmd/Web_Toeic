package com.leo.webTest;

import com.leo.webCore.dao.RoleDao;
import com.leo.webCore.daoimpl.RoleDaoImpl;
import com.leo.webCore.peristence.entity.RoleEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {

    @Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
        list.forEach(s -> {
            System.out.println("Print name : \n" + s.getName());
        });
    }
    @Test
    public void checkUpdate() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(2);
        entity.setName("User");
        roleDao.update(entity);
    }
    @Test
    public void checkSave() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(3);
        entity.setName("Manager");
        entity.setRoleId(4);
        entity.setName("test");
        roleDao.save(entity);
    }
    @Test
    public void checkFindByID(){
        RoleDao roleDao=new RoleDaoImpl();
        RoleEntity entity=roleDao.findById(1);

    }
    @Test
    public void checkFindByProperty(){
        RoleDao roleDao=new RoleDaoImpl();
        String property=null;
        String value=null;
        String sortExpression=null;
        String sortDeriction=null;
        Object[] objects=roleDao.findByProperty(property,value,sortExpression,sortDeriction);
    }
    @Test
    public void checkDelete(){
        RoleDao roleDao=new RoleDaoImpl();
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        int count=roleDao.delete(list);
    }
}