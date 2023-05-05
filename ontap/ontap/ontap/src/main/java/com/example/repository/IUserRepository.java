package com.example.repository;

import com.example.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();

    boolean save(User user);

    List<User> findUser( String countrys);
}
