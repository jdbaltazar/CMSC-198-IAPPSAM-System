package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Employee;
import com.iappsam.Supplier;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;

public class ChangeSupplierContactPersonAction implements Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.CHANGE_SUPPLIER_CONTACT_PERSON);
		List<Employee> employees = new ArrayList<Employee>();

		String supplierID = request.getParameter("supplierID");
		SupplierManager sManager = new SupplierManagerSession();
		Supplier supplier = sManager.getSupplier(Integer.parseInt(supplierID));
		List<Supplier> suppliers = sManager.getAllSuppliers();
		for (Supplier s : suppliers) {
			if (!employees.contains(s.getContactPerson()))
				employees.add(s.getContactPerson());
		}
		request.setAttribute("supplier", supplier);
		request.setAttribute("employees", employees);
		view.forward(request, response);
	}
	
}
