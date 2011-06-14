package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.Contact;
import com.iappsam.ContactType;

public class ContactTest {

	@Test
	public void shouldNotBeEqualWithDiffData() {
		Contact contact = new Contact("data2", ContactType.EMAIL);
		Contact contact2 = new Contact("data", ContactType.EMAIL);

		assertFalse(contact.equals(contact2));
	}

	@Test
	public void shouldNotBeEqualWithDiffType() {
		Contact contact = new Contact("data", ContactType.FAX);
		Contact contact2 = new Contact("data", ContactType.EMAIL);

		assertFalse(contact.equals(contact2));
	}
}
