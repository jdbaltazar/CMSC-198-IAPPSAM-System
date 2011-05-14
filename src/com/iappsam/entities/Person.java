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
	@Column(name = "Person_ID", nullable = false)
	private int personID;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Name", nullable = false, length = 80)
	private String name;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String title, String name) {
		super();
		setTitle(title);
		setName(name);
	}

	public Person(String name) {
		super();
		setName(name);
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
