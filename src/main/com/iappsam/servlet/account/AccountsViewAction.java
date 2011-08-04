
package com.iappsam.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.servlet.Action;

public class AccountsViewAction implements Action{

	public AccountsViewAction() {
		super();
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		} catch (TransactionException e) {
			e.printStackTrace();
		} 

		request.setAttribute("userName", userName);
		request.setAttribute("acctType", acctType);
		request.setAttribute("name", name);
		request.setAttribute("listSize", "" + userName.size());

		request.getRequestDispatcher(AccountServlet.VIEW_ACCOUNTS).forward(request, response);
	}
	

}
