package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.Role;
import com.mateacademy.springmvc.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role).orElse(new Role());
    }
}
