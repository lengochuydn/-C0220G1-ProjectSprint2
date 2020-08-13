package com.codegym.service.impl;

import com.codegym.dao.entity.Brand;
import com.codegym.dao.repository.BrandRepository;
import com.codegym.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAllByDeleteFlagFalse();
    }

    @Override
    public boolean createBrand(Brand brand) {
        List<Brand> brandList = brandRepository.findAllByDeleteFlagFalse();
        for (Brand brand1 : brandList) {
            if (brand.getBrandName().equals(brand1.getBrandName())) {
                return false;
            }
        }
        brandRepository.save(brand);
        return true;
    }

    @Override
    public Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search) {
        return brandRepository.findAllByBrandNameContainingAndDeleteFlagFalse(pageable, search);
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        brand.setDeleteFlag(true);
    }

}
