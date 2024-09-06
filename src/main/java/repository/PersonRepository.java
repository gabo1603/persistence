package repository;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import model.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{
   
}
