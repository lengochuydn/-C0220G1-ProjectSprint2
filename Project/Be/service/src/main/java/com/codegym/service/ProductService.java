package com.codegym.service;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAllByDeleteFlagFalsePaging(int pageNo, int pageSize);
    Page<Product> findAllByDeleteFlagFalsePaging(Pageable pageable);
    Product findById(Integer id);
    void save(Product product);
    void remove(Product product);
}
