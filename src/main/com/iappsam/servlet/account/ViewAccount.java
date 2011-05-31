package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Account;
import com.iappsam.entities.AccountType;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class ViewAccount
 */
@WebServlet("/accounts/viewing/ViewAccount.do")
public class ViewAccount extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1171906888802134732L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAccount() {
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

		AccountManager aManager = new AccountManagerSession();
		PersonManager pManager = new PersonManagerSession();
		ContactManager cManager = new ContactManagerSession();
		DivisionOfficeManager dManager = new DivisionOfficeManagerSession();
		String userName = (String) request.getParameter("userName");

		String title;
		String name;

		ArrayList<String> mobileNumber = new ArrayList<String>();
		ArrayList<String> landline = new ArrayList<String>();
		ArrayList<String> emailad = new ArrayList<String>();

		String username;
		AccountType acctType;

		try {
			Account account = aManager.getAccount(userName);
			Set<Contact> contacts = account.getPerson().getContacts();

			username = account.getUsername();
			acctType = account.getType();
			title = account.getPerson().getTitle();
			name = account.getPerson().getName();

			for (Contact contact : contacts)
				if (contact.getType() == ContactType.MOBILE)
					mobileNumber.add(contact.getData());
				else if (contact.getType() == ContactType.LANDLINE)
					landline.add(contact.getData());
				else if (contact.getType() == ContactType.EMAIL)
					landline.add(contact.getData());

			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("mobileNumber", mobileNumber);
			request.setAttribute("landline", landline);
			request.setAttribute("emailad", emailad);
			request.setAttribute("userName", username);
			request.setAttribute("acctType", acctType);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("../viewing/ViewAccount.jsp");
		view.forward(request, response);

	}

}
