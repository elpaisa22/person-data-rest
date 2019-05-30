package app.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.rest.models.Person;
import app.rest.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Person> getById(@PathVariable("id") Long id) {
        return this.service.getById(id);
    }

	@RequestMapping(method = RequestMethod.GET)
    public List<Person> list() {
        return (List<Person>) this.service.list();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Person info) {
		this.service.add(info);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Person info) {
    	this.service.update(info);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	this.service.delete(id);
    }
    
    @RequestMapping(value = "/findByLastName/{name}", method = RequestMethod.GET)
    public List<Person> getByName(@PathVariable("name") String name) {
        return this.service.getByLastName(name);
    }

}
