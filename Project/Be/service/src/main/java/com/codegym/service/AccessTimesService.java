package com.codegym.service;

import com.codegym.dao.entity.AccessTimes;

import java.util.List;

public interface AccessTimesService {
    List<AccessTimes> findAll();

    void add(AccessTimes accessTimes);
}
