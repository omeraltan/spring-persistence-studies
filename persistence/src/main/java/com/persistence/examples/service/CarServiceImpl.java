package com.persistence.examples.service;


import com.persistence.examples.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class CarServiceImpl implements CarService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> findCarByStatus(Set<Integer> status) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);
        Path<String> statusPath = car.get("status");

        List<Predicate> predicates = new ArrayList<>();
        for (Integer st : status){
            predicates.add(cb.like(statusPath, String.valueOf(st)));
        }
        query.select(car).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }
}
