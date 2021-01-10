package com.coder.springbootmongodbapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.coder.springbootmongodbapp.documents.Person;
@Service
public class EmployeeService {
    
    @Autowired
    private RestTemplate restTemplate= new RestTemplate();

    public Person getEmployee(String id) {
	ResponseEntity resp = 
          restTemplate.getForEntity("http://localhost:8080/api/persons/" + id, Person.class);
        
	return resp.getStatusCode() == HttpStatus.OK ? (Person)resp.getBody() : null;
    }
    
    
    public Person createEmployee(String id, String string, int i, String string2, String string3) {
		  Person emp = new Person("dhia", "beji", 28, "grombalia", "string");

    	ResponseEntity resp = 
              restTemplate.postForEntity("http://localhost:8080/api/persons/" ,emp, Person.class);
            
    	return resp.getStatusCode() == HttpStatus.CREATED ? (Person)resp.getBody() : null;
        }


	public Person[] findAll() {
		ResponseEntity resp = 
		          restTemplate.getForEntity("http://localhost:8080/api/persons/All" ,Person[].class);
		        
			return resp.getStatusCode() == HttpStatus.OK ? (Person[])resp.getBody() : null;
		    }
	
	
	   public void deleteEmployee(String id) {
 		          restTemplate.delete("http://localhost:8080/api/persons/" + id, Person.class);
		        
 		    }

}


 