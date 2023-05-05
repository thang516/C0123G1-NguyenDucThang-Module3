package com.example.repository;

import com.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements  IUserRepository{
    private final   String GET_ALL = "SELECT * FROM users ; ";
    private  final  String SAVE="INSERT INTO users (name,email,country) VALUES(?,?,?);";
    private  final  String FIND = "SELECT * FROM users  WHERE country = ? ";
    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            User user = new User(id,name,email,country);
            userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    @Override
    public boolean save(User user) {
        Connection connection =BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findUser(String countrys) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND);
            preparedStatement.setString(1,countrys);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
               userList.add(new User(id,name,email,country));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
