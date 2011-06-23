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
import com.iappsam.util.Verifier;

public class SearchSuppliersAction implements Action {

	private SupplierManager sManager = new SupplierManagerSession();

	// include searcher here

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		System.out.println("aaaaaaaaaaaaaaaaaa");
		List<Supplier> suppliers = new ArrayList<Supplier>();
		String searchField = request.getParameter("searchField");
		SupplierSearcher searcher = new SupplierSearcher();
		if (Verifier.validEntry(searchField))
			suppliers = searcher.search(searchField);
		else
			suppliers = sManager.getAllSuppliers();
		
		System.out.println("search: "+searchField);
		System.out.println("results: "+suppliers.size());

		request.setAttribute("suppliers", suppliers);
		if (Verifier.validEntry(searchField))
			request.setAttribute("searchField", searchField);
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.SEARCH_SUPPLIERS);
		view.forward(request, response);
	}

}
