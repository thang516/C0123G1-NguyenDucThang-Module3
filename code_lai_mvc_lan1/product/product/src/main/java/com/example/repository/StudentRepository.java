package com.example.repository;

import com.example.model.Clazz;
import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private  static final String SELECT_ALL = "SELECT s.*,c.class_name FROM students AS  s\n" +
            "INNER JOIN classs AS c ON c.class_id = s.class_id;";
    private  static final  String SAVE = "INSERT INTO students(`name`,class_id,`point`) VALUES(?,?,?);";
private static final  String SELECT_CLAZZ = "SELECT * FROM classs;";
private static final  String DELETE = "DELETE FROM students  WHERE id =  ?; ";
private static final  String UPDATE = "UPDATE  students SET `name` = ? ,class_id = ? , `point`=? where id = ?;";

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int classId = resultSet.getInt("class_id");
                Float point = resultSet.getFloat("point");
                Clazz clazz = new Clazz(classId, className);
                Student student = new Student(id , name, clazz ,point);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public boolean save(Student student) {
    Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getClazz().getId());
            preparedStatement.setFloat(3,student.getPoint());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Clazz> getAllClazz() {
        List<Clazz> clazzList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLAZZ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("class_id");
                String name = resultSet.getString("class_name");
                clazzList.add(new Clazz(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clazzList;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1,id);
            return callableStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean edit(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        boolean rowUpdate =false;
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE);
            callableStatement.setString(1,student.getName());
            callableStatement.setString(2, String.valueOf(student.getClazz().getId()));
            callableStatement.setString(3, String.valueOf(student.getPoint()));
            callableStatement.setInt(4,student.getId());
            rowUpdate=callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
