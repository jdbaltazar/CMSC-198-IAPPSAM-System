package com.iappsam.servlet.entities.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Supplier;
import com.iappsam.logging.Logger;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String supplierName = request.getParameter("supplierName").trim();
		String address = request.getParameter("supplierAddress").trim();
		String tin = request.getParameter("tin").trim();

		String title = request.getParameter("title").trim();
		String name = request.getParameter("name").trim();
		String designation = request.getParameter("designation").trim();
		String employeeNumber = request.getParameter("employeeNumber").trim();
		String mobileNumber = request.getParameter("mobileNumber").trim();
		String landline = request.getParameter("landline").trim();
		String emailad = request.getParameter("emailad").trim();

		SupplierManager sManager = new SupplierManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER);

		Person person = new Person();
		if (Validator.validField(name))
			person.setName(name);
		if (Validator.validField(title))
			person.setTitle(title);
		if (Validator.validField(mobileNumber))
			person.addContact(new Contact(mobileNumber, ContactType.MOBILE));
		if (Validator.validField(landline))
			person.addContact(new Contact(landline, ContactType.LANDLINE));
		if (Validator.validField(emailad))
			person.addContact(new Contact(emailad, ContactType.EMAIL));
		Employee employee = new Employee();
		employee.setPerson(person);
		if (Validator.validField(designation))
			employee.setDesignation(designation);
		if (Validator.validField(employeeNumber))
			employee.setEmployeeNumber(employeeNumber);
		Supplier supplier = new Supplier(supplierName, address, tin, employee);

		if (supplier.validate()) {
			try {
				sManager.addSupplier(supplier);
				Logger.log(request, "Supplier \""+supplierName+"\" was added");
				request.setAttribute("supplierID", "" + supplier.getId());
				view = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("supplier", supplier);
		}

		view.forward(request, response);

	}

}
