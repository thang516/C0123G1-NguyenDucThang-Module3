package com.example.repository;

import com.example.model.Clazz;
import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();

    boolean save(Student student);

    List<Clazz> getAllClazz();

    boolean delete(int id);

    boolean edit(Student student);
}
