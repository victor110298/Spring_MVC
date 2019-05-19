package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    Object getUserById(Long id) throws Throwable;

    void deleteUser(Long id);
}
