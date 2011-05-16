package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Contact;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.Manager;
import com.iappsam.managers.exceptions.TransactionException;

public class ContactManagerSession extends Manager implements ContactManager {

	@Override
	public void addContact(Contact contact) throws TransactionException {
		// TODO Auto-generated method stub
		add(contact);
	}

	@Override
	public int saveContact(Contact contact) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(contact);
	}

	@Override
	public void updateContact(Contact contact) throws TransactionException {
		// TODO Auto-generated method stub
		update(contact);
	}

	@Override
	public Contact getContact(int contactID) throws TransactionException {
		// TODO Auto-generated method stub
		return (Contact) get(Contact.class, contactID);
	}

	@Override
	public void removeContact(Contact contact) throws TransactionException {
		// TODO Auto-generated method stub
		remove(contact);
	}

	@Override
	public boolean containsContact(Contact contact) throws TransactionException {
		return (getContact(contact.getContactID()) != null);
	}

	@Override
	public boolean containsContact(String data) throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> contacts = getList(Contact.class);
		for (Contact c: contacts) {
			if (c.getData().equalsIgnoreCase(data))
				return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Contact.class);
	}

	

}
