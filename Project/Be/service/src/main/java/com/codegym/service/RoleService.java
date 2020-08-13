package com.codegym.service;

import com.codegym.dao.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findRoleById(int id);
}
