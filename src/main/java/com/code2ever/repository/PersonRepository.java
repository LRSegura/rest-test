package com.code2ever.repository;

import com.code2ever.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Repository class for Person entity, providing abstraction for database operations.
 * This class uses PanacheRepository to manage Person entities.
 */
@ApplicationScoped
@Slf4j
public class PersonRepository implements PanacheRepository<Person> {
    
    /**
     * Find a Person by email.
     *
     * @param email the email to search for.
     * @return the Person entity matching the email, or null if none is found.
     */
    public Person findByEmail(String email) {
        return find("email", email).firstResult();
    }
    
    /**
     * Retrieve all people with a matching first name.
     *
     * @param firstName the first name to search for.
     * @return a list of Person entities with the specified first name.
     */
    public List<Person> findByFirstName(String firstName) {
        return list("firstName", firstName);
    }

    @Transactional
    public void savePerson(Person person) {
        persist(person);
        log.info("Saved person: {}", person);
    }
}