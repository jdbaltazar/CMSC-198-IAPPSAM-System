package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Supplier;
import com.iappsam.managers.exceptions.TransactionException;

public class NewSupplierAction implements Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher view = request.getRequestDispatcher(SupplierServlet.ADD_SUPPLIER);
		view.forward(request, response);
	}

}
