package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;

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
import com.iappsam.logging.Logger;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.EntryFormatter;

public class SaveAccountAction implements Action {

	private String title;
	private String name;
	private ArrayList<String> designation;
	private ArrayList<String> employeeNo;
	private ArrayList<String> divisionOfficeID;
	private String username;
	private String password;
	private String reenterPassword;
	private String mobileNumber;
	private String landline;
	private String emailad;
	private String acctType;

	private EntryFormatter entry = new EntryFormatter();

	private void failedResponse(HttpServletRequest request,
			HttpServletResponse response) {
		if (name.isEmpty() || entry.check(name))
			request.setAttribute("nameOK", "false");
		else
			request.setAttribute("nameOK", "true");
		if (username.isEmpty() || entry.check(username))
			request.setAttribute("usernameOK", "false");
		else
			request.setAttribute("usernameOK", "true");
		if (password.isEmpty() || !password.equalsIgnoreCase(reenterPassword))
			request.setAttribute("passwordOK", "false");
		else
			request.setAttribute("passwordOK", "true");

		String designation1OK = null;
		if (designation.size() > 0 && employeeNo.size() > 0
				&& designation.get(0).isEmpty() && !employeeNo.get(0).isEmpty()) {
			designation1OK = "true";
		}
		String designation2OK = null;
		if (designation.size() > 1 && employeeNo.size() > 1
				&& designation.get(1).isEmpty() && !employeeNo.get(1).isEmpty()) {
			designation2OK = "true";
		}
		String designation3OK = null;
		if (designation.size() > 2 && employeeNo.size() > 2
				&& designation.get(2).isEmpty() && !employeeNo.get(2).isEmpty()) {
			designation3OK = "true";
		}
		String designation4OK = null;
		if (designation.size() > 3 && employeeNo.size() > 3
				&& designation.get(3).isEmpty() && !employeeNo.get(3).isEmpty()) {
			designation4OK = "true";
		}
		String designation5OK = null;
		if (designation.size() > 4 && employeeNo.size() > 4
				&& designation.get(4).isEmpty() && !employeeNo.get(4).isEmpty()) {
			designation5OK = "true";
		}

		RequestDispatcher view = request
				.getRequestDispatcher(AccountServlet.ADD_ACCOUNT);
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("designation", designation);
		request.setAttribute("designation1OK", designation1OK);
		request.setAttribute("designation2OK", designation2OK);
		request.setAttribute("designation3OK", designation3OK);
		request.setAttribute("designation4OK", designation4OK);
		request.setAttribute("designation5OK", designation5OK);
		request.setAttribute("employeeNo", employeeNo);
		request.setAttribute("userName", username);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("landline", landline);
		request.setAttribute("emailad", emailad);
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		title = entry.spaceTrimmer(request.getParameter("title"));
		name = entry.spaceTrimmer(request.getParameter("name"));

		designation = new ArrayList<String>();
		employeeNo = new ArrayList<String>();
		divisionOfficeID = new ArrayList<String>();

		mobileNumber = entry.spaceTrimmer(request
				.getParameter("cellphoneNumber"));
		landline = entry.spaceTrimmer(request.getParameter("landline"));
		emailad = entry.spaceTrimmer(request.getParameter("e-mail_ad"));
		username = entry.spaceTrimmer(request.getParameter("username"));
		password = request.getParameter("password");
		reenterPassword = request.getParameter("reenterPassword");
		acctType = request.getParameter("accountType");
		boolean mustFail = false;
		for (int i = 0; i < 5; i++) {
			String tempDesignation = request
					.getParameter("designation" + (1 + i));
			String tempEmployeeNo = request.getParameter("employeeNo" + (1 + i));
			String tempDivision = request.getParameter("divisionOfficeDropdown"
					+ (1 + i));
			designation.add(tempDesignation);
			if (tempEmployeeNo == null || tempEmployeeNo.isEmpty())
				employeeNo.add("");
			else
				employeeNo.add(tempEmployeeNo);
			divisionOfficeID.add(tempDivision);

		}
		for (int i = 0; i < designation.size(); i++) {
			designation.get(i).replaceAll(designation.get(i),
					entry.spaceTrimmer(designation.get(i)));
			employeeNo.get(i).replaceAll(employeeNo.get(i),
					entry.spaceTrimmer(employeeNo.get(i)));
			System.out.println("Designation No"+i+":"+designation.get(i));
			System.out.println("Employee No"+i+":"+employeeNo.get(i));
		}
		for (int i = 0; i < designation.size(); i++) {
			if (designation.get(i).isEmpty()
					&& !employeeNo.get(i).isEmpty()
					&& (entry.check(entry.spaceTrimmer(designation.get(i))) || entry
							.check(entry.spaceTrimmer(employeeNo.get(i)))))
				mustFail = true;
		}

		if (!name.isEmpty() && designation != null && !username.isEmpty()
				&& !password.isEmpty() && !reenterPassword.isEmpty()
				&& password.equalsIgnoreCase(reenterPassword) && !mustFail
				&& entry.check(name) && entry.check(username)) {
			acceptResponse(request, response);
		} else
			failedResponse(request, response);
	}

	private void acceptResponse(HttpServletRequest request,
			HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		Person person;
		if (name != null && designation != null && username != null
				&& password != null && reenterPassword != null
				&& password.equalsIgnoreCase(reenterPassword)) {
			if (title != null && !title.equalsIgnoreCase("null")
					&& !title.isEmpty())
				person = new Person(title, name);
			else
				person = new Person(name);

			if (emailad != null && !emailad.equalsIgnoreCase("null")
					&& !emailad.isEmpty()) {
				Contact email = new Contact(entry.spaceTrimmer(emailad),
						ContactType.EMAIL);
				person.addContact(email);
			}

			if (landline != null && !landline.equalsIgnoreCase("null")
					&& !landline.isEmpty()) {
				Contact landline2 = new Contact(entry.spaceTrimmer(landline),
						ContactType.LANDLINE);
				person.addContact(landline2);
			}

			if (mobileNumber != null && !mobileNumber.equalsIgnoreCase("null")
					&& !mobileNumber.isEmpty()) {
				Contact mobile = new Contact(entry.spaceTrimmer(mobileNumber),
						ContactType.MOBILE);
				System.out.println(mobileNumber);
				person.addContact(mobile);
			}
			try {

				pManager.addPerson(person);
				request.setAttribute("person", person);
			} catch (TransactionException e) {
				failedResponse(request, response);
			} catch (DuplicateEntryException e) {
				failedResponse(request, response);
			}
			ArrayList<Employee> empList = new ArrayList<Employee>();
			for (int i = 0; i < designation.size(); i++) {
				if (designation.get(i).isEmpty())
					continue;
				Employee employee = new Employee(entry.spaceTrimmer(designation
						.get(i)), entry.spaceTrimmer(employeeNo.get(i)), person);
				try {
					if (!divisionOfficeID.get(i).isEmpty())
						employee.setDivisionOffice(dManager
								.getDivisionOffice(Integer
										.parseInt(divisionOfficeID.get(i))));
					pManager.addEmployee(employee);
					empList.add(employee);
				} catch (NumberFormatException e) {
					failedResponse(request, response);
				} catch (TransactionException e) {
					failedResponse(request, response);
				} catch (DuplicateEntryException e) {
					failedResponse(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					failedResponse(request, response);
				}

			}
			request.setAttribute("empList", empList);
			try {
				Account account = new Account();

				account.setPassword(password);
				account.setUsername(username);
				account.setPerson(person);
				if (acctType.equalsIgnoreCase(AccountType.SPSO_PERSONNEL
						.toString())) {
					account.setType(AccountType.SPSO_PERSONNEL);
				} else if (acctType.equalsIgnoreCase(AccountType.SYSTEM_ADMIN
						.toString())) {
					account.setType(AccountType.SYSTEM_ADMIN);
				}
				aManager.addAccount(account);
				Logger.log(request, "Account  \"" + username + "\" was added");
				AccountsViewAction view = new AccountsViewAction();
				view.process(request, response);
			} catch (TransactionException e) {
				failedResponse(request, response);
			} catch (ServletException e) {
				failedResponse(request, response);
			} catch (IOException e) {
				failedResponse(request, response);
			}
		}
	}
}
