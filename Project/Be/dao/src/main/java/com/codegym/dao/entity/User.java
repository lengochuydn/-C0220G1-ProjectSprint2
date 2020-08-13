package com.codegym.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "delete_flag")
    private boolean deleteFlag;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

//    @OneToMany(mappedBy = "user")
//    private Set<Order> orderList;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    public Set<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(Set<Order> orderList) {
//        this.orderList = orderList;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
