package com.codegym.controller;

import com.codegym.model.Car;
import com.codegym.service.car.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {
    @Autowired
    private ICarService carService;

    @GetMapping("")
    public ResponseEntity<Iterable<Car>> findAll(){
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Optional<Car>> saveNew(@RequestBody Car car){
        if (carService.findByName(car.getName()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        carService.save(car);
        return new ResponseEntity<>(carService.findById(car.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car){
        Optional<Car> carOptional = carService.findById(id);
        if (!carOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (car.getName().equals("")){
            car.setName(carOptional.get().getName());
        }
        if (car.getPrice()==0){
            car.setPrice(carOptional.get().getPrice());
        }
        if (car.getColor().equals("")){
            car.setColor(carOptional.get().getColor());
        }
        if (car.getProducer().equals("")) {
            car.setProducer(carOptional.get().getProducer());
        }
        if (car.getTypeCar().equals("")) {
            car.setTypeCar(carOptional.get().getTypeCar());
        }
        car.setId(id);

        return new ResponseEntity<>(carService.save(car), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable Long id){
        if (!carService.findById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        carService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<Iterable<Car>> findByName(@RequestParam String name){
        Iterable<Car> cars = carService.findAllByNameContaining(name);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Car>> searchName(@RequestParam String name){
        Iterable<Car> cars = carService.findAllByNameContaining(name);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}

