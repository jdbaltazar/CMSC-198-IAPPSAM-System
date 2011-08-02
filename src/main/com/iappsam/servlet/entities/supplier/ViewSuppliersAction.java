package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Supplier;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.servlet.Action;

public class ViewSuppliersAction implements Action {

	private SupplierManager sManager = new SupplierManagerSession();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try {
			suppliers = sManager.getAllSuppliers();
			request.setAttribute("suppliers", suppliers);
			RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.SEARCH_SUPPLIERS);
			view.forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
