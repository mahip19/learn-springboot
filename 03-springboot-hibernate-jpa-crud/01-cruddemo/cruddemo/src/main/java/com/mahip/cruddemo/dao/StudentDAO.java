package com.mahip.cruddemo.dao;

import com.mahip.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer Id);

    List<Student> findAll();
}
