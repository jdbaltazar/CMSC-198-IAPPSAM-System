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
import com.iappsam.logging.Logger;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveSupplierToContactPersonAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String supplierName = request.getParameter("supplierName").trim();
			String address = request.getParameter("address").trim();
			String tin = request.getParameter("tin").trim();
			String employeeID = request.getParameter("employeeID");
			PersonManager pManager = new PersonManagerSession();
			Employee employee = pManager.getEmployee(Integer.parseInt(employeeID));
			RequestDispatcher save = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER_FOR_EXISTING);
			SupplierManager sManager = new SupplierManagerSession();
			Supplier supplier = new Supplier(supplierName, address, employee);
			if (Validator.validField(tin))
				supplier.setTin(tin);
			if (supplier.validate()) {
				try {
					sManager.addSupplier(supplier);
					Logger.log(request, "Supplier \""+supplierName+"\" was added");
					save = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
				} catch (DuplicateEntryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				request.setAttribute("supplier", supplier);
				List<Employee> employees = new ArrayList<Employee>();
				List<Supplier> suppliers = sManager.getAllSuppliers();
				for (Supplier s : suppliers) {
					if (!employees.contains(s.getContactPerson()))
						employees.add(s.getContactPerson());
				}

				request.setAttribute("employees", employees);
			}
			save.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
