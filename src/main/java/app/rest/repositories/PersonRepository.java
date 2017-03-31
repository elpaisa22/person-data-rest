package app.rest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.rest.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);

}
