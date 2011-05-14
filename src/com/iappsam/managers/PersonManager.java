/**
 * 
 */
package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Person;
import com.iappsam.managers.exceptions.TransactionException;

public interface PersonManager{
	
	void addPerson(Person person) throws TransactionException;
	
	int savePerson(Person person) throws TransactionException;
	
	void updatePerson(Person person) throws TransactionException;
	
	Person getPerson(int personId)  throws TransactionException;
	
	void removePerson(Person person) throws TransactionException;
	
	boolean containsPerson(Person person) throws TransactionException;
	
	boolean containsPerson(String name) throws TransactionException;
	
	List getAllPersons() throws TransactionException;
	
}
