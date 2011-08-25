package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.AccountType;
import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.logging.Logger;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class UpdateOwnAccountAction implements Action {

	private String personID;
	private String title;
	private String name;
	private String[] designation = new String[5];
	private String[] employeeNo = new String[5];
	private String[] divisionOfficeID = new String[5];
	private String mobile;
	private String landline;
	private String email;
	private boolean validAllEmployees = true;
	private String username;
	private String newPassword;
	private String reenterPassword;
	private String accountType;
	private String password;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the size of save employments
		// if the same as old, update all
		// else update all and add new

		// if valid all, save then view all employees
		// else, return page and show the inputs except for the wrong ones

		try {
			PersonManager pManager = new PersonManagerSession();
			ContactManager cManager = new ContactManagerSession();
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
			AccountManager aManager = new AccountManagerSession();
			username = (String) request.getSession().getAttribute("username");
			password = request.getParameter("password");
			newPassword = request.getParameter("newPassword");
			reenterPassword = request.getParameter("reenterPassword");
			accountType = request.getParameter("accountType");

			title = request.getParameter("title");
			name = request.getParameter("name");
			for (int i = 1; i <= 5; i++) {
				designation[i - 1] = request.getParameter("designation" + i)
						.trim();
				employeeNo[i - 1] = request.getParameter("employeeNo" + i)
						.trim();
				divisionOfficeID[i - 1] = request.getParameter("divisionOffice"
						+ i);
			}
			request.setAttribute("designation", designation);
			request.setAttribute("employeeNo", employeeNo);
			request.setAttribute("divisionOfficeID", divisionOfficeID);
			mobile = request.getParameter("cellphoneNumber");
			landline = request.getParameter("landline");
			email = request.getParameter("e-mail_ad");

			Person person = aManager.getAccount(username).getPerson();
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
			if (!found && Validator.validField(mobile)) {

				person.addContact(new Contact(mobile, ContactType.MOBILE));
			}
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

			validAllEmployees = checkAndFormatEmployments(designation,
					employeeNo, divisionOfficeID);
			int validFields = countValidFields(designation, employeeNo,
					divisionOfficeID);
			List<Employee> employees = pManager.getEmployeeByPerson(person
					.getId());
			if (validAllEmployees) {

				// get previous employees
				// check if the >= in size
				// if ==, update all
				// if >, add new employees

				if (validFields >= employees.size()) {
					for (int i = 0; i < validFields; i++) {
						if (!Validator.validField(designation[i])
								|| !Validator.validField(divisionOfficeID[i])) {
							validAllEmployees = false;
						}
					}
				} else {
					validAllEmployees = false;
				}
			}

			if (validAllEmployees) {

				Set<Employee> emps = person.getEmployments();
				for (int i = 0; i < validFields; i++) {
					if (i < employees.size()) {
						// update old employee
						Employee e = getEmployeeOfPerson(emps, employees.get(i)
								.getId());
						if (e != null) {
							e.setDesignation(designation[i]);
							DivisionOffice dOffice = doManager
									.getDivisionOffice(Integer
											.parseInt(divisionOfficeID[i]));
							e.setDivisionOffice(dOffice);
							if (Validator.validField(employeeNo[i])) {
								e.setEmployeeNumber(employeeNo[i]);
							}
						}
					} else {
						// add new employee
						Employee e1 = new Employee();
						e1.setDesignation(designation[i]);
						DivisionOffice dOffice = doManager
								.getDivisionOffice(Integer
										.parseInt(divisionOfficeID[i]));
						e1.setDivisionOffice(dOffice);
						if (Validator.validField(employeeNo[i])) {
							e1.setEmployeeNumber(employeeNo[i]);
						}
						person.addEmployment(e1);
					}
				}
			}

			if (validAllEmployees && person.validate()) {
				try {

					Account account = aManager.getAccount(username);
					if (newPassword != null && reenterPassword != null) {

						if (!newPassword.isEmpty()
								&& !reenterPassword.isEmpty()
								&& newPassword
										.equalsIgnoreCase(reenterPassword)) {
							if (account.comparePassword(password))
								account.setPassword(newPassword);
							else {
								Action vAction = new ViewOwnAccountAction();
								request.setAttribute("username", username);
								vAction.process(request, response);
								return;
							}
						}

					} else {
						Action vAction = new ViewOwnAccountAction();
						request.setAttribute("username", username);
						vAction.process(request, response);
						return;
					}
					if (AccountType.SPSO_PERSONNEL.toString().equals(
							accountType))
						account.setType(AccountType.SPSO_PERSONNEL);
					aManager.updateAccount(account);

				} catch (Exception e) {
					e.printStackTrace();
					Action vAction = new ViewOwnAccountAction();
					request.setAttribute("username", username);
					vAction.process(request, response);
					return;
				}
			}
			if (validAllEmployees && person.validate()) {

				try {

					updatePerson(person, request, response);
					Logger.log(request, "Account \"" + username
							+ "\" was updated");
					request.getRequestDispatcher("/menu").forward(request,
							response);

				} catch (Exception e) {
					e.printStackTrace();
					Action vAction = new ViewOwnAccountAction();
					request.setAttribute("username", username);
					vAction.process(request, response);
				}
			} else {
				Action vAction = new ViewOwnAccountAction();
				request.setAttribute("username", username);
				vAction.process(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int countValidFields(String[] designation, String[] employeeNo,
			String[] divisionOfficeID) {
		// TODO Auto-generated method stub
		int count = 0;
		int SIZE = 5;
		for (int i = 0; i < SIZE; i++) {
			if (Validator.validField(designation[i])
					&& Validator.validField(divisionOfficeID[i])) {
				count++;
			}
		}

		return count;
	}

	private void updatePerson(Person person, HttpServletRequest request,
			HttpServletResponse response) throws TransactionException,
			ServletException, IOException, DuplicateEntryException {
		PersonManager pManager = new PersonManagerSession();
		pManager.updatePerson(person);
		return;
	}

	private boolean checkAndFormatEmployments(String[] designation,
			String[] employeeNo, String[] divisionOfficeID)
			throws NumberFormatException, TransactionException {

		// format all inputs

		int SIZE = countValidFields(designation, employeeNo, divisionOfficeID);
		boolean valid = true;

		for (int i = 0; i < SIZE; i++) {
			if (Validator.validField(designation[i])
					&& !Validator.validField(divisionOfficeID[i])) {
				valid = false;
			} else if (!Validator.validField(designation[i])) {
				valid = false;

			} else if (Validator.validField(employeeNo[i])
					&& !Validator.validField(designation[i])
					&& !Validator.validField(divisionOfficeID[i])) {
				valid = false;
			}
		}

		if (valid) {
			for (int i = 0; i < SIZE; i++) {
				designation[i] = designation[i].trim();
				if (Validator.validField(employeeNo[i])) {
					employeeNo[i] = employeeNo[i].trim();
				}
			}

		}

		return valid;
	}

	private Employee getEmployeeOfPerson(Set<Employee> emps, int employeeID) {
		Employee ret = null;
		for (Employee e : emps) {
			if (e.getId() == employeeID) {
				ret = e;
			}
		}
		return ret;
	}
}
