package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Person_ID")
	private int personID;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Name")
	private String name;

	public Person() {
		super();
	}

	public Person(String title, String name) {
		super();
		this.title = title;
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public int getPersonID() {
		return personID;
	}

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name = name;
	}

}
