package com.iappsam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
public class Person implements Validatable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Person_ID")
	private int id;

	@Field(name = "title")
	@Column(name = "Title")
	private String title;

	@Field(name = "name")
	@Column(name = "Name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Person_Contact", joinColumns = @JoinColumn(name = "Person_ID"), inverseJoinColumns = @JoinColumn(name = "Contact_ID"))
	private Set<Contact> contacts = new HashSet<Contact>();

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Employee> employments = new HashSet<Employee>();

	public Person() {
		super();
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

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public void setId(int personID) {
		this.id = personID;
	}

	public void setTitle(String title) {
		if (title != null)
			this.title = title.trim();
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public boolean validate() {
		return name != null && !name.equals("");
	}

	public void setPerson(Person person) {
		id = person.id;
		title = person.title;
		name = person.name;
		contacts = person.contacts;
	}

	public Set<Employee> getEmployments() {
		return employments;
	}

	public void addEmployment(Employee employment) {
		employment.setPerson(this);
		employments.add(employment);
	}
}
