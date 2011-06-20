package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Supplier;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

public class ViewSupplierAction implements Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		// TODO Auto-generated method stub
		
		String sID = request.getParameter("supplierID");
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
			s = ApplicationContext.INSTANCE.getSupplierManager().getSupplier(supplierID);
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
