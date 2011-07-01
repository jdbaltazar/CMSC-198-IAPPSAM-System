package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Person;

public class PersonTest {

	private Person p;
	private Person p2;

	@Before
	public void init() {
		p = new Person("title", "name");
		p2 = new Person("title", "name");
	}

	@Test
	public void shouldNotBeEqualWithDiffTitle() {
		p2.setTitle("title2");
		assertFalse(p.equals(p2));
	}

	@Test
	public void shouldNotBeEqualWithDiffName() {
		p2.setName("name2");
		assertFalse(p.equals(p2));
	}

	@Test
	public void shouldNotBeEqualWithDifferentContact() {
		p.addContact(new Contact("data", ContactType.EMAIL));
		p2.addContact(new Contact("data2", ContactType.EMAIL));
		assertFalse(p.equals(p2));
	}

	@Test
	public void nameTrimmed() {
		p.setName(" name ");
		assertEquals("name", p.getName());
	}

	@Test
	public void titleTrimmed() {
		p.setTitle(" title ");
		assertEquals("title", p.getTitle());
	}
}
