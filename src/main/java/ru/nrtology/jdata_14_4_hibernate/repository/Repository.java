package ru.nrtology.jdata_14_4_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.nrtology.jdata_14_4_hibernate.entity.Person;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    public Repository() {
    }

    @PersistenceContext
    private EntityManager manager;

    public List<Person> getPersonsByCity(String city) {
        return manager.createQuery("SELECT p FROM Person p WHERE p.city_of_living = :city")
                .setParameter("city", city).getResultList();
    }

    public void generatePerson() {
        Person person1 = Person.builder()
                .name("Pasha")
                .surname("Smirnov")
                .age(34)
                .phone_number(885494949)
                .city_of_living("Moscow")
                .build();
        Person person2 = Person.builder()
                .name("Katia")
                .surname("Morozova")
                .age(37)
                .phone_number(885354949)
                .city_of_living("Moscow")
                .build();
        Person person3 = Person.builder()
                .name("Misha")
                .surname("Ivanov")
                .age(20)
                .phone_number(885352849)
                .city_of_living("Tyla")
                .build();
        manager.persist(person1);
        manager.persist(person2);
        manager.persist(person3);
    }
}