package com.iappsam.servlet.entities.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.search.EmployeeSearcher;
import com.iappsam.servlet.Action;

public class SearchEmployeesAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {

		String query = request.getParameter("searchField");

		PersonManager pManager = new PersonManagerSession();

		if (query == null || query.isEmpty()) {
			try {
				List<Person> all = pManager.getAllPersons();
				List<Person> persons = new ArrayList<Person>();
				for (Person p : all) {
					if (p.getEmployments().size() > 0)
						persons.add(p);
				}
				request.setAttribute("persons", persons);
				System.out.println("size of persons: " + persons.size());
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}

		// This is Where the search method ought to be
		else {
			EmployeeSearcher searcher = new EmployeeSearcher();
			List<Employee> employees = searcher.search(query);
			List<Person> persons = new ArrayList<Person>();
			for (Employee e : employees) {
				if (!persons.contains(e.getPerson())) {
					persons.add(e.getPerson());
				}
			}

			request.setAttribute("persons", persons);
			request.setAttribute("query", query);
		}

		RequestDispatcher view = request.getRequestDispatcher(EmployeeServlet.SEARCH_EMPLOYEES);
		view.forward(request, response);
	}

}
