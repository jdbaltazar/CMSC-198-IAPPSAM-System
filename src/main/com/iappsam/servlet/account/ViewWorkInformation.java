package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class ViewWorkInformation
 */
@WebServlet("/accounts/viewing/ViewWorkInformation")
public class ViewWorkInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewWorkInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//

		AccountManager aManager = new AccountManagerSession();
		PersonManager pManager = new PersonManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		String userName = (String) request.getParameter("userName");

		ArrayList<String> designation = new ArrayList<String>();
		ArrayList<String> employeeNumber = new ArrayList<String>();
		ArrayList<String> division = new ArrayList<String>();
		ArrayList<String> office = new ArrayList<String>();

		Account account;
		try {
			account = aManager.getAccount(userName);

			System.out.println("" + account.getPersonID());
			Person person = pManager.getPerson(account.getPersonID());
			List<Employee> employee = pManager.getEmployeeByPerson(person.getId());
			for (int i = 0; i < employee.size(); i++) {
				designation.add(employee.get(i).getDesignation());
				employeeNumber.add("" + employee.get(i).getPerson());

				if ((employee.get(i).getPerson() != null))
					division.add(dManager.getDivisionOfficeByEmployee(employee.get(i).getId()).getDivisionName());
				else
					division.add(".");

				if (dManager.getDivisionOfficeByEmployee(employee.get(i).getId()) != null)
					office.add(dManager.getDivisionOfficeByEmployee(employee.get(i).getId()).getOfficeName());
				else
					office.add(".");

			}
			request.setAttribute("designation", designation);
			request.setAttribute("employeeNum", employeeNumber);
			request.setAttribute("division", division);
			request.setAttribute("office", office);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("ViewWorkInfo.jsp");
		view.forward(request, response);
	}

}
