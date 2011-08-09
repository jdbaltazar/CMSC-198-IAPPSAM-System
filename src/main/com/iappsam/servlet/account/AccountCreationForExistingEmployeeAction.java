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

import com.iappsam.Account;
import com.iappsam.AccountType;
import com.iappsam.ContactType;
import com.iappsam.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.EntryFormatter;

public class AccountCreationForExistingEmployeeAction implements Action{

	public AccountCreationForExistingEmployeeAction() {
		super();
	}
	private EntryFormatter entryFormatter = new EntryFormatter();
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		ArrayList<Person> availablePersons = new ArrayList<Person>();
		try {
			List<Person> persons;

			persons = pManager.getAllPersons();

			List<Account> accounts = aManager.getAllAccounts();
			boolean dontAdd = false;
			for (int i = 0; i < persons.size(); i++) {
				for (int j = 0; j < accounts.size(); j++) {
					if (persons.get(i).getId() == accounts.get(j).getPerson().getId()) {
						dontAdd = true;
					}
				}
				if (!dontAdd) {
					availablePersons.add(persons.get(i));
				}

				dontAdd = false;
			}

		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("persons", availablePersons);
		RequestDispatcher view = request.getRequestDispatcher(AccountServlet.CREATE_ACCOUNT_FOR_EXISTING);
		view.forward(request, response);
	}
	

	protected void fail(HttpServletRequest request, HttpServletResponse response, String personID, String userName, String accountType,String password, String reenterPassword) {

		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();
		ArrayList<Person> availablePersons = new ArrayList<Person>();
		try {
			List<Person> persons;

			persons = pManager.getAllPersons();

			List<Account> accounts = aManager.getAllAccounts();
			boolean dontAdd = false;
			for (int i = 0; i < persons.size(); i++) {
				for (int j = 0; j < accounts.size(); j++) {
					if (persons.get(i).getId() == accounts.get(j).getPerson().getId()) {
						dontAdd = true;
					}
				}
				if (!dontAdd) {
					availablePersons.add(persons.get(i));
				}

				dontAdd = false;
			}

			System.out.println("AvailablePersons" + availablePersons.size());
			request.setAttribute("persons", availablePersons);
			request.setAttribute("personSelect", personID);
			request.setAttribute("username", entryFormatter.spaceTrimmer(userName));
			if(userName!=null&&!userName.isEmpty()){
				request.setAttribute("userNameOK", "true");
			}
			else
				request.setAttribute("userNameOK", "false");
			if(password!=null&&reenterPassword!=null&&password.equals(reenterPassword)){
				request.setAttribute("passwordOK","true");
			}
			else
				request.setAttribute("passwordOK", "false");
			request.setAttribute("accounttype", accountType);
			RequestDispatcher view = request.getRequestDispatcher("create-account-for-employee.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
