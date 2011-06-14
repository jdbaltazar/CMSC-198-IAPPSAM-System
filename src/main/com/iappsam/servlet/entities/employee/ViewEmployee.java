package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

@WebServlet("/entities/employees/ViewEmployee.do")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	Person p;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeID = request.getParameter("employeeID");
		System.out.println(employeeID);
		ArrayList<String> landline = new ArrayList<String>();
		ArrayList<String> mobile = new ArrayList<String>();
		ArrayList<String> emailad = new ArrayList<String>();
		try {
			Employee emp = Managers.INSTANCE.getPersonManager().getEmployee(Integer.parseInt(employeeID));
			if (emp != null) {
				p = emp.getPerson();
				request.setAttribute("title", p.getTitle());
				request.setAttribute("name", p.getName());
				request.setAttribute("designation", emp.getDesignation());
				request.setAttribute("employeeNum", emp.getEmployeeNumber());
				request.setAttribute("division", emp.getDivisionOffice());

				Set<Contact> contacts = p.getContacts();

				for (Contact contact : contacts) {
					if (contact.getType().equals(ContactType.LANDLINE))
						landline.add(contact.getData());

					if (contact.getType().equals(ContactType.EMAIL))
						emailad.add(contact.getData());

					if (contact.getType().equals(ContactType.MOBILE))
						mobile.add(contact.getData());
				}

				if (mobile.isEmpty()) {
					System.out.println("what the fuck!!");
				}
				if (landline.isEmpty()) {
					System.out.println("what the hell!!");
				}
				request.setAttribute("mobil", mobile);
				request.setAttribute("emailad", emailad);
				request.setAttribute("landline", landline);
			}
			request.getRequestDispatcher("ViewEmployee.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}

	}
}
