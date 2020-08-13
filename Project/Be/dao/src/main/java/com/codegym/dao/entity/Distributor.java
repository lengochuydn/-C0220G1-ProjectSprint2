package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distributor")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "email")
    String email;
    @Column(name = "phone")
    String numberPhone;
    @Column(name = "fax")
    String fax;
    @Column(name = "website")
    String website;
    @Column(name = "img")
    String img;
    boolean deleted;
    @ManyToOne(targetEntity = TypeOfDistributor.class)
    @JoinColumn(name = "type_of_distributor_id")
    TypeOfDistributor typeOfDistributor;

    public Distributor(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Distributor() {
    }

    public Distributor(String name, String address, String email, String numberPhone, String fax, String website, String img, boolean deleted, TypeOfDistributor typeOfDistributor) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.numberPhone = numberPhone;

        this.fax = fax;
        this.website = website;
        this.img = img;
        this.deleted = deleted;
        this.typeOfDistributor = typeOfDistributor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public TypeOfDistributor getTypeOfDistributor() {
        return typeOfDistributor;
    }

    public void setTypeOfDistributor(TypeOfDistributor typeOfDistributor) {
        this.typeOfDistributor = typeOfDistributor;
    }
}
