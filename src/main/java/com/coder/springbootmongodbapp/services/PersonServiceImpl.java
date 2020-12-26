package com.coder.springbootmongodbapp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.coder.springbootmongodbapp.documents.Person;
import com.coder.springbootmongodbapp.dto.PersonCreateDTO;
import com.coder.springbootmongodbapp.dto.PersonUpdateDTO;
import com.coder.springbootmongodbapp.repositories.PersonRepository;
import com.mongodb.MongoException;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person getPersonById(UUID id) {

		if (personRepository.findById(id).isPresent())
			return personRepository.findById(id).get();
		else
			throw new MongoException("Record not Found");
	}

	@Override
	public 	List<Person> getPersonByChosenCriteria(String firstName, String lastName, String age, String city) 
			{
		Query dynamicQuery = new Query();
		if (firstName != null && !firstName.equals("") ) 
		{
		   Criteria nameCriteria = Criteria.where("firstName").is(firstName);
		   dynamicQuery.addCriteria(nameCriteria);
		}
		if (lastName != null && !lastName.equals(""))
		{
		   Criteria phoneCriteria =     Criteria.where("lastName").is(lastName);
		   dynamicQuery.addCriteria(phoneCriteria);
		}
		if (age != null && !age.equals("")) 
		{
		   Criteria ageCriteria = Criteria.where("age").is(Integer.parseInt(age));
		   dynamicQuery.addCriteria(ageCriteria);
		}
		if (city != null && !city.equals(""))
		{
		   Criteria cityCriteria =     Criteria.where("city").is(city);
		   dynamicQuery.addCriteria(cityCriteria);
		}
	
		List<Person> result = mongoTemplate.find(dynamicQuery, Person.class);
		return result;
	}

	@Override
	public Person createPerson(PersonCreateDTO personCreateDTO) {

		Person person = new Person(personCreateDTO.getFirstName(), personCreateDTO.getLastName(),
				personCreateDTO.getAge(), personCreateDTO.getCity(), personCreateDTO.getRegistrationNumber());

		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(PersonUpdateDTO personUpdateDTO, UUID id) {
		if (personRepository.findById(id).isPresent()) {
			Person existingPerson = personRepository.findById(id).get();
			existingPerson.setAge(personUpdateDTO.getAge());
			existingPerson.setCity(personUpdateDTO.getCity());
			existingPerson.setFirstName(personUpdateDTO.getFirstName());
			existingPerson.setLastName(personUpdateDTO.getLastName());
			existingPerson.setRegistrationNumber(personUpdateDTO.getRegistrationNumber());

			return personRepository.save(existingPerson);
		} else
			throw new MongoException("Record not found");
	}

	@Override
	public Person deletePersonById(UUID id) {
		if (personRepository.findById(id).isPresent()) {
			Person person = personRepository.findById(id).get();
			personRepository.delete(person);
			return person;
		} else
			throw new MongoException("Record not found");
	}

	@Override
	public List<Person> getPersonAll() {
		if (personRepository.findAll().isEmpty())
			throw new MongoException("Record not found");
		else {
			List<Person> persons = personRepository.findAll();
			return persons;
		}

	}
}
