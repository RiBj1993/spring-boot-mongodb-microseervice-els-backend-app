package com.coder.springbootmongodbapp.services;

import java.util.List;
import java.util.UUID;

import com.coder.springbootmongodbapp.documents.Person;
import com.coder.springbootmongodbapp.dto.PersonCreateDTO;
import com.coder.springbootmongodbapp.dto.PersonUpdateDTO;

public interface PersonService {

    public Person getPersonById(UUID id);
    public List<Person> getPersonAll();
    public Person createPerson(PersonCreateDTO personCreateDTO);
    public Person updatePerson(PersonUpdateDTO personUpdateDTO, UUID id);
    public Person deletePersonById(UUID id);
    public List<Person> getPersonByChosenCriteria(String firstName, String lastName, String age, String city);
}
