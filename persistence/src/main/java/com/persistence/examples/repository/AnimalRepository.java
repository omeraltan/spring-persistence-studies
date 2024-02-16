package com.persistence.examples.repository;

import com.persistence.examples.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);

    @Query("SELECT f FROM Animal f WHERE LOWER(f.name) = LOWER(:name)")
    Animal retrieveByName(@Param("name") String name);

    @Query(value = "SELECT u FROM Animal u ORDER BY u.id")
    Page<Animal> findAnimalsWithPagination(Pageable pageable);

    @Query("SELECT u FROM Animal u WHERE u.id = ?1")
    Animal findAnimalById(Long id);

    @Query("SELECT u FROM Animal u WHERE u.name = ?1 and u.type = ?2")
    Animal findAnimalByNameAndType(String name, String type);

    @Query(value = "SELECT * FROM Animal u WHERE u.name = ?1 AND u.type = ?2", nativeQuery = true)
    Animal findAnimalByNameAndTypeNative(String name, String type);

    @Query("SELECT u FROM Animal u WHERE u.name = :name AND u.type = :type")
    Animal findAnimalByNameAndTypeNamedParameters(@Param("name") String name, @Param("type") String type);

    @Query(value = "SELECT * FROM Animal u WHERE u.name = :name AND u.type = :type", nativeQuery = true)
    Animal findAnimalByNameAndTypeNativeNamedParameters(@Param("name") String name, @Param("type") String type);
}
