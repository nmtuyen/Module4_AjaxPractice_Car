package com.codegym.repository;

import com.codegym.model.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProducerRepository extends CrudRepository<Producer, Long> {
    Iterable<Producer> findAllByNameContaining(String name);
    Optional<Producer> findByName(String name);
}
