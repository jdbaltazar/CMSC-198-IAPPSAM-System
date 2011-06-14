package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

@WebServlet("/accounts/viewing/ViewWorkInformation")
public class ViewWorkInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewWorkInformation() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountManager am = new AccountManagerSession();
		PersonManager pm = new PersonManagerSession();

		String userName = request.getParameter("userName");

		List<String> designations = new ArrayList<String>();
		List<String> employeeNumbers = new ArrayList<String>();
		List<String> divisions = new ArrayList<String>();
		List<String> offices = new ArrayList<String>();

		Account account;
		try {
			account = am.getAccount(userName);

			Person person = account.getPerson();
			List<Employee> employees = pm.getEmployeeByPerson(person.getId());
			for (Employee employee : employees) {

				designations.add(employee.getDesignation());
				employeeNumbers.add("" + employee.getPerson());

				divisions.add(employee.getDivisionOffice().getDivisionName());

				if (employee.hasDivisionOffice())
					offices.add(employee.getDivisionOffice().getOfficeName());
				else
					offices.add(".");
			}
			request.setAttribute("designation", designations);
			request.setAttribute("employeeNum", employeeNumbers);
			request.setAttribute("division", divisions);
			request.setAttribute("office", offices);

		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("ViewWorkInfo.jsp").forward(request, response);
	}
}
