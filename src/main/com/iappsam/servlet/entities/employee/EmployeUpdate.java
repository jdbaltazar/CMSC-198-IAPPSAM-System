package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
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

/**
 * Servlet implementation class C
 */
@WebServlet("/entities/employees/update_employee.do")
public class EmployeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String title;
	private String name;
	private String[] designation;
	private String[] employeeNo;
	private String[] divisionOfficeID;
	private String mobileNumber;
	private String landline;
	private String emailad;
	private String personID;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void failedResponse(HttpServletRequest request,
			HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameOK", "false");
		else
			request.setAttribute("nameOK", "true");

		String designation1OK = null;
		if (designation[0].isEmpty() && !employeeNo[0].isEmpty()) {
			designation1OK = "true";
		}
		String designation2OK = null;
		if (designation.length > 1 && designation[1].isEmpty()
				&& !employeeNo[1].isEmpty()) {
			designation2OK = "true";
		}
		String designation3OK = null;
		if (designation.length > 2 && designation[2].isEmpty()
				&& !employeeNo[2].isEmpty()) {
			designation3OK = "true";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("view_employee.jsp");
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("designation", designation);
		request.setAttribute("designation1OK", designation1OK);
		request.setAttribute("designation2OK", designation2OK);
		request.setAttribute("designation3OK", designation3OK);
		request.setAttribute("employeeNo", employeeNo);
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameterValues("designation");
		employeeNo = request.getParameterValues("empNo3");
		divisionOfficeID = request.getParameterValues("divisionOffice");
		mobileNumber = request.getParameter("cellphoneNumber");
		landline = request.getParameter("landline");
		emailad = request.getParameter("e-mail_ad");
		personID = request.getParameter("personID");

		if (!name.isEmpty() && designation != null) {
			acceptResponse(request, response);
		} else
			failedResponse(request, response);
	}

	private void acceptResponse(HttpServletRequest request,
			HttpServletResponse response) {
		PersonManager pManager = new PersonManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		Person person;
		ContactManager cManager = new ContactManagerSession();
		try {
			if (name != null && designation != null) {
				person = pManager.getPerson(Integer.parseInt(personID));

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
				for (int i = 0; i < emailList.size(); i++)
					if (emailad != null && !emailad.equalsIgnoreCase("null")
							&& !emailad.isEmpty()) {
						Contact email = new Contact();
						if (i < emailList.size()) {
							email = emailList.get(i);
							email.setData(emailad);
							cManager.addContact(email);
						} else {
							email.setData(emailad);
							person.addContact(email);
						}

					}
				for (int i = 0; i < landlineList.size(); i++)
					if (landline != null && !landline.equalsIgnoreCase("null")
							&& !landline.isEmpty()) {
						Contact landline2 = new Contact();

						if (i < emailList.size()) {
							landline2 = landlineList.get(i);
							landline2.setData(landline);
							cManager.updateContact(landline2);
						} else {
							landline2.setData(landline);
							person.addContact(landline2);
						}
					}
				for (int i = 0; i < mobileList.size(); i++)
					if (mobileNumber != null
							&& !mobileNumber.equalsIgnoreCase("null")
							&& !mobileNumber.isEmpty()) {
						Contact mobile = new Contact();
						if (i < mobileList.size()) {
							mobile = mobileList.get(i);
							mobile.setData(mobileNumber);
							cManager.updateContact(mobile);
						}

						else {
							mobile.setData(mobileNumber);
							person.addContact(mobile);
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
						pManager.updatePerson(person);
					} catch (DuplicateEntryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("employeeID", empList.get(0).getId());
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
