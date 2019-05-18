package com.mateacademy.spring_mvc.service;

import com.mateacademy.spring_mvc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    Optional getUserById(Long id);

    void deleteUser(Long id);
}
