package com.coder.springbootmongodbapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coder.springbootmongodbapp.documents.Person;

import java.util.UUID;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}
