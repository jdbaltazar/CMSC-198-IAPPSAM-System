package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Employee;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class EmployeeCreation
 */
@WebServlet("/entities/employees/search_employee.do")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = (String) request.getAttribute("searchEmployeeField");
		PersonManager pManager = new PersonManagerSession();
		ArrayList<String> employeeID = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> designation = new ArrayList<String>();

		if (query == null || query.isEmpty()) {
			try {
				List<Employee> empList = pManager.getAllEmployee();
				System.out.println("size of empls:" + empList.size());

				for (int i = 0; i < empList.size(); i++) {
					employeeID.add("" + empList.get(i).getId());
					System.out.println(empList.get(i).getId());
					designation.add(empList.get(i).getDesignation());
					name.add("" + empList.get(i).getPerson().getName());
				}
				request.setAttribute("employeeID", employeeID);
				request.setAttribute("name", name);
				request.setAttribute("designation", designation);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// This is Where the search method ought to be
		else {
			try {
				List<Employee> empList = pManager.getAllEmployee();
				for (int i = 0; i < empList.size(); i++) {
					employeeID.add("" + empList.get(i).getId());
					designation.add(empList.get(i).getDesignation());
					name.add("" + empList.get(i).getPerson().getName());
				}
				request.setAttribute("employeeID", employeeID);
				request.setAttribute("name", name);
				request.setAttribute("designation", designation);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		RequestDispatcher view = request.getRequestDispatcher("search_employee.jsp");
		view.forward(request, response);

	}
}
