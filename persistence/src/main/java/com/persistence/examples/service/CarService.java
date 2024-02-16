package com.persistence.examples.service;

import com.persistence.examples.entity.Car;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface CarService {

    List<Car> findByName(String name);
    List<Car> findByNameIs(String name);
    List<Car> findByNameEquals(String name);
    List<Car> findByNameIsNot(String name);
    List<Car> findByNameIsNull();
    List<Car> findByNameIsNotNull();
    List<Car> findByActiveTrue();
    List<Car> findByActiveFalse();
    List<Car> findByNameStartingWith(String prefix);
    List<Car> findByNameEndingWith(String suffix);
    List<Car> findByNameContaining(String infix);
    List<Car> findByNameLike(String likePattern);
    List<Car> findByStatusLessThan(Integer status);
    List<Car> findByStatusLessThanEqual(Integer status);
    List<Car> findByStatusBetween(Integer startStatus, Integer endStatus);
    List<Car> findByStatusIn(Collection<Integer> statuses);
    List<Car> findByProductDateAfter(LocalDate date);
    List<Car> findByProductDateBefore(LocalDate date);


}
