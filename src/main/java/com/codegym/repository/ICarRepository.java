package com.codegym.repository;

import com.codegym.model.Car;
import com.codegym.model.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICarRepository extends CrudRepository<Car, Long> {
    Iterable<Car> findAllByNameContaining(String name);
    Optional<Car> findByName(String name);
}
