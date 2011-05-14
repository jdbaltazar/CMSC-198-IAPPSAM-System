package com.iappsam.managers.sessions;

import java.util.Iterator;
import java.util.List;

import com.iappsam.entities.Person;
import com.iappsam.managers.Manager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSession extends Manager implements PersonManager {

	@Override
	public void addPerson(Person person) throws TransactionException {
		add(person);
	}

	@Override
	public int savePerson(Person person) throws TransactionException {
		return (Integer)save(person);
	}

	@Override
	public void updatePerson(Person person) throws TransactionException {
		update(person);
	}

	@Override
	public Person getPerson(int personId) throws TransactionException {
		return (Person) get(Person.class, personId);
	}

	@Override
	public void removePerson(Person person) throws TransactionException {
		remove(person);
	}

	@Override
	public boolean containsPerson(Person person) throws TransactionException {
		return contains(person);
	}

	@Override
	public boolean containsPerson(String name) throws TransactionException {
		List persons = getList("SELECT * FROM PERSON");
		for (Iterator iter = persons.iterator(); iter.hasNext();) {
			Person p = (Person) (iter.next());
			if (p.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List getAllPersons() throws TransactionException {
		return getList("SELECT * FROM PERSON");
		// TODO Auto-generated method stub
	}


}
