package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
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

/**
 * Servlet implementation class C
 */
@WebServlet("/entities/employees/update_account.do")
public class AccountUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String title;
	private String name;
	private String[] designation;
	private String[] employeeNo;
	private String[] divisionOfficeID;
	private String username;
	private String password;
	private String reenterPassword;
	private String mobileNumber;
	private String landline;
	private String emailad;
	private String acctType;
	private String accountID;
	private String newPassword;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void failedResponse(HttpServletRequest request,
			HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameOK", "false");
		else
			request.setAttribute("nameOK", "true");
		if (username.isEmpty())
			request.setAttribute("usernameOK", "false");
		else
			request.setAttribute("usernameOK", "true");
		if (password.isEmpty() || !password.equalsIgnoreCase(reenterPassword))
			request.setAttribute("passwordOK", "false");
		else
			request.setAttribute("passwordOK", "true");

		String designation1OK = null;
		if (designation[0].isEmpty() && !employeeNo[0].isEmpty()) {
			designation1OK = "true";
		}
		String designation2OK = null;
		if (designation[1].isEmpty() && !employeeNo[1].isEmpty()) {
			designation2OK = "true";
		}
		String designation3OK = null;
		if (designation[2].isEmpty() && !employeeNo[2].isEmpty()) {
			designation3OK = "true";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("view_account.jsp");
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("designation", designation);
		request.setAttribute("designation1OK", designation1OK);
		request.setAttribute("designation2OK", designation2OK);
		request.setAttribute("designation3OK", designation3OK);
		request.setAttribute("employeeNo", employeeNo);
		request.setAttribute("userName", username);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("landline", landline);
		request.setAttribute("emailad", emailad);

		request.setAttribute("accountID", accountID);
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameterValues("designation");
		employeeNo = request.getParameterValues("empNo3");
		divisionOfficeID = request.getParameterValues("divisionOffice");
		mobileNumber = request.getParameter("cellphoneNumber");
		acctType = request.getParameter("accountType");
		landline = request.getParameter("landline");
		emailad = request.getParameter("e-mail_ad");
		newPassword = request.getParameter("newPassword");
		System.out.println(emailad);

		accountID = request.getParameter("accountID");
		boolean mustFail = false;
		for (int i = 0; i < designation.length; i++) {
			if (designation[i].isEmpty() && !employeeNo[i].isEmpty())
				mustFail = true;
		}
		if (!name.isEmpty() && designation != null && !username.isEmpty()
				&& !password.isEmpty() && !reenterPassword.isEmpty()
				&& password.equalsIgnoreCase(reenterPassword) && !mustFail) {
			acceptResponse(request, response);
		} else
			failedResponse(request, response);
	}

	private void acceptResponse(HttpServletRequest request,
			HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		AccountManager aManager = new AccountManagerSession();
		Person person;
		ContactManager cManager = new ContactManagerSession();
		try {
			if (name != null && designation != null) {
				Account account = aManager.getAccount(accountID);
				person = account.getPerson();

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
					person.setName(name);
					person.setTitle(title);
				} else {
					person.setName(name);
				}
				if (emailad != null && emailList.isEmpty()) {
					Contact email = new Contact();
					email.setData(emailad);

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
				if (landline != null && landlineList.isEmpty()) {

					Contact landline2 = new Contact();
					landline2.setData(landline);
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
				if (mobileNumber != null && mobileList.isEmpty()) {
					System.out.println("heyosadasd");
					Contact mobile = new Contact();
					mobile.setData(mobileNumber);

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
					employee.setPerson(person);
					try {
						employee.setDivisionOffice(dManager
								.getDivisionOffice(Integer
										.parseInt(divisionOfficeID[i])));
						empList.add(employee);
					} catch (NumberFormatException e) {
						failedResponse(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						failedResponse(request, response);
					}
					try {
						pManager.addPerson(person);
						if (account.comparePassword(password)
								&& newPassword.equals(reenterPassword)) {
							account.setPassword(newPassword);
						}
						aManager.addAccount(account);
					} catch (DuplicateEntryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}

			RequestDispatcher view = request
					.getRequestDispatcher("search_employee.do");
			view.forward(request, response);
		} catch (ServletException e) {
			failedResponse(request, response);
		} catch (IOException e) {
			failedResponse(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
