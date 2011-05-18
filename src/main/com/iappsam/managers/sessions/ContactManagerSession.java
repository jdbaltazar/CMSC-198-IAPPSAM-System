package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.Contact;
import com.iappsam.entities.DivisionOfficeContact;
import com.iappsam.entities.PersonContact;
import com.iappsam.entities.SupplierContact;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

/*
 * use unsupported exception
 * */

public class ContactManagerSession extends AbstractManager implements
		ContactManager {

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
		for (Contact c : contacts) {
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

	@Override
	public List<Contact> getAllContactsBySupplier(int supplierID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<SupplierContact> scs = getList(SupplierContact.class);
		for (SupplierContact sc : scs) {
			if (sc.getSupplierID() == supplierID)
				result.add(getContact(sc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsByDivisionOffice(int divisionOfficeID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<DivisionOfficeContact> pcs = getList(DivisionOfficeContact.class);
		for (DivisionOfficeContact pc : pcs) {
			if (pc.getDivisionOfficeID() == divisionOfficeID)
				result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsByPerson(int personID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<PersonContact> pcs = getList(PersonContact.class);
		for (PersonContact pc : pcs) {
			result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsForSupplier()
			throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<SupplierContact> scs = getList(SupplierContact.class);
		for (SupplierContact sc : scs) {
			result.add(getContact(sc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsForDivisionOffice()
			throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<DivisionOfficeContact> pcs = getList(DivisionOfficeContact.class);
		for (DivisionOfficeContact pc : pcs) {
			result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsForPerson() throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<PersonContact> pcs = getList(PersonContact.class);
		for (PersonContact pc : pcs) {
			result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	@Override
	public void addContactToPerson(int contactID, int personID)
			throws TransactionException {
		// TODO Auto-generated method stub
		PersonContact personContact = new PersonContact(personID, contactID);
		add(personContact);
	}

	@Override
	public void addContactToSupplier(int contactID, int supplierID)
			throws TransactionException {
		// TODO Auto-generated method stub
		SupplierContact supplierContact = new SupplierContact(supplierID,
				contactID);
		add(supplierContact);
	}

	@Override
	public void addContactToDivisionOffice(int contactID, int divisionOfficeID)
			throws TransactionException {
		// TODO Auto-generated method stub
		DivisionOfficeContact divisionOfficeContact = new DivisionOfficeContact(
				divisionOfficeID, contactID);
		add(divisionOfficeContact);
	}

	@Override
	public void removeContactFromPerson(int contactID, int personID)
			throws TransactionException {
		// TODO Auto-generated method stub
		PersonContact personContact = new PersonContact(personID, contactID);
		remove(personContact);
	}

	@Override
	public void addContactFromSupplier(int contactID, int supplierID)
			throws TransactionException {
		// TODO Auto-generated method stub
		SupplierContact supplierContact = new SupplierContact(supplierID,
				contactID);
		remove(supplierContact);
	}

	@Override
	public void addContactFromDivisionOffice(int contactID, int divisionOfficeID)
			throws TransactionException {
		// TODO Auto-generated method stub
		DivisionOfficeContact divisionOfficeContact = new DivisionOfficeContact(
				divisionOfficeID, contactID);
		remove(divisionOfficeContact);
	}

}
