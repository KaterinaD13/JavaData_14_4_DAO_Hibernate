package ru.nrtology.jdata_14_4_hibernate;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nrtology.jdata_14_4_hibernate.repository.Repository;


@SpringBootApplication
public class Jdata144HibernateApplication implements CommandLineRunner {

    @Autowired
    Repository repository;

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Jdata144HibernateApplication.class);
        application.run(args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        repository.generatePerson();
    }
}