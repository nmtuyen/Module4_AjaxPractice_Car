package com.codegym.service.typeCar;

import com.codegym.model.TypeCar;
import com.codegym.repository.ITypeCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeCarService implements ITypeCarService{
    @Autowired
    private ITypeCarRepository typeCarRepository;

    @Override
    public Iterable<TypeCar> findAll() {
        return typeCarRepository.findAll();
    }

    @Override
    public Optional<TypeCar> findById(Long id) {
        return typeCarRepository.findById(id);
    }

    @Override
    public TypeCar save(TypeCar typeCar) {
        return typeCarRepository.save(typeCar);
    }

    @Override
    public void remove(Long id) {
        typeCarRepository.deleteById(id);
    }

    @Override
    public Iterable<TypeCar> findAllByNameContaining(String name) {
        return typeCarRepository.findAllByNameContaining(name);
    }

    @Override
    public Optional<TypeCar> findByName(String name) {
        return typeCarRepository.findByName(name);
    }
}
