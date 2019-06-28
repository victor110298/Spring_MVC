package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);

    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long id);

    User deleteUserById(Long id);
}
