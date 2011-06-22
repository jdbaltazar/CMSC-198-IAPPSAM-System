package com.iappsam.servlet.entities.division;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;

public class NewDivisionAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher newDivision = request.getRequestDispatcher(DivisionServlet.ADD_DIVISION);
		newDivision.forward(request, response);
	}

}
