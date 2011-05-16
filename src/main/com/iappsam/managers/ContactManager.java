package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Contact;
import com.iappsam.managers.exceptions.TransactionException;

public interface ContactManager {

	void addContact(Contact contact) throws TransactionException;

	int saveContact(Contact contact) throws TransactionException;

	void updateContact(Contact contact) throws TransactionException;

	Contact getContact(int contactID) throws TransactionException;

	void removeContact(Contact contact) throws TransactionException;

	boolean containsContact(Contact contact) throws TransactionException;

	boolean containsContact(String data) throws TransactionException;

	List<Contact> getAllContacts() throws TransactionException;

//	List<Contact> getAllContactsBySupplier(int supplierID) throws TransactionException;
//
//	List<Contact> getAllContactsByDivisionOffice(int divisionOfficeID) throws TransactionException;
//
//	List<Contact> getAllContactsByPerson(int personID) throws TransactionException;
//
//	List<Contact> getAllContactsForSupplier() throws TransactionException;
//
//	List<Contact> getAllContactsForDivisionOffice() throws TransactionException;
//
//	List<Contact> getAllContactsForPerson() throws TransactionException;

}
