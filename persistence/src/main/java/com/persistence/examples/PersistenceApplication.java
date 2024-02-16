package com.persistence.examples;

import com.persistence.examples.entity.Animal;
import com.persistence.examples.entity.Car;
import com.persistence.examples.entity.Product;
import com.persistence.examples.repository.AnimalRepository;
import com.persistence.examples.repository.CarRepository;
import com.persistence.examples.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PersistenceApplication implements CommandLineRunner{

    @Autowired
    AnimalRepository repository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CarRepository carRepository;

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

        Car car1 = new Car(1L, "Mercedes", 1, true, LocalDate.now());
        Car car2 = new Car(2L, "Toyota", 2, true, LocalDate.of(2020,2,12));
        Car car3 = new Car(3L, "BMW", 1, true, LocalDate.of(2008,1,4));
        Car car4 = new Car(4L, "Volkswagen", 1, false, LocalDate.of(2018,4,24));
        Car car5 = new Car(5L, "Ford", 3, true, LocalDate.of(1984,3,30));
        Car car6 = new Car(6L, "Honda", 2, true, LocalDate.of(1999,7,17));
        Car car7 = new Car(7L, "Chevrolet", 3, true, LocalDate.of(2003,9,11));
        Car car8 = new Car(8L, "Mazda", 2, true, LocalDate.of(1856,2,12));
        Car car9 = new Car(8L, null, 2, true, LocalDate.of(1855,4,7));

        List<Car> carList = Arrays.asList(car1,car2,car3,car4,car5,car6,car7,car8,car9);
        carRepository.saveAll(carList);


    }
}
