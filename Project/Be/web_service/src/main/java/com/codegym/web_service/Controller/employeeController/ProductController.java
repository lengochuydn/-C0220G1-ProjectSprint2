package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Category;
import com.codegym.dao.entity.Product;
import com.codegym.dao.entity.Unit;
import com.codegym.dao.repository.ProductRepository;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("warehouse-management")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listProducts/{pageNo}/{pageSize}")
    public ResponseEntity<List<Product>> listProducts(@PathVariable int pageNo, @PathVariable int pageSize) {
        List<Product> products = productService.findAllByDeleteFlagFalsePaging(pageNo, pageSize);
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/listProducts")
    public ResponseEntity<Page<Product>> listProducts(Pageable pageable) {
        Page<Product> products = productService.findAllByDeleteFlagFalsePaging(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<Page<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Product>>(products, HttpStatus.OK);

    }

    //    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/create_product")
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update_product/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product currentProduct = productService.findById(id);
        if (currentProduct == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setProductId(product.getProductId());
        currentProduct.setProductName(product.getProductName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setExpiryDate(product.getExpiryDate());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setCategory(product.getCategory());
        currentProduct.setBrand(product.getBrand());
        currentProduct.setUnit(product.getUnit());
        productService.save(currentProduct);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        productService.remove(product);
        productService.save(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
    @GetMapping("/listUnit")
    public ResponseEntity<List<Unit>> listAllUnit() {
        List<Unit> units = unitService.findAll();
        if (units.isEmpty()) {
            return new ResponseEntity<List<Unit>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Unit>>(units, HttpStatus.OK);
    }
}
