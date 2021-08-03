package com.codegym.service.car;

import com.codegym.model.Car;
import com.codegym.model.Producer;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface ICarService extends IGeneralService<Car> {
    Iterable<Car> findAllByNameContaining(String name);
    Optional<Car> findByName(String name);
}
