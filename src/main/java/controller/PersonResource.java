package controller;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.Person;
import repository.PersonRepository;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private PersonRepository repository;

    @Inject
    public PersonResource(PersonRepository repository) {
        this.repository = repository;
    }

    @GET
    @Path("/getAll")
    public List<Person> listPersons() {
        List<Person> persons = repository.listAll();
        return persons;
    }

    @POST
    @Transactional
    @Path("/insert")
    public Person createPerson(Person person) {
        repository.persist(person);
        return person;
    }

    @GET
    @Path("/getbyId")
    public Person getbyId(@QueryParam("id") Long id){
        return repository.findById(id);
    }

    @GET
    @Path("/getbyId2/{id}")
    public Person getbyId2(Long id){
        return repository.findById(id);
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Boolean deletebyId(@QueryParam("id") Long id){
        return repository.deleteById(id);
    }

    @PUT
    @Transactional
    @Path("/update")
    public Person updatePerson(Person person) {
        Person data = repository.findById(person.getId());
        data.setName(person.getName());
        data.setBirth(person.getBirth());
        data.setStatus(person.getStatus());
        repository.persist(data);
        return data;
    }
    
}
