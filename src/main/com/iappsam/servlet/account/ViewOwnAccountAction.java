package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;

public class ViewOwnAccountAction implements Action{

	public ViewOwnAccountAction() {
		super();
	}

	public void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AccountManager aManager = new AccountManagerSession();
		PersonManager pManager = new PersonManagerSession();
		String userName = (String)request.getSession().getAttribute("username");

		ArrayList<Contact> mobileNumber = new ArrayList<Contact>();
		ArrayList<Contact> landline = new ArrayList<Contact>();
		ArrayList<Contact> emailad = new ArrayList<Contact>();

		try {
			Account account = aManager.getAccount(userName);
			Set<Contact> contacts = account.getPerson().getContacts();
			List<Employee> empList = pManager.getEmployeeByPerson(account
					.getPerson().getId());

			for (Contact contact : contacts)
				if (contact.getType() == ContactType.MOBILE)
					mobileNumber.add(contact);
				else if (contact.getType() == ContactType.LANDLINE)
					landline.add(contact);
				else if (contact.getType() == ContactType.EMAIL)
					emailad.add(contact);
			request.setAttribute("account", account);
			request.setAttribute("empList", empList);
			request.setAttribute("mobile", mobileNumber);
			request.setAttribute("landline", landline);
			request.setAttribute("emailad", emailad);
			request.setAttribute("userName", userName);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request
				.getRequestDispatcher(AccountServlet.VIEW_OWN_ACCOUNT);
		view.forward(request, response);

	}

}
