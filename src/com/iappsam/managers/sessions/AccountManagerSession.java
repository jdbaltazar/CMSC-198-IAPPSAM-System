package com.iappsam.managers.sessions;

import java.util.List;

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
	public String saveAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		return (String)save(account);
	}

	@Override
	public void updateAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		update(account);
	}

	@Override
	public Account getAccount(String username) throws TransactionException {
		// TODO Auto-generated method stub
		return (Account)get(Account.class, username);
	}

	@Override
	public void removeAccount(Account account) throws TransactionException {
		remove(account);
	}

	@Override
	public boolean containsAccount(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(account);
	}

	@Override
	public boolean containsAccount(String username) throws TransactionException {
		// TODO Auto-generated method stub
		return (getAccount(username)!=null);
	}

	@Override
	public List<Account> getAllAccounts() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Account.class);
	}

	

}
