package com.coder.springbootmongodbapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coder.springbootmongodbapp.documents.Person;
import com.coder.springbootmongodbapp.dto.PersonCreateDTO;
import com.coder.springbootmongodbapp.dto.PersonUpdateDTO;
import com.coder.springbootmongodbapp.services.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> getPerson(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/persons/All")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Person>> getPersons(){
        return new ResponseEntity<>(personService.getPersonAll(), HttpStatus.OK);
    }
    
	@GetMapping(value = "/persons/getPersonByChosenCriteria")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Person>> getPersonByChosenCriteria(@RequestParam List<String> values) {
		return new ResponseEntity<>(
				personService.getPersonByChosenCriteria(values.get(0), values.get(1), values.get(2), values.get(3)),
				HttpStatus.OK);

	}

    @PostMapping(value = "/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> createPerson(@RequestBody PersonCreateDTO personCreateDTO){
        return new ResponseEntity<>(personService.createPerson(personCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> updatePerson(@RequestBody PersonUpdateDTO personUpdateDTO, @PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(personService.updatePerson(personUpdateDTO, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Person> deletePerson(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(personService.deletePersonById(id), HttpStatus.OK);
    }
}
