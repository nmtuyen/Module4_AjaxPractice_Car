package com.codegym.controller;


import com.codegym.model.Producer;
import com.codegym.service.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producers")
@CrossOrigin("*")
public class ProducerController {
    @Autowired
    private IProducerService producerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Producer>> findAll(){
        return new ResponseEntity<>(producerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producer> saveNew(@RequestBody Producer producer){
        if (producerService.findByName(producer.getName()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        producerService.save(producer);
        return new ResponseEntity<>(producerService.findById(producer.getId()).get(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producer> update(@PathVariable Long id, @RequestBody Producer producer){
        Optional<Producer> producerOptional = producerService.findById(id);
        if (!producerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (producer.getName().equals("")){
            producer.setName(producerOptional.get().getName());
        }
        if (producer.getCountry().equals("")){
            producer.setCountry(producerOptional.get().getCountry());
        }
        producer.setId(id);
        return new ResponseEntity<>(producerService.save(producer), HttpStatus.OK);
    }
}
