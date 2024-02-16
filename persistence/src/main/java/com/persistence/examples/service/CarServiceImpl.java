package com.persistence.examples.service;

import com.persistence.examples.entity.Car;
import com.persistence.examples.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository repository;

    @Override
    public List<Car> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Car> findByNameIs(String name) {
        return repository.findByNameIs(name);
    }

    @Override
    public List<Car> findByNameEquals(String name) {
        return repository.findByNameEquals(name);
    }

    @Override
    public List<Car> findByNameIsNot(String name) {
        return repository.findByNameIsNot(name);
    }

    @Override
    public List<Car> findByNameIsNull() {
        return repository.findByNameIsNull();
    }

    @Override
    public List<Car> findByNameIsNotNull() {
        return repository.findByNameIsNotNull();
    }

    @Override
    public List<Car> findByActiveTrue() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<Car> findByActiveFalse() {
        return repository.findByActiveFalse();
    }

    @Override
    public List<Car> findByNameStartingWith(String prefix) {
        return repository.findByNameStartingWith(prefix);
    }

    @Override
    public List<Car> findByNameEndingWith(String suffix) {
        return repository.findByNameEndingWith(suffix);
    }

    @Override
    public List<Car> findByNameContaining(String infix) {
        return repository.findByNameContaining(infix);
    }

    @Override
    public List<Car> findByNameLike(String likePattern) {
        return repository.findByNameLike(likePattern);
    }

    @Override
    public List<Car> findByStatusLessThan(Integer status) {
        return repository.findByStatusLessThan(status);
    }

    @Override
    public List<Car> findByStatusLessThanEqual(Integer status) {
        return repository.findByStatusLessThanEqual(status);
    }

    @Override
    public List<Car> findByStatusBetween(Integer startStatus, Integer endStatus) {
        return repository.findByStatusBetween(startStatus, endStatus);
    }

    @Override
    public List<Car> findByStatusIn(Collection<Integer> statuses) {
        return repository.findByStatusIn(statuses);
    }

    @Override
    public List<Car> findByProductDateAfter(LocalDate date) {
        return repository.findByProductDateAfter(date);
    }

    @Override
    public List<Car> findByProductDateBefore(LocalDate date) {
        return repository.findByProductDateBefore(date);
    }
}
