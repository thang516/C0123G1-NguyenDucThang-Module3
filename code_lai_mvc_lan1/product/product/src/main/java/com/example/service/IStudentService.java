package com.example.service;

import com.example.model.Clazz;
import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    boolean save(Student student);

    List<Clazz> getAllClazz();

    void delete(int id);

    void edit(Student student);
}
