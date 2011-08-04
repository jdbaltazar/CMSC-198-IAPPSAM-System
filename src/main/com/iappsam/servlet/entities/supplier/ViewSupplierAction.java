package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Supplier;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;

public class ViewSupplierAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sID = request.getParameter("supplierID");
		if (sID == null)
			sID = (String) request.getAttribute("supplierID");
		int supplierId = Integer.parseInt(sID);

		SupplierManager sManager = new SupplierManagerSession();
		Supplier supplier;
		try {
			supplier = sManager.getSupplier(supplierId);

			request.setAttribute("supplier", supplier);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.VIEW_SUPPLIER);
		view.forward(request, response);
	}

}
