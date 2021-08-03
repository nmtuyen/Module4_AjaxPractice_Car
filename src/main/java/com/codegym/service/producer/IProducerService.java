package com.codegym.service.producer;

import com.codegym.model.Producer;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IProducerService extends IGeneralService<Producer> {
    Iterable<Producer> findAllByNameContaining(String name);
    Optional<Producer> findByName(String name);
}
