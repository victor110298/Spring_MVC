package com.mateacademy.spring_mvc.service;

import com.mateacademy.spring_mvc.entity.User;
import com.mateacademy.spring_mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private static UserRepository repository;


    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public Optional getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
