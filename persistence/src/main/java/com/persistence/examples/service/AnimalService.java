package com.persistence.examples.service;

import com.persistence.examples.entity.Animal;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnimalService {

    public Animal findByName(String name);

    public Animal retrieve(String name);

    List<Animal> findAllAnimalsOrderDesc(Pageable pageable);

    Animal findAnimalById(Long id);

    Animal findAnimalByNameAndType(String name, String type);

    Animal findAnimalByNameAndTypeNative(String name, String type);

    Animal findAnimalByNameAndTypeNamedParameters(String name, String type);
}
