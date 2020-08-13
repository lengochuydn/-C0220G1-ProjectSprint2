package com.codegym.dao.repository;

import com.codegym.dao.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findByRoleName(String name);

}
