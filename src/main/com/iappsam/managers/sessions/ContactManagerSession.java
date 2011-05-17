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
		List<SupplierContact> scs = getAllSupplierContact();
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
		List<DivisionOfficeContact> pcs = getAllDivisionOfficeContact();
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
		List<PersonContact> pcs = getAllPersonContact();
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
		List<SupplierContact> scs = getAllSupplierContact();
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
		List<DivisionOfficeContact> pcs = getAllDivisionOfficeContact();
		for (DivisionOfficeContact pc : pcs) {
			result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	@Override
	public List<Contact> getAllContactsForPerson() throws TransactionException {
		// TODO Auto-generated method stub
		List<Contact> result = new ArrayList<Contact>();
		List<PersonContact> pcs = getAllPersonContact();
		for (PersonContact pc : pcs) {
			result.add(getContact(pc.getContactID()));
		}
		return result;
	}

	private List<SupplierContact> getAllSupplierContact()
			throws TransactionException {
		return getList(SupplierContact.class);
	}

	private List<DivisionOfficeContact> getAllDivisionOfficeContact()
			throws TransactionException {
		return getList(DivisionOfficeContact.class);
	}

	private List<PersonContact> getAllPersonContact()
			throws TransactionException {
		return getList(PersonContact.class);

	}
}
