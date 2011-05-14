package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Contact;
import com.iappsam.managers.exceptions.TransactionException;

public interface ContactManager {
	void addContact(Contact contact) throws TransactionException;

	int saveContact(Contact contact) throws TransactionException;

	void updateContact(Contact contact) throws TransactionException;

	Contact getContact(int contactId) throws TransactionException;

	void removeContact(Contact contact) throws TransactionException;

	boolean containsContact(Contact contact) throws TransactionException;

	boolean containsContact(String name) throws TransactionException;

	List getAllContacts() throws TransactionException;
}
