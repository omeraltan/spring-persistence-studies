package com.persistence.examples.controller;

import com.persistence.examples.entity.Utensils;
import com.persistence.examples.repository.UtensilsRepository;
import com.persistence.examples.service.UtensilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UtensilsController {

    @Autowired
    private UtensilsService service;
    @Autowired
    UtensilsRepository repository;

    @GetMapping("/utensils")
    public ResponseEntity<List<Utensils>> getAllUtensils(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/utensils/pageone")
    public ResponseEntity<Page<Utensils>> getPageUtensils(){
        Page<Utensils> utensils = repository.findAll(PageRequest.of(0,2));
        return ResponseEntity.ok().body(utensils);
    }

    @GetMapping("/utensils/pagetwo")
    public ResponseEntity<Page<Utensils>> getUtensils(Pageable pageable){
        Page<Utensils> utensils = repository.findAll(PageRequest.of(0,5, Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id"))));
        return ResponseEntity.ok().body(utensils);
    }

    @GetMapping("/utensils/price")
    public ResponseEntity<List<Utensils>> getAllPrice(){
        Pageable secondPageWithFiveElements = PageRequest.of(1,5);
        return ResponseEntity.ok().body(service.findAllByPrice(750.00, secondPageWithFiveElements));
    }

}

