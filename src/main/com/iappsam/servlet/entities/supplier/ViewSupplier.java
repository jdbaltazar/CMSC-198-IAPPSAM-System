package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.Set;

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
import com.iappsam.util.ManagerBin;

@WebServlet("/entities/supplier/SaveSupplier.do")
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
		try {
			s = ManagerBin.sManager.getSupplier(supplierID);
			request.setAttribute("supplier", s);
			contactPerson = s.getContactPerson();
			p = contactPerson.getPerson();

			request.setAttribute("supplier", s);
			request.setAttribute("employee", contactPerson);
			request.setAttribute("person", p);

		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
