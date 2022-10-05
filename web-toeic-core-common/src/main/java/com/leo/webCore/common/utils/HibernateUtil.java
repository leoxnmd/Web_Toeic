package com.leo.webCore.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        //tạo 1 sesionFactory từ hibernate.cfg.xml
        try {
            return new Configuration().configure().buildSessionFactory();

        } catch (Throwable e) {
            System.out.println("initial session Factory fail");
            throw new ExceptionInInitializerError();
        }

    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
