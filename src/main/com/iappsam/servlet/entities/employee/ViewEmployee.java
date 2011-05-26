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

import com.iappsam.entities.Account;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class EmployeeCreation
 */
@WebServlet("/entities/employees/ViewEmployee.do")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	Person p;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeID = (String) request.getParameter("employeeID");
		System.out.println(employeeID);
		ArrayList<String> landline = new ArrayList<String>();
		ArrayList<String> mobile = new ArrayList<String>();
		ArrayList<String> emailad = new ArrayList<String>();
		try {
			Employee emp = ManagerBin.pManager.getEmployee(Integer.parseInt(employeeID));
			if (emp != null) {
				p = emp.getPerson();
				request.setAttribute("title", p.getTitle());
				request.setAttribute("name", p.getName());
				request.setAttribute("designation", emp.getDesignation());
				request.setAttribute("employeeNum", emp.getEmployeeNumber());
				request.setAttribute("division", emp.getDivisionOffice().getDivisionName() + " , " + emp.getDivisionOffice().getOfficeName());

				List<Contact> contact = ManagerBin.getInstance().cManager.getAllContactsByPerson(p.getId());

				for (int i = 0; contact != null && i < contact.size(); i++) {
					if (contact.get(i).getType() == ContactType.LANDLINE) {
						landline.add(contact.get(i).getData());
					}
					if (contact.get(i).getType() == ContactType.EMAIL) {
						emailad.add(contact.get(i).getData());
					}
					if (contact.get(i).getType() == ContactType.MOBILE) {
						mobile.add(contact.get(i).getData());
					}
				}
				request.setAttribute("mobil", mobile);
				request.setAttribute("emailad", emailad);
				request.setAttribute("landline", landline);
			}
			RequestDispatcher view = request.getRequestDispatcher("ViewEmployee.jsp");
			view.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
