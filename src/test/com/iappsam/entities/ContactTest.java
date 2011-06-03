package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactTest {

	@Test
	public void sameContact() {
		Contact contact = new Contact("data", ContactType.EMAIL);
		Contact contact2 = new Contact("data", ContactType.EMAIL);

		assertEquals(contact, contact2);
	}
}
