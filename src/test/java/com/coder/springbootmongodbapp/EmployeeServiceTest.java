package com.coder.springbootmongodbapp;

 import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.mockito.runners.MockitoJUnitRunner;

import com.coder.springbootmongodbapp.documents.Person;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	
 
    @Mock
    private RestTemplate restTemplate= new RestTemplate();

    @InjectMocks
    private EmployeeService empService = new EmployeeService();

    @Test
      void findPersonById() {
        Person emp = new Person("dhia", "beji", 28, "grombalia", "string");
        Person employee = empService.getEmployee("13baa966-01e0-44d4-a2c2-60d1f268602e");
        Assert.assertEquals(emp.getFirstName(), employee.getFirstName());
    }
    
    
	@Test
    public void createPerson() {
 	        Person employee = empService.createEmployee("dhia", "beji", 28, "grombalia", "string");
	        Assert.assertNotNull( employee.getFirstName());
        
    }
	
    @Test
    public void findAllPersons() {
        Person[] books = empService.findAll();
        assertNotNull(books);
      //  assertTrue(!books.isEmpty());
    }
 
	
	
}