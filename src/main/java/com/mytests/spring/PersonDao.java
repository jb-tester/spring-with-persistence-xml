package com.mytests.spring;


import java.util.List;
import java.util.Optional;

public interface PersonDao {
    Optional<Person> getById(Long id);

    Long persist(Person p);

    List<Person> getAll();
}
