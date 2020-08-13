package com.codegym.service.impl;

import com.codegym.dao.entity.StorageLocation;
import com.codegym.dao.repository.StorageLocationRepository;
import com.codegym.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StorageLocationServiceImpl implements StorageLocationService {
    @Autowired
    private StorageLocationRepository storageLocationRepository;
    @Override
    public List<StorageLocation> findAll() {
        return storageLocationRepository.findAll();
    }

    @Override
    public StorageLocation findById(Integer id) {
        return storageLocationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(StorageLocation storageLocation) {
        storageLocationRepository.save(storageLocation);
    }

//    @Override
//    public void remove(Integer id) {
//        storageLocationRepository.deleteById(id);
//    }
}
