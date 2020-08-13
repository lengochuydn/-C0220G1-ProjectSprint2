package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Brand;
import com.codegym.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/warehouse-management")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //-------------------Retrieve All Brands--------------------------------------------------------
    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> listBrands() {
        List<Brand> brands = brandService.getAllBrand();
        if (brands == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }
    @GetMapping(value = "/brand", params = {"page", "size", "search"})
    public ResponseEntity<Page<Brand>> getAllCourse(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("search") String search
    ) {
        Page<Brand> brandPage = brandService.findAllByBrandNameContainingAndDeleteFlagFalse(PageRequest.of(page, size), search);
        if (brandPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brandPage, HttpStatus.OK);
    }
    //-------------------Create a Brand--------------------------------------------------------
    @PostMapping("/brand/create")
    public ResponseEntity<?> createBrand(@RequestBody Brand brand) {
        if(brandService.createBrand(brand)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //-------------------Retrieve Single Brand--------------------------------------------------------
    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    //-------------------Update a Brand--------------------------------------------------------
    @PutMapping("brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer id, @RequestBody Brand brand) {
        Brand currentBrand = brandService.findById(id);
        if (currentBrand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBrand.setBrandLogo(brand.getBrandLogo());
        currentBrand.setBrandName(brand.getBrandName());
        currentBrand.setBrandAddress(brand.getBrandAddress());
        currentBrand.setBrandWebsite(brand.getBrandWebsite());
        brandService.save(currentBrand);
        return new ResponseEntity<>(currentBrand, HttpStatus.OK);
    }

    //-------------------Delete a Brand--------------------------------------------------------
    @PatchMapping("brand/delete/{id}")
    public ResponseEntity<Brand> deleteBrand(@PathVariable Integer id) {
        Brand currentBrand = brandService.findById(id);
        if (currentBrand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        brandService.delete(currentBrand);
        brandService.save(currentBrand);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

