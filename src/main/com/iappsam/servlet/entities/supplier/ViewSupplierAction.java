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
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.util.ApplicationContext;

public class ViewSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		// TODO Auto-generated method stub

		String sID = request.getParameter("supplierID");
		if(sID==null)
			sID = (String)request.getAttribute("supplierID");
		int supplierId = Integer.parseInt(sID);

		SupplierManager sManager = new SupplierManagerSession();
		Supplier supplier = sManager.getSupplier(supplierId);

		request.setAttribute("supplier", supplier);

		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.VIEW_SUPPLIER);
		view.forward(request, response);
	}

}
