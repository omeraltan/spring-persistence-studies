package com.persistence.examples.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer status;

    private Boolean active;
    private LocalDate productDate;

    public Car() {
    }

    public Car(Long id, String name, Integer status, Boolean active, LocalDate productDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.active = active;
        this.productDate = productDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDate productDate) {
        this.productDate = productDate;
    }
}
