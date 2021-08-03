package com.codegym.controller;

import com.codegym.model.Producer;
import com.codegym.model.TypeCar;
import com.codegym.repository.ITypeCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeCars")
@CrossOrigin("*")
public class TypeCarController {
    @Autowired
    private ITypeCarRepository typeCarRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<TypeCar>> findAll(){
        return new ResponseEntity<>(typeCarRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeCar> saveNew(@RequestBody TypeCar typeCar){
        if (typeCarRepository.findByName(typeCar.getName()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        typeCarRepository.save(typeCar);
        return new ResponseEntity<>(typeCarRepository.findById(typeCar.getId()).get(), HttpStatus.CREATED);
    }
}
