package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
//    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "account_name", nullable = false, unique = true)
    private String accountName;

    @Column(name = "account_password", nullable = false)
    private String accountPassword;
    @Column(name = "delete_flag")
    boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    @OneToMany(mappedBy = "account")
//    @JsonBackReference
//    public List<Employee> employees;

    public Account() {
    }

    public Account(String accountName, String accountPassword, boolean deleteFlag, Role role) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.deleteFlag = deleteFlag;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }


    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}

