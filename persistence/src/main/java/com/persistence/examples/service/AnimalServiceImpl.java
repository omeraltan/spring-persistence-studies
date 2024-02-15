package com.persistence.examples.service;

import com.persistence.examples.entity.Animal;
import com.persistence.examples.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    private AnimalRepository repository;

    @Override
    public Animal findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Animal retrieve(String name) {
        return repository.retrieveByName(name);
    }

    @Override
    public List<Animal> findAllAnimalsOrderDesc(Pageable pageable) {
        return (List<Animal>) repository.findAnimalsWithPagination(pageable);
    }

    @Override
    public Animal findAnimalById(Long id) {
        return repository.findAnimalById(id);
    }

    @Override
    public Animal findAnimalByNameAndType(String name, String type) {
        return repository.findAnimalByNameAndType(name, type);
    }
}
