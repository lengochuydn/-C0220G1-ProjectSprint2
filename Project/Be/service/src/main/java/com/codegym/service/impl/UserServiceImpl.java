package com.codegym.service.impl;

import com.codegym.dao.entity.User;
import com.codegym.dao.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable) {
        return userRepository.findAllByDeleteFlagIsFalse(pageable);
    }

    @Override
    public User findGetId(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByAccountName(String accountName) {
        return userRepository.findByAccount_AccountName(accountName);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        User currentUser = findGetId(id);
        currentUser.setDeleteFlag(true);
        save(currentUser);
    }
}
