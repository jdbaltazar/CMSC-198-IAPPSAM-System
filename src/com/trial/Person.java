package com.trial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Person_ID", nullable = false)
	private int id;

	@Column(name = "Title", nullable = true, length = 45)
	private String title;
	
	@Column(name = "Name", nullable = false, length = 100)
	private String name;
	
	public Person() {
		super();
	}

	public Person(String title, String name) {
		this();
		setTitle(title);
		setName(name);
	}
	
	public Person(String name) {
		super();
		setName(name);
	}

	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setName(String name) {
		this.name = name;
	}

}
