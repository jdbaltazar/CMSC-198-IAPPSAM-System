package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactTest {

	@Test
	public void sameContact() {
		Contact contact = new Contact();
		contact.setId(1);

		Contact contact2 = new Contact();
		contact2.setId(1);

		assertEquals(contact, contact2);
	}
}
