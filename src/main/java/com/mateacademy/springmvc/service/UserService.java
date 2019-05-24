package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);
}
