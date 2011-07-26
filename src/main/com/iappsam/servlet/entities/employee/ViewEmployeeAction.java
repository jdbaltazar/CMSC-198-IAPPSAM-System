package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;

public class ViewEmployeeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String personID = (String) request.getParameter("personID");
		Employee[] employments = new Employee[5];
		String mobile = "";
		String landline = "";
		String email = "";

		System.out.println("personID: " + personID);

		PersonManager pManager = new PersonManagerSession();
		Person person;
		try {
			person = pManager.getPerson(Integer.parseInt(personID));
			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
			List<DivisionOffice> dOffices = doManager.getAllDivisionOffice();

			int i = 0;
			while (i < 5) {
				employments[i] = null;
				i++;
			}
			i = 0;
			for (Employee e : person.getEmployments()) {
				employments[i] = e;
				i++;
			}

			for (Contact c : person.getContacts()) {
				if (c.getType() == ContactType.MOBILE)
					mobile = c.getData();
				if (c.getType() == ContactType.LANDLINE)
					landline = c.getData();
				if (c.getType() == ContactType.EMAIL)
					email = c.getData();
			}

			request.setAttribute("person", person);
			request.setAttribute("employments", employments);
			request.setAttribute("divOffices", dOffices);
			request.setAttribute("mobile", mobile);
			request.setAttribute("landline", landline);
			request.setAttribute("email", email);

			RequestDispatcher view = request.getRequestDispatcher(EmployeeServlet.VIEW_EMPLOYEE);
			view.forward(request, response);

		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}
	}
}
