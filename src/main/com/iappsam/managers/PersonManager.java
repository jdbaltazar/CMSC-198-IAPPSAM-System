/**
 * 
 */
package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.managers.exceptions.TransactionException;

public interface PersonManager {

	// Person

	void addPerson(Person person) throws TransactionException;

	int savePerson(Person person) throws TransactionException;

	void updatePerson(Person person) throws TransactionException;

	Person getPerson(int personId) throws TransactionException;

	void removePerson(Person person) throws TransactionException;

	boolean containsPerson(Person person) throws TransactionException;

	boolean containsPerson(String name) throws TransactionException;

	List<Person> getAllPersons() throws TransactionException;

	// Employee

	void addEmployee(Employee employee) throws TransactionException;

	int saveEmployee(Employee employee) throws TransactionException;

	void updateEmployee(Employee employee) throws TransactionException;

	Employee getEmployee(int employeeID) throws TransactionException;

	void removeEmployee(Employee employee) throws TransactionException;

	boolean containsEmployee(Employee employee) throws TransactionException;

	// boolean containsDesignation(String designation, int divisionOfficeID)
	// throws TransactionException;

	// List<Employee> getEmployeeByPerson(int personID) throws
	// TransactionException;

	List<Employee> getAllEmployee() throws TransactionException;

	// Signatory

	void addSignatory(Signatory signatory) throws TransactionException;

	int saveSignatory(Signatory signatory) throws TransactionException;

	void updateSignatory(Signatory signatory) throws TransactionException;

	Signatory getSignatory(int signatoryID) throws TransactionException;

	boolean containsSignatory(Signatory signatory) throws TransactionException;

	List<Signatory> getAllSignatories() throws TransactionException;

	// List<Signatory> getAllSignatoriesByPerson(int personID) throws
	// TransactionException;

}
