package com.example.studentformdemo.util;

import com.example.studentformdemo.dto.StudentFormDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;

    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(StudentFormDTO.class);

        sessionFactory = configuration.buildSessionFactory();
    }


    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}