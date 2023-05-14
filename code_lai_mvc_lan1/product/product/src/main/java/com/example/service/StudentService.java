package com.example.service;

import com.example.model.Clazz;
import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
     private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        List<Student> studentList = studentRepository.getAll();
        return studentList;
    }

    @Override
    public boolean save(Student student) {
       boolean check =  studentRepository.save(student);
       return check;
    }

    @Override
    public List<Clazz> getAllClazz() {
        List<Clazz>  clazzList= studentRepository.getAllClazz();
        return clazzList ;
    }

    @Override
    public void delete(int id) {
       studentRepository.delete(id);
    }

    @Override
    public void edit(Student student) {
        studentRepository.edit(student);
    }
}
