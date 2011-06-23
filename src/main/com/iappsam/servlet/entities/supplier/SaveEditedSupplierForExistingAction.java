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
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.util.Verifier;

public class SaveEditedSupplierForExistingAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		// TODO Auto-generated method stub

		String supplierID = request.getParameter("supplierID");
		String supplierName = request.getParameter("supplierName");
		String address = request.getParameter("address");
		String tin = request.getParameter("tin");
		String employeeID = request.getParameter("employeeID");

		PersonManager pManager = new PersonManagerSession();
		Employee employee = pManager.getEmployee(Integer.parseInt(employeeID));
		RequestDispatcher save = request.getRequestDispatcher(SupplierServlet.CHANGE_SUPPLIER_CONTACT_PERSON);
		SupplierManager sManager = new SupplierManagerSession();

		Supplier supplier = sManager.getSupplier(Integer.parseInt(supplierID));
		supplier.setContactPerson(employee);
		if (Verifier.validEntry(supplierName))
			supplier.setSupplierName(supplierName);
		if (Verifier.validEntry(address))
			supplier.setSupplierName(address);
		supplier.setTin(tin);

		if (supplier.validate() && Verifier.validEntry(supplierName) && Verifier.validEntry(address)) {
			System.out.println("supplier name: "+supplierName);
			System.out.println("supplier address: "+address);
			System.out.println("supplier name b4 save: "+supplier.getSupplierName());
			System.out.println("supplier address b4 save: "+supplier.getAddress());
			supplier.setSupplierName(supplierName);
			supplier.setAddress(address);
			sManager.updateSupplier(supplier);
			
			save = request.getRequestDispatcher("supplier?" + SupplierServlet.SUPPLIER_ACTION + "=" + SupplierServlet.VIEW_SUPPLIERS_ACTION);
			System.out.println("edited was saveD!!!!!!!!!");
		} else {
			System.out.println("was not saveD!!!!!!!!!");
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
	}

}