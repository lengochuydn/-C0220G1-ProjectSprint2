package com.codegym.service;

import com.codegym.dao.entity.StorageLocation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StorageLocationService {
    List<StorageLocation> findAll();

    StorageLocation findById(Integer id);

    void save(StorageLocation storageLocation);

//    void remove(Integer id);
}
