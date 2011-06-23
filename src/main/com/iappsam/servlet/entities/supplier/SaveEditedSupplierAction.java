package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Supplier;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.util.Verifier;

public class SaveEditedSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		String supplierID = request.getParameter("supplierID");
		String supplierName = request.getParameter("supplierName");
		String address = request.getParameter("supplierAddress");
		String tin = request.getParameter("tin");

		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String employeeNumber = request.getParameter("employeeNumber");
		String mobileNumber = request.getParameter("mobileNumber");
		String landline = request.getParameter("landline");
		String emailad = request.getParameter("emailad");

		SupplierManager sManager = new SupplierManagerSession();
		ContactManager cManager = new ContactManagerSession();
		PersonManager pManager = new PersonManagerSession();
		RequestDispatcher update = request.getRequestDispatcher(SupplierServlet.VIEW_SUPPLIER);

		Supplier supplier = sManager.getSupplier(Integer.parseInt(supplierID));

		System.out.println("name: " + name);
		System.out.println("title: " + title);
		Person person = pManager.getPerson(supplier.getContactPerson().getPerson().getId());
		person.setTitle(title);
		if (Verifier.validEntry(name))
			person.setName(name);

		Set<Contact> contacts = person.getContacts();

		boolean found = false;
		for (Contact c : contacts) {
			if (c.getType().equals(ContactType.MOBILE)) {
				found = true;
				c.setData(mobileNumber);
				cManager.updateContact(c);
			}
		}
		if (!found && mobileNumber != null)
			person.addContact(new Contact(mobileNumber, ContactType.MOBILE));

		found = false;
		for (Contact c : contacts) {
			if (c.getType().equals(ContactType.LANDLINE)) {
				found = true;
				c.setData(landline);
				cManager.updateContact(c);
			}
		}
		if (!found && landline != null)
			person.addContact(new Contact(landline, ContactType.LANDLINE));

		found = false;
		for (Contact c : contacts) {
			if (c.getType().equals(ContactType.EMAIL)) {
				found = true;
				c.setData(emailad);
				cManager.updateContact(c);
			}
		}
		if (!found && landline != null)
			person.addContact(new Contact(emailad, ContactType.EMAIL));

		try {
			pManager.updatePerson(person);
		} catch (DuplicateEntryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Employee employee = pManager.getEmployee(supplier.getContactPerson().getId());
		if (Verifier.validEntry(designation))
			employee.setDesignation(designation);
		employee.setPerson(person);
		if (employeeNumber != null)
			employee.setEmployeeNumber(employeeNumber);

		if (Verifier.validEntry(supplierName))
			supplier.setSupplierName(supplierName);
		if (Verifier.validEntry(address))
			supplier.setAddress(address);
		supplier.setTin(tin);
		supplier.setContactPerson(employee);

		if (supplier.validate() && Verifier.validEntry(name) && (Verifier.validEntry(designation)) && Verifier.validEntry(supplierName)
				&& Verifier.validEntry(address)) {
			try {
				sManager.updateSupplier(supplier);
				update = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
				System.out.println("edited supplier was saved!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("edited supplier is not valid!!");
			request.setAttribute("supplier", supplier);
		}

		update.forward(request, response);
	}
}
