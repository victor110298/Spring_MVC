package com.mateacademy.springmvc.service;

import com.mateacademy.springmvc.entity.Role;

public interface RoleService  {
    Role findByRole(String role);
}
