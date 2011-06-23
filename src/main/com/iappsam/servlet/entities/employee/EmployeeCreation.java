package com.iappsam.servlet.entities.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class EmployeeCreation
 */
@WebServlet("/entities/employees/AddEmployee.do")
public class EmployeeCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String title;
	private String name;
	private String designation;
	private String employeeNumber;
	private String divisionOfficeID;
	private String mobileNumber;
	private String landline;
	private String emailad;
	private DivisionOffice division;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameter("designation");
		employeeNumber = request.getParameter("employeeNumber");
		divisionOfficeID = request.getParameter("division/office");
		mobileNumber = request.getParameter("cellphoneNumber");
		landline = request.getParameter("landline");
		emailad = request.getParameter("e-mail_ad");

		if (name.isEmpty() || designation.isEmpty()) {
			addFail(request, response);
		} else
			addSuccess(request, response);
	}

	private void addSuccess(HttpServletRequest request,
			HttpServletResponse response) {
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		Person person = new Person(title, name);

		Contact c1;
		Contact c2;
		Contact c3;

		try {
			System.out.println("Email" + emailad);
			System.out.println("LandLine" + landline);
			System.out.println("MobileNumber:" + mobileNumber);

			

			if (emailad != null && !emailad.equalsIgnoreCase("null")
					&& !emailad.isEmpty()) {
				Contact email = new Contact(emailad, ContactType.EMAIL);
				person.addContact(email);
				request.setAttribute("emailad", email);
			}

			if (landline != null && !landline.equalsIgnoreCase("null")
					&& !landline.isEmpty()) {
				Contact landline2 = new Contact(landline, ContactType.LANDLINE);
				person.addContact(landline2);
				request.setAttribute("landline", landline2);
			}

			if (mobileNumber != null && !mobileNumber.equalsIgnoreCase("null")
					&& !mobileNumber.isEmpty()) {
				Contact mobile = new Contact(mobileNumber, ContactType.MOBILE);

				person.addContact(mobile);
				request.setAttribute("mobile", mobile);
			}
			ApplicationContext.INSTANCE.getPersonManager().addPerson(person);
			Employee employee = new Employee(designation, employeeNumber,
					person);
			employee.setDivisionOffice(dManager.getDivisionOffice(Integer
					.parseInt(divisionOfficeID)));

			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("designation", designation);
			request.setAttribute("employeeNumber", employeeNumber);
			request.setAttribute("division", dManager.getDivisionOffice(Integer
					.parseInt(divisionOfficeID)));
			ApplicationContext.INSTANCE.getPersonManager()
					.addEmployee(employee);
			request.setAttribute("employeeID", "" + employee.getId());
			RequestDispatcher view = request
					.getRequestDispatcher("view_employee.jsp");
			view.forward(request, response);
		} catch (TransactionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicateEntryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void addFail(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("designation", designation);
			request.setAttribute("employeeNumber", employeeNumber);
			request.setAttribute("division", division);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("landline", landline);
			request.setAttribute("emailad", emailad);
			RequestDispatcher view = request
					.getRequestDispatcher("add_employee.jsp");
			view.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
