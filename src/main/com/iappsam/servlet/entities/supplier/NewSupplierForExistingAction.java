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
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;

public class NewSupplierForExistingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER_FOR_EXISTING);
			List<Employee> employees = new ArrayList<Employee>();
			SupplierManager sManager = new SupplierManagerSession();
			List<Supplier> suppliers = sManager.getAllSuppliers();
			for (Supplier s : suppliers) {
				if (!employees.contains(s.getContactPerson()))
					employees.add(s.getContactPerson());
			}
			request.setAttribute("employees", employees);
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
