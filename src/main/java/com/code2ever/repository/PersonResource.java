package com.code2ever.repository;

import com.code2ever.model.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GET
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{email}")
    public Person getPersonByEmail(@PathParam("email") String email) {
        return personRepository.findByEmail(email);
    }

    @POST
    public Response createPerson(Person person) {
        personRepository.savePerson(person);
        return Response.status(Response.Status.CREATED).build();
    }
}