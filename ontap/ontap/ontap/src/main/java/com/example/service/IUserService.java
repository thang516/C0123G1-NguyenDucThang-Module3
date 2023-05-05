package com.example.service;

import com.example.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    void save(User user);

    List<User> findUser(String countrys);
}
