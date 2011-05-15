package com.iappsam.managers.sessions;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.Manager;
import com.iappsam.managers.exceptions.TransactionException;

public class AccountManagerSession extends Manager implements AccountManager{

	@Override
	public void addAccount(Account account) throws TransactionException {
		add(account);
		
	}

	@Override
	public void updateAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validPassword(String password) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getAccount(String username) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllAccounts() throws TransactionException {
		// TODO Auto-generated method stub
		
	}

}
