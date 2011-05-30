package com.iappsam.servlet.entities.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class EmployeeCreation
 */
@WebServlet("/entities/employees/CreateEmployee.do")
public class EmployeeCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String title;
	private String name;
	private String designation;
	private String employeeNumber;
	private String division;
	private String office;
	private String mobileNumber;
	private String landline;
	private String emailad;
	private String designationID;
	private DivisionOffice dOffice;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		title = request.getParameter("title");
		name = request.getParameter("name");
		designation = request.getParameter("designation");
		employeeNumber = request.getParameter("employeeNumber");
		division = request.getParameter("division");
		office = request.getParameter("office");
		mobileNumber = request.getParameter("mobileNumber");
		landline = request.getParameter("landline");
		emailad = request.getParameter("emailad");

		if (name.isEmpty() || designation.isEmpty()) {
			addFail(request, response);
		} else
			addSuccess(request, response);
	}

	private String getDivisionNameFromString(String input) {
		String output = new String();
		for (int i = 0; input != null && i < input.length(); i++) {
			if (input.charAt(i) == ',')
				output = input.substring(0, i - 1);
		}
		return output;
	}

	private String getOfficeNameFromString(String input) {
		String output = new String();
		for (int i = 0; input != null && i < input.length(); i++) {
			if (input.charAt(i) == ',')
				output = input.substring(i + 2);
		}
		return output;
	}

	private void addSuccess(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("designation", designation);
		request.setAttribute("employeeNumber", employeeNumber);
		request.setAttribute("mobileNumber", mobileNumber);
		request.setAttribute("landline", landline);
		request.setAttribute("emailad", emailad);
		request.setAttribute("division", division);

		Person person = new Person(title, name);

		Contact c1;
		Contact c2;
		Contact c3;

		try {

			System.out.println("Division Name:" + getDivisionNameFromString(division));
			if (getOfficeNameFromString(division) != null)
				System.out.println("Office Name:" + getOfficeNameFromString(division));
			DivisionOffice dOffice = ManagerBin.doManager.getDivisionOffice(getDivisionNameFromString(division), getOfficeNameFromString(division));

			if (emailad != null && !emailad.isEmpty()) {
				c1 = new Contact(emailad, ContactType.EMAIL);
			
				person.addContact(c1);
			}
			if (landline != null && !landline.isEmpty()) {
				c2 = new Contact(landline, ContactType.LANDLINE);
			
				person.addContact(c2);
			}
			if (mobileNumber != null && !mobileNumber.isEmpty()) {
				c3 = new Contact(mobileNumber, ContactType.MOBILE);
			
				person.addContact(c3);
			}

			ManagerBin.pManager.addPerson(person);
			Employee employee = new Employee(designation, employeeNumber, person);
			employee.setDivisionOffice(dOffice);
			ManagerBin.pManager.addEmployee(employee);
			
			RequestDispatcher view = request.getRequestDispatcher("EmployeeFinalize.jsp");
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

	private void addFail(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("designation", designation);
			request.setAttribute("employeeNumber", employeeNumber);
			request.setAttribute("division", division);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("landline", landline);
			request.setAttribute("emailad", emailad);
			RequestDispatcher view = request.getRequestDispatcher("AddEmployee.jsp");
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
