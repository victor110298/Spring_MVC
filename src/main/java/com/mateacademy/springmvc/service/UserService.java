package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);

    List<User> getAllUsers();

    void createUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);
}
