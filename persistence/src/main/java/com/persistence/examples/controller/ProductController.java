package com.persistence.examples.controller;

import com.persistence.examples.entity.Product;
import com.persistence.examples.repository.ProductRepository;
import com.persistence.examples.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;
    private final ProductRepository productRepository;

    public ProductController(ProductService service,
                             ProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProductByName(){
        Product product = service.findByName("Window");
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllActiveProduct(){
        List<Product> product = service.findAllActiveProduct();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/nonactiveproducts")
    public ResponseEntity<List<Product>> getAllNonActiveProduct(){
        List<Product> product = service.findAllNonActiveProduct();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/sortproductsnames")
    public ResponseEntity<List<Product>> getAllSortProduct(){
        List<Product> product = productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/sortproductsnameslength")
    public ResponseEntity<List<Product>> getAllSortLengthProduct(){
        List<Product> product = productRepository.findAllSortProducts(JpaSort.unsafe("LENGTH(name)"));
        return ResponseEntity.ok().body(product);
    }

}
