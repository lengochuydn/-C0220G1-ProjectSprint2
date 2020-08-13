package com.codegym.dao.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "storage_location")
public class StorageLocation {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_storage_location")
    int id;
    @Column(name = "name_storage_location")
    String nameStorageLocation;

    public StorageLocation() {
    }

    public StorageLocation(int id, String nameStorageLocation) {
        this.id = id;
        this.nameStorageLocation = nameStorageLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStorageLocation() {
        return nameStorageLocation;
    }

    public void setNameStorageLocation(String nameStorageLocation) {
        this.nameStorageLocation = nameStorageLocation;
    }
}