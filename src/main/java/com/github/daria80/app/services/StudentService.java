package com.github.daria80.app.services;

import com.github.daria80.app.models.Student;

import java.util.List;

public interface StudentService {

    Student saveOrUpdate (Student student);

    List<Student> findAll();

    Student findById(String id);

    void deleteById(String id);



}
