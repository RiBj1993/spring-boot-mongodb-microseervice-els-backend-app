package com.coder.springbootmongodbapp.documents;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Person {

	@Id
	private UUID _id;

	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private String registrationNumber;

	public Person() {
	}

	public Person( String firstName, String lastName, int age, String city, String registrationNumber) {

		this._id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.registrationNumber = registrationNumber;
	}

	public UUID get_id() {
		return _id;
	}

	public void set_id(UUID _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
