package com.example.demo.domin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	@Id
	String id;
	String firstName;
	String lastName;
	int age;

	public Comment(String firstName, String lastName, int age) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
	}

	public String getfirstName() {
		return firstName;

	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getlastName() {
		return lastName;

	}

	public void setlastName(String lastName) {
		this.lastName = lastName;

	}
	public int getAge() {
		return age;

	}

	public void setAge(int age) {
		this.age = age;

	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "Person first Name:"+firstName+"Last Name:"+ lastName+"Age:"+age;

	}
	
	
}
