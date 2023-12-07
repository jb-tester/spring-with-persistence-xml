package com.mytests.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class PersonsTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void checkGetById() {
        Person Person = new Person("vasya");
         personDao.persist(Person);

        Optional PersonFetched = personDao.getById(Person.getId());
        Assert.assertTrue(PersonFetched.isPresent());
    }

    @Test
    public void checkGetAll() {
        Person Person1 = new Person("sasha");
        personDao.persist(Person1);
        Person Person2 = new Person("masha");
        personDao.persist(Person2);
        List<Person> PersonFetched = personDao.getAll();
        for (Person Person : PersonFetched) {
            System.out.println(Person);
        }
        Assert.assertEquals(PersonFetched.size(),3);
    }
}