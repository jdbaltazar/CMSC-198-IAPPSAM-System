package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Account;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.Manager;
import com.iappsam.managers.exceptions.TransactionException;

public class AccountManagerSession extends Manager implements AccountManager{

	@Override
	public void addAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(String username) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAccount(String username) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAllAccounts() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
