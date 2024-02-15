package com.persistence.examples.repository;

import com.persistence.examples.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    // By default, the query definition uses JPQL
    @Query("SELECT u FROM Product u WHERE u.status = 1")
    List<Product> findAllActiveProduct();

    // Native
    @Query(value = "SELECT * FROM Product u WHERE  u.status = 2", nativeQuery = true)
    List<Product> findAllNonActiveProduct();

    @Query(value = "SELECT u FROM Product u")
    List<Product> findAllSortProducts(Sort sort);


}
