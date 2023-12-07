package com.mytests.spring;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CarsRepository implements CarsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Car> getById(Long id) {
        Car car = entityManager.find(Car.class, id);
        return Optional.ofNullable(car);
    }
    public List<Car> getAll(){
        List<Car> cars = entityManager.createQuery("select car from Car car", Car.class).getResultList();
        return cars;
    }
    public Long persist(Car c) {
        entityManager.persist(c);
        return c.getId();
    }
}