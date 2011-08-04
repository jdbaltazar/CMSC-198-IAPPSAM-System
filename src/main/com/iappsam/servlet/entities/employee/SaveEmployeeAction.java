package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.logging.Logger;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveEmployeeAction implements Action {

	private String title;
	private String name;
	private String[] designation = new String[5];
	private String[] employeeNo = new String[5];
	private String[] divisionOfficeID = new String[5];
	private String mobile;
	private String landline;
	private String email;
	private boolean validAllEmployees = true;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// employments go here

		// if valid all, save then view all employees
		// else, return page and show the inputs except for the wrong ones

		try {
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
			Person person = new Person();
			if (Validator.validField(title)) {
				title = title.trim();
				person.setTitle(title);
			}
			if (Validator.validField(name)) {
				name = name.trim();
				person.setName(name);
			}
			if (Validator.validField(mobile)) {
				mobile = mobile.trim();
				person.addContact(new Contact(mobile, ContactType.MOBILE));
			}
			if (Validator.validField(landline)) {
				landline = landline.trim();
				person.addContact(new Contact(landline, ContactType.LANDLINE));
			}
			if (Validator.validField(email)) {
				email = email.trim();
				person.addContact(new Contact(email, ContactType.EMAIL));
			}
			validAllEmployees = checkAndFormatEmployments(designation, employeeNo, divisionOfficeID);
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
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
			System.out.println("title: " + person.getTitle());
			System.out.println("name: " + person.getName());
			System.out.println("---contacts start here-----");
			for (Contact c : person.getContacts()) {
				System.out.println(c.getType().toString() + ": " + c.getData());
			}
			System.out.println("---employments start here-----");
			for (Employee e : person.getEmployments()) {
				System.out.println(e.getDesignation() + ": " + e.getEmployeeNumber() + ": " + (e.getDivisionOffice() == null ? "" : e.getDivisionOffice().getDivisionName()));
			}
			if (validAllEmployees && person.validate()) {

				try {

					savePerson(person, request, response);
					Logger.log(request, "Employee \""+name+"\" was added");
					System.out.println("employee was saved!!!!!!!");
					return;

				} catch (Exception e) {
					Action action = new AddEmployeeAction();
					Employee[] employments = new Employee[5];
					for (int i = 0; i < 5; i++) {
						employments[i] = new Employee("", "", person);
						if (Validator.validField(designation[i])) {
							employments[i].setDesignation(designation[i].trim());
						}
						if (Validator.validField(employeeNo[i]))
							employments[i].setEmployeeNumber(employeeNo[i].trim());
						if (divisionOfficeID[i] != null) {
							DivisionOffice d = doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i]));
							if (d != null) {
								employments[i].setDivisionOffice(d);
							}
						}
					}

					List<DivisionOffice> dOffices = doManager.getAllDivisionOffice();

					request.setAttribute("person", person);
					request.setAttribute("employments", employments);
					request.setAttribute("divOffices", dOffices);
					request.setAttribute("mobile", mobile);
					request.setAttribute("landline", landline);
					request.setAttribute("email", email);

					action.process(request, response);
					return;
				}
			} else {
				// send the person (incomplete data)
				Action action = new AddEmployeeAction();
				Employee[] employments = new Employee[5];
				for (int i = 0; i < 5; i++) {
					employments[i] = new Employee("", "", person);
					if (Validator.validField(designation[i]))
						employments[i].setDesignation(designation[i].trim());
					if (Validator.validField(employeeNo[i]))
						employments[i].setEmployeeNumber(employeeNo[i].trim());
					if (divisionOfficeID[i] != null) {
						DivisionOffice d = doManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i]));
						if (d != null) {
							employments[i].setDivisionOffice(d);
						}
					}
				}

				List<DivisionOffice> dOffices = doManager.getAllDivisionOffice();

				request.setAttribute("person", person);
				request.setAttribute("employments", employments);
				request.setAttribute("divOffices", dOffices);
				request.setAttribute("mobile", mobile);
				request.setAttribute("landline", landline);
				request.setAttribute("email", email);

				action.process(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void savePerson(Person person, HttpServletRequest request, HttpServletResponse response) throws TransactionException, ServletException, IOException, DuplicateEntryException {
		PersonManager pManager = new PersonManagerSession();
		pManager.addPerson(person);
		Action viewAction = new SearchEmployeesAction();
		viewAction.process(request, response);
		return;
	}

	private boolean checkAndFormatEmployments(String[] designation, String[] employeeNo, String[] divisionOfficeID) throws NumberFormatException {

		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
