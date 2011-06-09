package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Contact;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

/*
 * use unsupported exception
 * */

public class ContactManagerSession extends AbstractManager implements ContactManager {

	@Override
	public void addContact(Contact contact) throws TransactionException {
		add(contact);
	}

	@Override
	public void updateContact(Contact contact) throws TransactionException {
		update(contact);
	}

	@Override
	public Contact getContact(int contactID) throws TransactionException {
		return (Contact) get(Contact.class, contactID);
	}

	@Override
	public void removeContact(Contact contact) throws TransactionException {
		remove(contact);
	}

	@Override
	public boolean containsContact(Contact contact) throws TransactionException {
		return (getContact(contact.getContactID()) != null);
	}

	@Override
	public boolean containsContact(String data) throws TransactionException {
		List<Contact> contacts = getAllContacts();
		for (Contact c : contacts) {
			if (c.getData().equalsIgnoreCase(data))
				return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() throws TransactionException {
		return getAll(Contact.class);
	}
}
