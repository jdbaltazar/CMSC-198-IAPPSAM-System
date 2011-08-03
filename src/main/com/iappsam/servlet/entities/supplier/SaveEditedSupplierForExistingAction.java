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
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveEditedSupplierForExistingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String supplierID = request.getParameter("supplierID");
			String supplierName = request.getParameter("supplierName").trim();
			String address = request.getParameter("address").trim();
			String tin = request.getParameter("tin").trim();
			String employeeID = request.getParameter("employeeID");
			PersonManager pManager = new PersonManagerSession();
			Employee employee = pManager.getEmployee(Integer.parseInt(employeeID));
			RequestDispatcher save = request.getRequestDispatcher(SupplierServlet.CHANGE_SUPPLIER_CONTACT_PERSON);
			SupplierManager sManager = new SupplierManagerSession();
			Supplier supplier = sManager.getSupplier(Integer.parseInt(supplierID));
			supplier.setContactPerson(employee);
			supplier.setSupplierName(supplierName);
			supplier.setSupplierName(address);
			supplier.setTin(tin);
			if (supplier.validate()) {
				System.out.println("supplier name: " + supplierName);
				System.out.println("supplier address: " + address);
				System.out.println("supplier name b4 save: " + supplier.getSupplierName());
				System.out.println("supplier address b4 save: " + supplier.getAddress());
				supplier.setSupplierName(supplierName);
				supplier.setAddress(address);
				sManager.updateSupplier(supplier);

				save = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
				System.out.println("edited was saveD!!!!!!!!!");
			} else {
				System.out.println("was not saveD!!!!!!!!!");

				Supplier original = sManager.getSupplier(Integer.parseInt(supplierID));
				if (!Validator.validField(supplier.getSupplierName()))
					supplier.setSupplierName(original.getSupplierName());
				if (!Validator.validField(supplier.getAddress()))
					supplier.setAddress(original.getAddress());

				request.setAttribute("supplier", supplier);
				List<Employee> employees = new ArrayList<Employee>();
				List<Supplier> suppliers = sManager.getAllSuppliers();
				for (Supplier s : suppliers) {
					if (!employees.contains(s.getContactPerson()))
						employees.add(s.getContactPerson());
				}

				request.setAttribute("employees", employees);
				request.setAttribute("supplier", supplier);
			}
			save.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
