package com.trial;

import java.util.List;

//import javax.ejb.Remote;
import javax.persistence.PersistenceException;

//@Remote
public interface PersonManager {
	
	void addPerson(Person person) throws PersistenceException;
	
//	void updatePerson(Person person) throws PersistenceException;
//	
//	Person getPerson(int id) throws PersistenceException;
//	
//	List<Person> getAllPersons() throws PersistenceException;
//	
//	boolean containsPerson(int id) throws PersistenceException;
	
}