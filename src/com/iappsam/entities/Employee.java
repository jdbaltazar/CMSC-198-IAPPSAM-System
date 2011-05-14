package com.iappsam.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_ID", nullable = false)
	private int employeeID;
	
	@Column(name = "Designation", nullable = false, length = 45)
	private String designation;
	
	@Column(name ="Employee_Number", nullable = true, length = 45)
	private String employeeNumber;
	
	@Column(name = "DivisionOffice_ID, nullable = true")
	private int divisionOfficeID;
	
	@Column(name = "Person_ID", nullable = false)
	private int personID;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String designation, String employeeNumber, int divisionOfficeID, int personID) {
		super();
		setDesignation(designation);
		setEmployeeNumber(employeeNumber);
		setDivisionOfficeID(divisionOfficeID);
		setPersonID(personID);
	}

	public Employee(String designation, int personID) {
		super();
		setDesignation(designation);
		setPersonID(personID);
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int getPersonID() {
		return personID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

}
