package com.example.demo;

public class Student {

	public String firstName;

	public Student(String firstname) {
		this.firstName = firstname;

	}
	
	@Override
	public String toString() {
		return this.firstName;
		
	}

}
