package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Student;
import com.tka.dao.StudentDao;

@Service
public class StudentService {

    @Autowired
    private StudentDao dao;

    public boolean register(Student student) {
        // Business logic can be added here
        return dao.saveStudent(student);
    }

    public Student login(String username, String password) {

        Student student = dao.findByUsernameAndPassword(username, password);

        if (student != null) {
            return student;
        }

        return null;
    }
}