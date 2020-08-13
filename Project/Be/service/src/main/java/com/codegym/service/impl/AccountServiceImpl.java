package com.codegym.service.impl;

import com.codegym.dao.DTO.AccountDTO;
import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Role;
import com.codegym.dao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

import com.codegym.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class AccountServiceImpl implements UserDetailsService, AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountRepository.findAllByAccountName(accountName);
        if (account == null) {
            throw new UsernameNotFoundException("Không thể tìm thấy tên đăng nhập: " + accountName);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = account.getRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                account.getAccountName(),
                account.getAccountPassword(),
                grantedAuthorities);
    }

    @Override
    public UserDetails loadAccountByAccountName(String accountName) {
        return null;
    }

    @Override
    public List<AccountDTO> findAll() {
        return null;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountByAccountIdAndDeleteFlagIsFalse(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountRepository.findAccountByDeleteFlagIsFalseAndAccountName(name);

    }

    @Override
    public Page<Account> pageFindALLSearchNameOfCourseOfAdmin(Pageable pageable, String search) {
        return accountRepository.findAllByAccountNameContainingAndDeleteFlagIsFalse(search, pageable);
    }
}
