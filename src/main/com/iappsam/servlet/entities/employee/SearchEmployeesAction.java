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
import com.iappsam.Supplier;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.search.EmployeeSearcher;
import com.iappsam.servlet.Action;

public class SearchEmployeesAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String query = request.getParameter("searchField");

		PersonManager pManager = new PersonManagerSession();

		if (query == null || query.isEmpty()) {
			try {
				List<Person> all = pManager.getAllPersons();
				List<Person> persons = new ArrayList<Person>();
				for (Person p : all) {
					if (p.getEmployments().size() > 0) {
						boolean upEmployee = true;
						List<Employee> emps = new ArrayList<Employee>();
						emps = pManager.getEmployeeByPerson(p.getId());
						for (Employee e : emps) {
							if (e.getDivisionOffice() == null)
								upEmployee = false;
						}
						if (upEmployee)
							persons.add(p);
					}
				}
				request.setAttribute("persons", persons);
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}

		// the search method
		else {
			EmployeeSearcher searcher = new EmployeeSearcher();
			List<Employee> employees = searcher.search(query);
			List<Person> dummy = new ArrayList<Person>();
			List<Person> persons = new ArrayList<Person>();
			for (Employee e : employees) {
				if (!dummy.contains(e.getPerson())) {
					dummy.add(e.getPerson());
				}
			}

			for (Person p : dummy) {
				if (p.getEmployments().size() > 0) {
					boolean upEmployee = true;
					List<Employee> emps = new ArrayList<Employee>();
					try {
						emps = pManager.getEmployeeByPerson(p.getId());
					} catch (TransactionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (Employee e : emps) {
						if (e.getDivisionOffice() == null)
							upEmployee = false;
					}
					if (upEmployee)
						persons.add(p);
				}
			}

			SupplierManager sManager = new SupplierManagerSession();
			List<Supplier> spplrs = new ArrayList<Supplier>();
			try {
				spplrs = sManager.getAllSuppliers();
			} catch (TransactionException e1) {
				e1.printStackTrace();
			}

			for (Supplier s : spplrs) {
				if (dummy.contains(s.getContactPerson().getPerson()))
					dummy.remove(s.getContactPerson().getPerson());
			}

			request.setAttribute("persons", dummy);
			request.setAttribute("query", query);
		}

		RequestDispatcher view = request.getRequestDispatcher(EmployeeServlet.SEARCH_EMPLOYEES);
		view.forward(request, response);
	}

}
