package com.codegym.service.car;

import com.codegym.model.Car;
import com.codegym.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService implements ICarService{
    @Autowired
    private ICarRepository carRepository;

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void remove(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Iterable<Car> findAllByNameContaining(String name) {
        return carRepository.findAllByNameContaining(name);
    }

    @Override
    public Optional<Car> findByName(String name) {
        return carRepository.findByName(name);
    }
}
