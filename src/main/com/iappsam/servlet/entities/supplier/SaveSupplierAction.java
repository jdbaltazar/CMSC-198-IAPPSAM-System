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

public class SaveSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		String supplierName = request.getParameter("supplierName");
		String address = request.getParameter("supplierAddress");
		String tin = request.getParameter("tin");

		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String employeeNumber = request.getParameter("employeeNumber");
		String mobileNumber = request.getParameter("mobileNumber");
		String landline = request.getParameter("landline");
		String emailad = request.getParameter("emailad");

		SupplierManager sManager = new SupplierManagerSession();
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER);

		// if (Verifier.validEntry(supplierName) && Verifier.validEntry(address)
		// && Verifier.validEntry(name) && Verifier.validEntry(designation)) {

		Person person = new Person(title, name);
		if (mobileNumber != null)
			person.addContact(new Contact(mobileNumber, ContactType.MOBILE));
		if (landline != null)
			person.addContact(new Contact(landline, ContactType.LANDLINE));
		if (emailad != null)
			person.addContact(new Contact(emailad, ContactType.EMAIL));
		Employee employee = new Employee(designation, person);
		if (employeeNumber != null)
			employee.setEmployeeNumber(employeeNumber);
		Supplier supplier = new Supplier(supplierName, address, tin, employee);

		if (supplier.validate()) {
			try {
				sManager.addSupplier(supplier);
				request.setAttribute("supplierID", "" + supplier.getId());
				view = request.getRequestDispatcher("supplier?"+SupplierServlet.SUPPLIER_ACTION+"="+SupplierServlet.VIEW_SUPPLIERS_ACTION);
				System.out.println("supplier was saved!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("supplier is not valid!!");
			request.setAttribute("supplier", supplier);
			view = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER);
		}

		view.forward(request, response);

	}

}
