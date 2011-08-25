package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.EntryFormatter;

public class AccountCreationForExistingEmployeeAction implements Action {

	public AccountCreationForExistingEmployeeAction() {
		super();
	}

	private EntryFormatter entryFormatter = new EntryFormatter();

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();

		// get all persons
		// subtract supplier persons
		// subtract those with accounts

		List<Person> forwardP = new ArrayList<Person>();
		List<Employee> emps = new ArrayList<Employee>();
		List<Account> accs = new ArrayList<Account>();

		try {
			forwardP = pManager.getAllPersons();
		} catch (TransactionException e2) {
			e2.printStackTrace();
		}

		try {
			emps = pManager.getAllSupplierEmployee();
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}

		try {
			accs = aManager.getAllAccounts();
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}

		for (Employee e : emps) {
			if (forwardP.contains(e.getPerson())) {
				forwardP.remove(e.getPerson());
			}
		}

		for (Account a : accs) {
			if (forwardP.contains(a.getPerson())) {
				forwardP.remove(a.getPerson());
			}
		}

		request.setAttribute("persons", forwardP);
		request.getRequestDispatcher(AccountServlet.CREATE_ACCOUNT_FOR_EXISTING).forward(request, response);

	}

	protected void fail(HttpServletRequest request, HttpServletResponse response, String personID, String userName, String accountType,
			String password, String reenterPassword) throws ServletException, IOException {

		PersonManager pManager = new PersonManagerSession();
		AccountManager aManager = new AccountManagerSession();

		// get all persons
		// subtract supplier persons
		// subtract those with accounts

		List<Person> forwardP = new ArrayList<Person>();
		List<Employee> emps = new ArrayList<Employee>();
		List<Account> accs = new ArrayList<Account>();

		try {
			forwardP = pManager.getAllPersons();
		} catch (TransactionException e2) {
			e2.printStackTrace();
		}

		try {
			emps = pManager.getAllSupplierEmployee();
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}

		try {
			accs = aManager.getAllAccounts();
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}

		for (Employee e : emps) {
			if (forwardP.contains(e.getPerson())) {
				forwardP.remove(e.getPerson());
			}
		}

		for (Account a : accs) {
			if (forwardP.contains(a.getPerson())) {
				forwardP.remove(a.getPerson());
			}
		}

		request.setAttribute("persons", forwardP);
		request.setAttribute("personSelect", personID);
		request.setAttribute("username", entryFormatter.spaceTrimmer(userName));
		if (userName != null && !userName.isEmpty()) {
			request.setAttribute("userNameOK", "true");
		} else
			request.setAttribute("userNameOK", "false");
		if (password != null && reenterPassword != null && password.equals(reenterPassword)) {
			request.setAttribute("passwordOK", "true");
		} else
			request.setAttribute("passwordOK", "false");
		request.setAttribute("accounttype", accountType);
		RequestDispatcher view = request.getRequestDispatcher(AccountServlet.CREATE_ACCOUNT_FOR_EXISTING);
		view.forward(request, response);

	}

}
