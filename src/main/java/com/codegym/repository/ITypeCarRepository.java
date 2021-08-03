package com.codegym.repository;

import com.codegym.model.Producer;
import com.codegym.model.TypeCar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITypeCarRepository extends CrudRepository<TypeCar, Long> {
    Iterable<TypeCar> findAllByNameContaining(String name);
    Optional<TypeCar> findByName(String name);
}
