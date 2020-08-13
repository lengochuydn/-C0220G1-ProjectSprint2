package com.codegym.service.impl;

import com.codegym.dao.entity.Role;
import com.codegym.dao.repository.RoleRepository;
import com.codegym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAllRole() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
