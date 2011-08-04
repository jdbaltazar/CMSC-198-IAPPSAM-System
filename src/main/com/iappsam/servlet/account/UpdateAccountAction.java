package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.AccountType;
import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
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
import com.iappsam.util.EntryFormatter;

public class UpdateAccountAction implements Action{
	private EntryFormatter entryFormatter = new EntryFormatter();

	private String title;
	private String name;
	private String userName;
	private String password;
	private String reenterPassword;
	private String acctType;
	private String oldPassword;

	private String[] designation;
	private String[] employeeNo;
	private String[] divisionOfficeID;

	private String mobileNumber;
	private String landline;
	private String emailad;
	private AccountManager aManager = new AccountManagerSession();

	public void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		title = entryFormatter.spaceTrimmer(request.getParameter("title"));
		name = entryFormatter.spaceTrimmer(request.getParameter("name"));
		oldPassword = request.getParameter("password");
		password = request.getParameter("newPassword");
		reenterPassword = request.getParameter("reenterPassword");
		acctType = request.getParameter("accountType");
		userName = request.getParameter("username");
		mobileNumber = entryFormatter.spaceTrimmer(request
				.getParameter("cellphoneNumber"));
		landline = entryFormatter
				.spaceTrimmer(request.getParameter("landline"));
		emailad = entryFormatter
				.spaceTrimmer(request.getParameter("e-mail_ad"));
		designation = request.getParameterValues("designation");
		employeeNo = request.getParameterValues("empNo3");
		divisionOfficeID = request.getParameterValues("divisionOffice");

		for (int i = 0; i < designation.length; i++) {
			designation[i] = entryFormatter.spaceTrimmer(designation[i]);
			employeeNo[i] = entryFormatter.spaceTrimmer(employeeNo[i]);
		}
		try {
			if (!name.isEmpty()
					&& !userName.isEmpty()
					&& !password.isEmpty()
					&& !reenterPassword.isEmpty()
					&& password.equalsIgnoreCase(reenterPassword)
					&& aManager.getAccount(userName).comparePassword(
							oldPassword) && entryFormatter.check(name)) {
				acceptResponse(request, response);
			} else {

				failedResponse(request, response);
			}
		} catch (TransactionException e) {
			failedResponse(request, response);
		}
	}

	private void acceptResponse(HttpServletRequest request,
			HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		Person person;
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		ContactManager cManager = new ContactManagerSession();
		if (name != null && userName != null && password != null
				&& reenterPassword != null
				&& password.equalsIgnoreCase(reenterPassword)) {
			try {

				Account account = aManager.getAccount(userName);
				account.setPassword(password);
				if (acctType
						.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE
								.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE);
				} else if (acctType
						.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_HEAD
								.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_HEAD);
				} else if (acctType.equalsIgnoreCase(AccountType.SPSO_PERSONNEL
						.toString())) {
					account.setType(AccountType.SPSO_PERSONNEL);
				} else if (acctType.equalsIgnoreCase(AccountType.SYSTEM_ADMIN
						.toString())) {
					account.setType(AccountType.SYSTEM_ADMIN);
				}
				aManager.updateAccount(account);
				person = account.getPerson();
				request.setAttribute("account", account);
				Contact[] contacts = new Contact[person.getContacts().size()];
				person.getContacts().toArray(contacts);
				ArrayList<Contact> mobileList = new ArrayList<Contact>();
				ArrayList<Contact> landlineList = new ArrayList<Contact>();
				ArrayList<Contact> emailList = new ArrayList<Contact>();
				if (contacts != null) {

					for (int i = 0; i < contacts.length; i++) {
						if (contacts[i].getType().equals(ContactType.EMAIL))
							emailList.add(contacts[i]);

						if (contacts[i].getType().equals(ContactType.MOBILE))
							mobileList.add(contacts[i]);

						if (contacts[i].getType().equals(ContactType.LANDLINE))
							landlineList.add(contacts[i]);
					}
				}
				if (title != null && !title.equalsIgnoreCase("null")
						&& !title.isEmpty()) {
					person.setTitle(title);
					person.setName(name);
				} else
					person.setName(name);
				if (emailad != null && emailList.isEmpty()
						&& !emailad.isEmpty()) {
					Contact email = new Contact();
					email.setData(emailad);
					email.setType(ContactType.EMAIL);
					person.addContact(email);
				}
				for (int i = 0; i < emailList.size(); i++)
					if (emailad != null && !emailad.equalsIgnoreCase("null")
							&& !emailad.isEmpty()) {
						Contact email = new Contact();
						if (i < emailList.size()) {
							email = emailList.get(i);
							email.setData(emailad);
							cManager.addContact(email);
						}

					}
				if (landline != null && landlineList.isEmpty()
						&& !landline.isEmpty()) {

					Contact landline2 = new Contact();
					landline2.setData(landline);
					landline2.setType(ContactType.LANDLINE);
					person.addContact(landline2);
				}
				for (int i = 0; i < landlineList.size(); i++)
					if (landline != null && !landline.equalsIgnoreCase("null")
							&& !landline.isEmpty()) {
						Contact landline2 = new Contact();

						if (i < landlineList.size()) {
							landline2 = landlineList.get(i);
							landline2.setData(landline);
							landline2.setType(landlineList.get(i).getType());
							landline2.setId(landlineList.get(i).getContactID());
							cManager.updateContact(landline2);
						}
					}
				if (mobileNumber != null && mobileList.isEmpty()
						&& !mobileNumber.isEmpty()) {
					Contact mobile = new Contact();
					mobile.setData(mobileNumber);
					mobile.setType(ContactType.MOBILE);
					person.addContact(mobile);
				}
				for (int i = 0; i < mobileList.size(); i++)
					if (mobileNumber != null
							&& !mobileNumber.equalsIgnoreCase("null")
							&& !mobileNumber.isEmpty()) {
						Contact mobile = new Contact();
						if (i < mobileList.size()) {
							mobile = mobileList.get(i);
							mobile.setData(mobileNumber);
							mobile.setType(mobileList.get(i).getType());
							mobile.setId(mobileList.get(i).getContactID());
							cManager.updateContact(mobile);
						}
					}

				List<Employee> empList = pManager.getEmployeeByPerson(person
						.getId());
				System.out.println("EmployeeList Number:" + empList.size());
				for (int i = 0; i < designation.length; i++) {
					if (designation[i].isEmpty())
						continue;
					Employee employee = new Employee();
					if (i < empList.size())
						employee = empList.get(i);
					employee = empList.get(i);
					employee.setDesignation(designation[i]);
					employee.setEmployeeNumber(employeeNo[i]);
					try {
						employee.setDivisionOffice(dManager
								.getDivisionOffice(Integer
										.parseInt(divisionOfficeID[i])));
						pManager.updateEmployee(employee);
						empList.add(employee);
					} catch (NumberFormatException e) {
						failedResponse(request, response);
					} catch (Exception e) {
						failedResponse(request, response);
					}
					try {
						pManager.updatePerson(person);
					} catch (DuplicateEntryException e) {
						failedResponse(request, response);
					}
				}
				request.setAttribute("employeeID", empList.get(0).getId());

				request.setAttribute("person", person);
				request.setAttribute("userName", userName);
			} catch (TransactionException e) {
				failedResponse(request, response);
			}
			try {

				RequestDispatcher view = request
						.getRequestDispatcher("ViewAccounts.do");
				view.forward(request, response);
			} catch (ServletException e) {
				failedResponse(request, response);
			} catch (IOException e) {
				failedResponse(request, response);
			}
		}
	}
	private void failedResponse(HttpServletRequest request,
			HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameOK", "false");
		else
			request.setAttribute("nameOK", "true");
		if (password.isEmpty() || !password.equalsIgnoreCase(reenterPassword))
			request.setAttribute("passwordOK", "false");
		else
			request.setAttribute("passwordOK", "true");

		RequestDispatcher view = request
				.getRequestDispatcher("update_account.jsp");
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
