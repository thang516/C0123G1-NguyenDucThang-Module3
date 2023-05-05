package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
private IUserRepository userRepository = new UserRepository();


    @Override
    public List<User> getAll() {
        List<User> userList = userRepository.getAll();
        return userList;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findUser(String countrys ) {
        List<User> userList = userRepository.findUser(countrys);

        return userList;
    }
}
