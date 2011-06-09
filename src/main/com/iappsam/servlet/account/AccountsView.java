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
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;

@WebServlet("/accounts/ViewAccounts.do")
public class AccountsView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountsView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountManager aManager = new AccountManagerSession();

		ArrayList<String> userName = new ArrayList<String>();
		ArrayList<String> acctType = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		
		
		try {
			List<Account> accounts = aManager.getAllAccounts();
			for (int i = 0; i < accounts.size(); i++) {
				userName.add(accounts.get(i).getUsername());
				acctType.add(accounts.get(i).getType().toString());
				name.add(accounts.get(i).getPerson().getName());
			}
			
			request.setAttribute("accounts", accounts);
		} catch (org.hibernate.TransactionException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("userName", userName);
		request.setAttribute("acctType", acctType);
		request.setAttribute("name", name);
		request.setAttribute("listSize", "" + userName.size());

		request.getRequestDispatcher("../accounts/ViewAccounts.jsp").forward(request, response);
	}

}
