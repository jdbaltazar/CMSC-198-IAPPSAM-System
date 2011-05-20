package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void samePerson() {
		Person p = new Person();
		p.setPersonID(1);

		Person p2 = new Person();
		p2.setPersonID(1);

		assertEquals(p, p2);
	}
}
