package com.iappsam.managers;

import com.iappsam.entities.Account;
import com.iappsam.managers.exceptions.TransactionException;

public interface AccountManager {

	void addAccount(Account account) throws TransactionException;
	
	void updateAccount(Account account) throws TransactionException;

	boolean validPassword(String password) throws TransactionException;
	
	void getAccount(String username) throws TransactionException;
	
	void getAllAccounts() throws TransactionException;
	
}
