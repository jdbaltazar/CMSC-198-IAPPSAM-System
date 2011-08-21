package com.iappsam.servlet.systemlog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Log;
import com.iappsam.Supplier;
import com.iappsam.managers.LogManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.LogManagerSession;
import com.iappsam.search.LogSearcher;
import com.iappsam.search.SupplierSearcher;
import com.iappsam.servlet.Action;
import com.iappsam.servlet.entities.supplier.SupplierServlet;
import com.iappsam.util.Validator;

public class SearchSystemLogsAction implements Action {

	private LogManager logManager = new LogManagerSession();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Log> logs = new ArrayList<Log>();
		String searchField = request.getParameter("searchField");

		
		LogSearcher searcher = new LogSearcher();
		if (Validator.validField(searchField)) {
			logs = searcher.search(searchField);
			request.setAttribute("searchField", searchField);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchfield: \'" + searchField + "\"");
		} else {
			try {
				logs = logManager.viewLogs();
			} catch (TransactionException e) {
				e.printStackTrace();
			}
			System.out.println("normal viewing was used!!!!!!!!!!!!!!!!!!!!!!!!");
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>size of results: " + logs.size());
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.SEARCH_SUPPLIERS);
		request.setAttribute("logs", logs);
		view.forward(request, response);

	}

}
