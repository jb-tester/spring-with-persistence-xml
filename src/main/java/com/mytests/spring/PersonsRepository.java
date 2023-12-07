package com.mytests.spring;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PersonsRepository implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Person> getById(Long id) {
        Person Person = entityManager.find(Person.class, id);
        return Optional.ofNullable(Person);
    }
    public List<Person> getAll(){
        return entityManager.createQuery("select Person from Person Person", Person.class).getResultList();
    }
    public Long persist(Person p) {
        entityManager.persist(p);
        return p.getId();
    }
}