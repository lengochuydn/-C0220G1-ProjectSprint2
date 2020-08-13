package com.codegym.dao.repository;

import com.codegym.dao.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByDeleteFlagIsFalse();

    Account findAccountByAccountIdAndDeleteFlagIsFalse(int id);
    
    Account findAccountByDeleteFlagIsFalseAndAccountName(String name);

    Page<Account> findAllByAccountNameContainingAndDeleteFlagIsFalse(String userName, Pageable pageable);

    Account findAllByAccountName(String name);
}
