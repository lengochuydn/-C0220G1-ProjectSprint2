package com.codegym.service.impl;

import com.codegym.dao.entity.AccessTimes;
import com.codegym.dao.repository.AccessTimesRepository;
import com.codegym.service.AccessTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessTimesServiceImpl implements AccessTimesService {
    @Autowired
    AccessTimesRepository accessTimesRepository;

    @Override
    public List<AccessTimes> findAll() {
        return accessTimesRepository.findAll();
    }

    @Override
    public void add(AccessTimes accessTimes) {
        accessTimesRepository.save(accessTimes);
    }
}
