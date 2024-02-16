package com.persistence.examples.service;

import com.persistence.examples.entity.Car;

import java.util.List;
import java.util.Set;

public interface CarService {
    List<Car> findCarByStatus(Set<Integer> status);
}
