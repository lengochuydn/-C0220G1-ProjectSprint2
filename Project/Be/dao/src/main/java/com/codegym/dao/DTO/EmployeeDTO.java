package com.codegym.dao.DTO;
import java.time.LocalDate;


public class EmployeeDTO {
    private int id;
    private String image;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String email;
    private String position;
    private String department;
    private String idAccount;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String image, String name, String gender, LocalDate birthday, String address,
                       String phoneNumber, String email, String position, String department, String idAccount) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.department = department;
        this.idAccount = idAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
