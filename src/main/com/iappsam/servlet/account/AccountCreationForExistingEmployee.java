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

/**
 * Servlet implementation class AccountCreationForExistingEmployee
 */
@WebServlet("/accounts/create-account-for-employee.do")
public class AccountCreationForExistingEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountCreationForExistingEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AvailablePersons" + availablePersons.size());
		request.setAttribute("persons", availablePersons);
		RequestDispatcher view = request.getRequestDispatcher("create-account-for-employee.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personID = request.getParameter("personID");
		String password = request.getParameter("password");
		String reenterPassword = request.getParameter("reenterPassword");
		String acctType = request.getParameter("accountType");
		String userName = request.getParameter("username");
		PersonManager pManager = new PersonManagerSession();
		try {
			Person p = pManager.getPerson(Integer.parseInt(personID));
			Account account = new Account();
			account.setUsername(userName);
			account.setPassword(password);
			account.setPerson(p);
			if (acctType.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE.toString())) {
				account.setType(AccountType.NON_SPSO_PERSONNEL_EMPLOYEE);
			} else if (acctType.equalsIgnoreCase(AccountType.NON_SPSO_PERSONNEL_HEAD.toString())) {
				account.setType(AccountType.NON_SPSO_PERSONNEL_HEAD);
			} else if (acctType.equalsIgnoreCase(AccountType.SPSO_PERSONNEL.toString())) {
				account.setType(AccountType.SPSO_PERSONNEL);
			} else if (acctType.equalsIgnoreCase(AccountType.SYSTEM_ADMIN.toString())) {
				account.setType(AccountType.SYSTEM_ADMIN);
			}
			AccountManager aManager = new AccountManagerSession();
			aManager.addAccount(account);
		} catch (NumberFormatException e) {
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void fail(HttpServletRequest request, HttpServletResponse response, String personID, String userName, String accountType) {

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
			request.setAttribute("username", userName);
			request.setAttribute("accounttype", accountType);
			RequestDispatcher view = request.getRequestDispatcher("create-account-for-employee.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
