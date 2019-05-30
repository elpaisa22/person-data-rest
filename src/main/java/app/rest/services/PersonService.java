package app.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import app.rest.models.Person;
import app.rest.repositories.PersonRepository;

@Component
public class PersonService {

	@Autowired
	private PersonRepository repository;

    public Optional<Person> getById(Long id) {
        return this.repository.findById(id);
    }

    public List<Person> list() {
        return (List<Person>) this.repository.findAll();
    }
	
    public void add(@RequestBody Person info) {
		this.repository.save(info);
    }

    public void update(Person info) {
    	this.repository.save(info);
    }

    public void delete(Long id) {
    	this.repository.deleteById(id);
    }
    
    public List<Person> getByLastName(String lastName) {
        return this.repository.findByLastName(lastName);
    }
    
}
