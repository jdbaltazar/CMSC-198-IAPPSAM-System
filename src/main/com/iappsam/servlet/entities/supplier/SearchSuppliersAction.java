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
import com.iappsam.search.SupplierSearcher;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SearchSuppliersAction implements Action {

	private SupplierManager sManager = new SupplierManagerSession();

	// include searcher here

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Supplier> suppliers = new ArrayList<Supplier>();
		String searchField = request.getParameter("searchField");
		SupplierSearcher searcher = new SupplierSearcher();
		if (Validator.validField(searchField)){
			List<Supplier>s = searcher.search(searchField);
			List<Supplier>u = new ArrayList<Supplier>();
			for(Supplier su: s){
				if(!u.contains(su))
					u.add(su);
			}
			
			suppliers = u;
		}
		else
			try {
				suppliers = sManager.getAllSuppliers();
			} catch (TransactionException e) {
				e.printStackTrace();
			}

		request.setAttribute("suppliers", suppliers);
		if (Validator.validField(searchField))
			request.setAttribute("searchField", searchField);
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.SEARCH_SUPPLIERS);
		view.forward(request, response);
	}

}
