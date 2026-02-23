package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Student;

@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sf;

    public boolean saveStudent(Student student) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Student findByUsernameAndPassword(String username, String password) {
        Session session = sf.openSession();

        Student student = session
                .createQuery("from Student where username=:uname and password=:pwd", Student.class)
                .setParameter("uname", username)
                .setParameter("pwd", password)
                .uniqueResult();

        session.close();
        return student;
    }
}