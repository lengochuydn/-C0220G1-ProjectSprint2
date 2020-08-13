package com.codegym.service.impl;

import com.codegym.dao.entity.Product;
import com.codegym.dao.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllByDeleteFlagFalsePaging(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = productRepository.findAllByDeleteFlagFalse(paging);
        return pagedResult.toList();
//        return productRepository.findAllByDeleteFlagFalse();
    }

    @Override
    public Page<Product> findAllByDeleteFlagFalsePaging(Pageable pageable) {
        return productRepository.findAllByDeleteFlagFalse(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        product.setDeleteFlag(true);
    }
}
