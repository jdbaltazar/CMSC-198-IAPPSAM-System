package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.servlet.Action;

public class AddEmployeeAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		List<DivisionOffice> dos = doManager.getAllDivisionOffice();
		request.setAttribute("divisionOffices", dos);
		RequestDispatcher add = request.getRequestDispatcher(EmployeeServlet.ADD_EMPLOYEE);
		add.forward(request, response);
	}

}
