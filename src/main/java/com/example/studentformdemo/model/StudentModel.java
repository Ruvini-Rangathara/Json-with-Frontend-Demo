package com.example.studentformdemo.model;

import com.example.studentformdemo.dto.StudentFormDTO;
import com.example.studentformdemo.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentModel {
    public boolean save(StudentFormDTO student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(student);
            transaction.commit();

            return true;
        }catch(Exception e){
            System.out.println(e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
}
