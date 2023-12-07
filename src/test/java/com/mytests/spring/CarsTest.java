package com.mytests.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class CarsTest {

    @Autowired
    private CarsDao carsDao;

    @Test
    public void checkGetById() {
        Car car = new Car("Audi","q7", LocalDate.now());
         carsDao.persist(car);

        Optional carFetched = carsDao.getById(car.getId());
        Assert.assertTrue(carFetched.isPresent());
    }

    @Test
    public void checkGetAll() {
        Car car1 = new Car("BMW","X5",LocalDate.now());
        carsDao.persist(car1);
        Car car2 = new Car("Skoda","Fabia", LocalDate.now());
        carsDao.persist(car2);
        List<Car> carFetched = carsDao.getAll();
        for (Car car : carFetched) {
            System.out.println(car);
        }
        Assert.assertEquals(carFetched.size(),3);
    }
}