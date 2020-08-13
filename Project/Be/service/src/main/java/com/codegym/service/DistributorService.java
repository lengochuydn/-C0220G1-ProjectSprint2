package com.codegym.service;


import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistributorService {
    Distributor findById(int id);

    void save(Distributor distributor);

    List<Distributor> findAll();

    Page<Distributor> pageFindAllSearchName (Pageable pageable, String search, String address);




//Add-----------------------------------------------------------------------
    List<Distributor> findAllByDeleted(boolean isNotDeleted);
    void deleteById(int id);
}

