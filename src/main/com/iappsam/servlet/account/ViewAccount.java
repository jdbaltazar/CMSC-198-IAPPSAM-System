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
import com.iappsam.entities.Contact;
import com.iappsam.entities.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class ViewAccount
 */
@WebServlet("/ViewAccount")
public class ViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String userName = (String) request.getParameter("userName");

		String title;
		String name;

		ArrayList<String> mobileNumber = new ArrayList<String>();
		ArrayList<String> landline = new ArrayList<String>();
		ArrayList<String> emailad = new ArrayList<String>();

		String designation;
		String employeeNumber;
		String division;
		String office;

		String username;
		String acctType;

		try {
			Account account = aManager.getAccount(userName);
			Person person = pManager.getPerson(account.getPersonID());
			List<Contact> contact = cManager.getAllContactsByPerson(person.getPersonID());

			username = account.getUsername();
			acctType = account.getAccountType();
			title = person.getTitle();
			name = person.getName();

			for (int i = 0; i < contact.size(); i++) {
				if (contact.get(i).getContactType().equalsIgnoreCase("mobileNumber"))
					mobileNumber.add(contact.get(i).getData());
			}
			for(int i=0;i<contact.size();i++){
				if (contact.get(i).getContactType().equalsIgnoreCase("landline"))
					mobileNumber.add(contact.get(i).getData());
			}

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
