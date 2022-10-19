package com.leo.webTest;

import com.leo.webCore.dao.RoleDao;
import com.leo.webCore.daoimpl.RoleDaoImpl;
import com.leo.webCore.peristence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.List;

public class RoleTest {

    @Test
    public void checkFindAll() {
        RoleDao roleDao=new RoleDaoImpl();
        List<RoleEntity> list =roleDao.findAll();
        list.forEach(s -> {
            System.out.println("Print name : \n" + s.getName());
        });
    }
}
