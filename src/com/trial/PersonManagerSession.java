package com.trial;

import java.util.List;

//import javax.ejb.Stateful;
import javax.persistence.PersistenceException;

//@Stateful(name = "PersonManager")
public class PersonManagerSession extends Manager implements PersonManager{

	@Override
	public void addPerson(Person person) throws PersistenceException {
		add(person);
	}
	
//	@Override
//	public void updatePerson(Person person) throws PersistenceException {
//		em.merge(person);
//	}
//
//	@Override
//	public Person getPerson(int id) throws PersistenceException {
//		return get(Person.class, id);
//	}
//
//	@Override
//	public List<Person> getAllPersons() throws PersistenceException {
//		return getList("SELECT * FROM PERSON; ", Person.class);
//	}
//
//	@Override
//	public boolean containsPerson(int id) throws PersistenceException{
//		return contains(Person.class, id);
//	}
//	
	

}
