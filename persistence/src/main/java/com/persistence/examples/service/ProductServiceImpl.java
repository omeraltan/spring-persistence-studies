package com.persistence.examples.service;

import com.persistence.examples.entity.Product;
import com.persistence.examples.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> findAllActiveProduct() {
        return repository.findAllActiveProduct();
    }

    @Override
    public List<Product> findAllNonActiveProduct() {
        return repository.findAllNonActiveProduct();
    }

    @Override
    public List<Product> findAllSortProducts(Sort sort) {
        return repository.findAllSortProducts(sort);
    }

    @Override
    public List<Product> findAllProductsInNames(List<String> names) {
        return repository.findProductByNameList(names);
    }


}
