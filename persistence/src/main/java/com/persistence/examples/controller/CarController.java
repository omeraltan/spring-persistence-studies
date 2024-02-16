package com.persistence.examples.controller;

import com.persistence.examples.entity.Car;
import com.persistence.examples.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RestController
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/car") // For Example: http://localhost:8080/car?name=Volkswagen
    public ResponseEntity<List<Car>>  getCarByName(@RequestParam("name") String name){
        List<Car> car = service.findByName(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/nameis") // For Example: http://localhost:8080/car/nameis?name=Volkswagen
    public ResponseEntity<List<Car>>  getCarByNameIs(@RequestParam("name") String name){
        List<Car> car = service.findByNameIs(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/nameequal") // For Example: http://localhost:8080/car/dateafter?date=1999-07-17
    public ResponseEntity<List<Car>>  getCarByNameEqual(@RequestParam("name") String name){
        List<Car> car = service.findByNameEquals(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/nameisnot") // For Example: http://localhost:8080/car/nameisnot?name=Mercedes
    public ResponseEntity<List<Car>>  getCarByNameIsNot(@RequestParam("name") String name){
        List<Car> car = service.findByNameIsNot(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/nameisnull") // For Example: http://localhost:8080/car/nameisnull
    public ResponseEntity<List<Car>>  getCarByNameIsNull(){
        List<Car> car = service.findByNameIsNull();
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/nameisnotnull") // For Example: http://localhost:8080/car/nameisnotnull
    public ResponseEntity<List<Car>>  getCarByNameIsNotNull(){
        List<Car> car = service.findByNameIsNotNull();
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/activetrue") // For Example: http://localhost:8080/car/activetrue
    public ResponseEntity<List<Car>>  getCarActiveTrue(){
        List<Car> car = service.findByActiveTrue();
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/activefalse") // For Example: http://localhost:8080/car/activefalse
    public ResponseEntity<List<Car>>  getCarActiveFalse(){
        List<Car> car = service.findByActiveFalse();
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/starting") // For Example: http://localhost:8080/car/starting?name=Mer
    public ResponseEntity<List<Car>>  getCarNameStarting(@RequestParam("name") String name){
        List<Car> car = service.findByNameStartingWith(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/ending") // For Example: http://localhost:8080/car/ending?name=let
    public ResponseEntity<List<Car>>  getCarNameEnding(@RequestParam("name") String name){
        List<Car> car = service.findByNameEndingWith(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/containing") // For Example: http://localhost:8080/car/containing?name=wa
    public ResponseEntity<List<Car>>  getCarNameContaining(@RequestParam("name") String name){
        List<Car> car = service.findByNameContaining(name);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/like") // For Example: http://localhost:8080/car/like?name=ced
    public ResponseEntity<List<Car>>  getCarNameLike(@RequestParam("name") String name){
        List<Car> car = service.findByNameLike("%" + name + "%");
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/lessthan") // For Example: http://localhost:8080/car/lessthan?status=2
    public ResponseEntity<List<Car>>  getCarStatusLessThan(@RequestParam("status") Integer status){
        List<Car> car = service.findByStatusLessThan(status);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/lessthanequal") // For Example: http://localhost:8080/car/lessthanequal?status=3
    public ResponseEntity<List<Car>>  getCarStatusLessThanEqual(@RequestParam("status") Integer status){
        List<Car> car = service.findByStatusLessThanEqual(status);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/statusbetween") // For Example: http://localhost:8080/car/statusbetween?startStatus=1&endStatus=3
    public ResponseEntity<List<Car>>  getCarStatusBetween(@RequestParam("startStatus") Integer startStatus, @RequestParam("endStatus") Integer endStatus){
        List<Car> car = service.findByStatusBetween(startStatus,endStatus);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/statusin") // For Example: http://localhost:8080/car/statusin?status=1,3
    public ResponseEntity<List<Car>>  getCarStatusIn(@RequestParam("status") Collection<Integer> statusIn){
        List<Car> car = service.findByStatusIn(statusIn);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/dateafter") // For Example: http://localhost:8080/car/dateafter?date=1984-07-17
    public ResponseEntity<List<Car>>  getCarProductDateAfter(@RequestParam("date") LocalDate date){
        List<Car> car = service.findByProductDateAfter(date);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/car/datebefore") // For Example: http://localhost:8080/car/datebefore?date=1984-07-17
    public ResponseEntity<List<Car>>  getCarProductDateBefore(@RequestParam("date") LocalDate date){
        List<Car> car = service.findByProductDateBefore(date);
        return ResponseEntity.ok().body(car);
    }

}
