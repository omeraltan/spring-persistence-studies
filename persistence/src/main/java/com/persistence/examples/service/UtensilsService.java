package com.persistence.examples.service;

import com.persistence.examples.entity.Utensils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UtensilsService {

    List<Utensils> findAllByPrice(double price, Pageable pageable);

}
