package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Account;
import com.iappsam.managers.exceptions.TransactionException;

public interface AccountManager {

	void addAccount(Account account) throws TransactionException;

	void updateAccount(Account account) throws TransactionException;

	// void updateAccountUsername(String username, String newUsername) throws
	// TransactionException;

	Account getAccount(String username) throws TransactionException;

	void removeAccount(Account account) throws TransactionException;

	boolean containsAccount(Account account) throws TransactionException;

	boolean containsAccount(String username) throws TransactionException;

	List<Account> getAllAccounts() throws TransactionException;

}
