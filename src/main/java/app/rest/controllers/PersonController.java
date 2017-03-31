package app.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.rest.models.Person;
import app.rest.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person getById(@PathVariable("id") Long id) {
        return this.repository.findOne(id);
    }

	@RequestMapping(method = RequestMethod.GET)
    public List<Person> list() {
        return (List<Person>) this.repository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Person info) {
		this.repository.save(info);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Person info) {
    	this.repository.save(info);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	this.repository.delete(id);
    }
}
