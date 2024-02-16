package com.persistence.examples.controller;

import com.persistence.examples.entity.Animal;
import com.persistence.examples.repository.AnimalRepository;
import com.persistence.examples.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    private AnimalServiceImpl service;
    private AnimalRepository repository;
    @Autowired
    public AnimalController(AnimalServiceImpl service, AnimalRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/animal")
    public ResponseEntity<Animal> getAnimalByName(){
        Animal animal = service.findByName("Cat");
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        List<Animal> animals = repository.findAll();
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<Animal> getRetrieveAnimals(){
        Animal animal = repository.retrieveByName("Cat");
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalByName(@PathVariable("id") Long id){
        Animal animal = service.findAnimalById(id);
        return ResponseEntity.ok().body(animal);
    }

    /*@GetMapping("/animal/{name}/{type}")
    public ResponseEntity<Animal> getAnimalByNameAndType(@PathVariable("name") String name, @PathVariable("type") String type){
        Animal animal = service.findAnimalByNameAndType(name, type);
        return ResponseEntity.ok().body(animal);
    }*/

    /*@GetMapping("/animal/{name}/{type}")
    public ResponseEntity<Animal> getAnimalByNameAndTypeNative(@PathVariable("name") String name, @PathVariable("type") String type){
        Animal animal = service.findAnimalByNameAndTypeNative(name, type);
        return ResponseEntity.ok().body(animal);
    }*/

    @GetMapping("/animal/{name}/{type}")
    public ResponseEntity<Animal> getAnimalByNameAndTypeNamedParameters(@PathVariable("name") String name, @PathVariable("type") String type){
        Animal animal = service.findAnimalByNameAndTypeNamedParameters(name, type);
        return ResponseEntity.ok().body(animal);
    }

}
