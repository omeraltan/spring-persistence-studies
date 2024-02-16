package com.persistence.examples.service;

import com.persistence.examples.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    Product findByName(String name);

    List<Product> findAllActiveProduct();

    List<Product> findAllNonActiveProduct();

    List<Product> findAllSortProducts(Sort sort);

    List<Product> findAllProductsInNames(List<String> names);

}
