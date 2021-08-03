package com.codegym.service.typeCar;

import com.codegym.model.Producer;
import com.codegym.model.TypeCar;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface ITypeCarService extends IGeneralService<TypeCar> {
    Iterable<TypeCar> findAllByNameContaining(String name);
    Optional<TypeCar> findByName(String name);
}
