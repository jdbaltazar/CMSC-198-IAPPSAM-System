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
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.util.Verifier;

public class SaveSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

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
		if (Verifier.validEntry(name))
			person.setName(name);
		if (Verifier.validEntry(title))
			person.setName(title);
		if (Verifier.validEntry(mobileNumber))
			person.addContact(new Contact(mobileNumber, ContactType.MOBILE));
		if (Verifier.validEntry(landline))
			person.addContact(new Contact(landline, ContactType.LANDLINE));
		if (Verifier.validEntry(emailad))
			person.addContact(new Contact(emailad, ContactType.EMAIL));
		Employee employee = new Employee();
		employee.setPerson(person);
		if (Verifier.validEntry(designation))
			employee.setDesignation(designation);
		if (Verifier.validEntry(employeeNumber))
			employee.setEmployeeNumber(employeeNumber);
		Supplier supplier = new Supplier(supplierName, address, tin, employee);

		if (supplier.validate()) {
			try {
				sManager.addSupplier(supplier);
				request.setAttribute("supplierID", "" + supplier.getId());
				view = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
				System.out.println("supplier was saved!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("supplier is not valid!!");
			request.setAttribute("supplier", supplier);
		}

		view.forward(request, response);

	}

}
