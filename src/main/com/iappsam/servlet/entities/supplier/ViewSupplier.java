package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

@WebServlet("/entities/supplier/ViewSupplier.do")
public class ViewSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewSupplier() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sID = (String) request.getParameter("supplierID");
		if (sID == null) {
			sID = (String) request.getAttribute("supplierID");
		}

		int supplierID = Integer.parseInt(sID);

		Supplier s = null;
		Employee contactPerson = null;
		Person p = null;
		String mobile = null;
		String landline = null;
		String email = null;
		try {
			s = Managers.sManager.getSupplier(supplierID);
			request.setAttribute("supplier", s);
			contactPerson = s.getContactPerson();
			p = contactPerson.getPerson();

			request.setAttribute("supplier", s);
			request.setAttribute("employee", contactPerson);
			request.setAttribute("person", p);

			Set<Contact> contacts = p.getContacts();
			for (Contact c : contacts) {
				if (c.getType().equals(ContactType.MOBILE))
					mobile = c.getData();
				if (c.getType().equals(ContactType.LANDLINE))
					landline = c.getData();
				if (c.getType().equals(ContactType.EMAIL))
					email = c.getData();
			}
			if (mobile == null)
				mobile = "";
			if (landline == null)
				landline = "";
			if (email == null)
				email = "";

			request.setAttribute("mobile", mobile);
			request.setAttribute("landline", landline);
			request.setAttribute("email", email);

		} catch (TransactionException e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("ViewSupplier.jsp");
		view.forward(request, response);
	}
}
