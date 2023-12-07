package com.mytests.spring;

import java.util.List;
import java.util.Optional;

public interface CarsDao {
    Optional<Car> getById(Long id);

    Long persist(Car c);

    List<Car> getAll();
}