package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveEditedEmployeeAction implements Action {

	private String personID;
	private String title;
	private String name;
	private String[] designation = new String[5];
	private String[] employeeNo = new String[5];
	private String[] divisionOfficeID = new String[5];
	private String mobile;
	private String landline;
	private String email;
	private boolean validName = false;
	private boolean validAllEmployees = true;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the size of save employments
		// if the same as old, update all
		// else, update all and add new

		// if valid all, save then view all employees
		// else, return page and show the inputs except for the wrong ones

		try {
			PersonManager pManager = new PersonManagerSession();
			ContactManager cManager = new ContactManagerSession();
			personID = request.getParameter("personID");
			title = request.getParameter("title");
			name = request.getParameter("name");
			for (int i = 1; i <= 5; i++) {
				designation[i - 1] = request.getParameter("designation" + i);
				employeeNo[i - 1] = request.getParameter("employeeNo" + i);
				divisionOfficeID[i - 1] = request.getParameter("divisionOffice" + i);
			}
			mobile = request.getParameter("mobileNumber");
			landline = request.getParameter("landline");
			email = request.getParameter("email_ad");
			System.out.println("----------------------->email: " + email);
			Person person = pManager.getPerson(Integer.parseInt(personID));
			if (Validator.validField(title)) {
				title = title.trim();
				person.setTitle(title);
			} else {
				person.setTitle(title);
			}
			if (Validator.validField(name)) {
				name = name.trim();
				person.setName(name);
			}
			Set<Contact> contacts = person.getContacts();
			boolean found = false;
			for (Contact c : contacts) {
				if (c.getType().equals(ContactType.MOBILE)) {
					found = true;
					c.setData(mobile);
					cManager.updateContact(c);
				}
			}
			if (!found && Validator.validField(mobile))
				person.addContact(new Contact(mobile, ContactType.MOBILE));
			found = false;
			for (Contact c : contacts) {
				if (c.getType().equals(ContactType.LANDLINE)) {
					found = true;
					c.setData(landline);
					cManager.updateContact(c);
				}
			}
			if (!found && Validator.validField(landline))
				person.addContact(new Contact(landline, ContactType.LANDLINE));
			found = false;
			for (Contact c : contacts) {
				if (c.getType().equals(ContactType.EMAIL)) {
					found = true;
					c.setData(email);
					cManager.updateContact(c);
				}
			}
			if (!found && Validator.validField(email))
				person.addContact(new Contact(email, ContactType.EMAIL));
			// // employments go here
			//
			validAllEmployees = checkAndFormatEmployments(designation, employeeNo, divisionOfficeID);
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
			if (validAllEmployees) {
				for (int i = 0; i < 5; i++) {
					if (Validator.validField(designation[i])) {
						Employee e = new Employee();
						e.setDesignation(designation[i].trim());

						if (Validator.validField(employeeNo[i])) {
							e.setEmployeeNumber(employeeNo[i].trim());
						}

						e.setDivisionOffice(doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i])));
						person.addEmployment(e);
					}
				}
			}
			System.out.println("title: " + person.getTitle());
			System.out.println("name: " + person.getName());
			System.out.println("---contacts start here-----");
			for (Contact c : person.getContacts()) {
				System.out.println(c.getType().toString() + ": " + c.getData());
			}
			System.out.println("---employments start here-----");
			// for (Employee e : person.getEmployments()) {
			// System.out.println(e.getDesignation() + ": " + e.getEmployeeNumber()
			// +
			// ": "
			// + (e.getDivisionOffice() == null ? "" :
			// e.getDivisionOffice().getDivisionName()));
			// }
			if (validName && validAllEmployees && person.validate()) {

				try {

					updatePerson(person, request, response);
					System.out.println("employee was saved!!!!!!!");
					return;

				} catch (Exception e) {
					Action vAction = new ViewEmployeeAction();
					request.setAttribute("personID", personID);
					vAction.process(request, response);
					return;
				}
			} else {
				Action vAction = new ViewEmployeeAction();
				request.setAttribute("personID", personID);
				vAction.process(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updatePerson(Person person, HttpServletRequest request, HttpServletResponse response) throws TransactionException, ServletException, IOException, DuplicateEntryException {
		PersonManager pManager = new PersonManagerSession();
		pManager.updatePerson(person);
		Action viewAction = new SearchEmployeesAction();
		viewAction.process(request, response);
		return;
	}

	private boolean checkAndFormatEmployments(String[] designation, String[] employeeNo, String[] divisionOfficeID) throws NumberFormatException, TransactionException {

		boolean designationsNonempty = false, divisionOfficeNonempty = false, matched = true;
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();

		for (int i = 0; i < 5; i++) {

			// if designation is empty
			if (Validator.validField(designation[i])) {
				designation[i] = designation[i].trim();
				designationsNonempty = true;

				// if designation is set but division is not
				if (doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i])) == null) {
					matched = false;
				}
			}

			// if divisionoffice is empty
			if (divisionOfficeID[i] != null) {
				if (doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i])) != null) {
					divisionOfficeNonempty = true;

					// if divisionoffice is set but designation is not
					if (!Validator.validField(designation[i])) {
						matched = false;
					}
				}
			}

			// if employeenumber is set but designation or divisionoffice is not
			if (Validator.validField(employeeNo[i])) {
				employeeNo[i] = employeeNo[i].trim();
				if (!Validator.validField(designation[i])) {
					matched = false;
				}
				if (doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i])) == null) {
					matched = false;
				}
			}

		}

		if (designationsNonempty && divisionOfficeNonempty && matched)
			return true;
		return false;
	}

}
