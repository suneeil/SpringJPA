package com.example.jpaDemo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    //connection to database
    @PersistenceContext
    EntityManager entityManager; //EntityManager manages all the entities, all the operation that you are performing in a
    //specific session are stored in Entity manager, EntityManager is the interface to Persistence Manager
    //All operation should be going through EntityManager


    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person updatePerson(Person person) {
        return entityManager.merge(person); //If the person exists it updates else creates a new Person in DB
    }

    public void deletePersonById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }

}
