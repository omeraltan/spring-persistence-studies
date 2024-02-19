package com.persistence.examples.service;

import com.persistence.examples.entity.Utensils;
import com.persistence.examples.repository.UtensilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtensilsServiceImpl implements UtensilsService{

    @Autowired
    UtensilsRepository repository;


    @Override
    public List<Utensils> findAllByPrice(double price, Pageable pageable) {
        List<Utensils> allTenDollarUtensils = repository.findAllByPrice(price, pageable);
        return allTenDollarUtensils;
    }
}
