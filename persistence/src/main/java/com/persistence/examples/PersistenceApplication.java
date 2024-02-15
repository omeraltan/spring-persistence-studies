package com.persistence.examples;

import com.persistence.examples.entity.Animal;
import com.persistence.examples.entity.Product;
import com.persistence.examples.repository.AnimalRepository;
import com.persistence.examples.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PersistenceApplication implements CommandLineRunner{

    @Autowired
    AnimalRepository repository;
    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Animal animal1 = new Animal(1L,"Cat", "Pet");
        Animal animal2 = new Animal(2L,"Dog", "Pet");
        Animal animal3 = new Animal(3L,"Bird", "Pet");
        Animal animal4 = new Animal(4L,"Elephant", "Wild");
        Animal animal5 = new Animal(5L,"Spider", "Wild");
        Animal animal6 = new Animal(6L,"Lion", "Wild");

        List<Animal> list = Arrays.asList(animal1,animal2,animal3, animal4, animal5, animal6);

        repository.saveAll(list);

        Product product1 = new Product(1L,"Chair",1);
        Product product2 = new Product(2L,"Sofa",1);
        Product product3 = new Product(3L,"Lamp",1);
        Product product4 = new Product(4L,"Mirror",1);
        Product product5 = new Product(5L,"Door",2);
        Product product6 = new Product(6L,"Window",2);

        List<Product> productList = Arrays.asList(product1,product2,product3,product4,product5,product6);

        productRepository.saveAll(productList);

    }
}
