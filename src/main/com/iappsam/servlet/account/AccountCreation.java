package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.entities.AccountType;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/accounts/CreateAccount.do")
public class AccountCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String title;
	String name;
	String[] designation;
	String[] employeeNo;
	String[] divisionOfficeID;
	String username;
	String password;
	String reenterPassword;
	String mobileNumber;
	String landline;
	String emailad;
	String acctType;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void failedResponse(HttpServletRequest request, HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameOK", "false");
		if (designation == null)
			request.setAttribute("designationOK", "false");
		if (username.isEmpty())
			request.setAttribute("username", "false");
		if (password.isEmpty() || !password.equalsIgnoreCase(reenterPassword))
			request.setAttribute("passwordOK", "false");

		RequestDispatcher view = request.getRequestDispatcher("CreateAccount.jsp");
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("designation", designation);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameterValues("designation");
		employeeNo = request.getParameterValues("employeeNo");
		divisionOfficeID = request.getParameterValues("divisionOfficeDropdown");
		mobileNumber = request.getParameter("mobileNumber");
		landline = request.getParameter("landline");
		emailad = request.getParameter("emailad");
		username = request.getParameter("username");
		password = request.getParameter("password");
		reenterPassword = request.getParameter("reenterPassword");
		acctType = request.getParameter("acctType");
		if (!name.isEmpty() && designation != null && !username.isEmpty() && !password.isEmpty() && !reenterPassword.isEmpty() && password.equalsIgnoreCase(reenterPassword)) {
			System.out.println("Something got passed");
			acceptResponse(request, response);
		} else
			failedResponse(request, response);
	}

	private void acceptResponse(HttpServletRequest request, HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		Person person;
		if (name != null && designation != null && username != null && password != null && reenterPassword != null && password.equalsIgnoreCase(reenterPassword)) {
			if (title != null && !title.equalsIgnoreCase("null") && !title.isEmpty())
				person = new Person(title, name);
			else
				person = new Person(name);

			if (emailad != null && !emailad.equalsIgnoreCase("null") && !emailad.isEmpty()) {
				Contact email = new Contact(emailad, ContactType.EMAIL);
				person.addContact(email);
				request.setAttribute("email", email);
			}

			if (landline != null && !landline.equalsIgnoreCase("null") && !landline.isEmpty()) {
				Contact landline2 = new Contact(landline, ContactType.LANDLINE);
				person.addContact(landline2);
				request.setAttribute("landline", landline2);
			}

			if (mobileNumber != null && !mobileNumber.equalsIgnoreCase("null") && !mobileNumber.isEmpty()) {
				Contact mobile = new Contact(mobileNumber, ContactType.MOBILE);

				person.addContact(mobile);
				request.setAttribute("mobile", mobile);
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
			for (int i = 0; !designation[i].isEmpty() && i < designation.length; i++) {
				Employee employee = new Employee(designation[i], employeeNo[i], person);
				try {
					employee.setDivisionOffice(dManager.getDivisionOffice(Integer.parseInt(divisionOfficeID[i])));
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
				if (acctType.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE);
				} else if (acctType.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_HEAD.toString())) {
					account.setType(AccountType.NON_SPSO_PERSONNEL_HEAD);
				} else if (acctType.equalsIgnoreCase(AccountType.SPSO_PERSONNEL.toString())) {
					account.setType(AccountType.SPSO_PERSONNEL);
				} else if (acctType.equalsIgnoreCase(AccountType.SYSTEM_ADMIN.toString())) {
					account.setType(AccountType.SYSTEM_ADMIN);
				}
				aManager.addAccount(account);
				request.setAttribute("account", account);
				RequestDispatcher view = request.getRequestDispatcher("CreateAccountSuccess.jsp");
				view.forward(request, response);
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
