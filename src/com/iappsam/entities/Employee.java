package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_ID")
	private int employeeID;
	
	@Column(name = "Designation")
	private String designation;
	
	@Column(name ="Employee_Number")
	private String employeeNumber;
	
	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;
	
	@Column(name = "Person_ID")
	private int personID;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String designation, String employeeNumber, int divisionOfficeID, int personID) {
		super();
		this.designation = designation;
		this.employeeNumber = employeeNumber;
		this.divisionOfficeID = divisionOfficeID;
		this.personID = personID;
	}

	public Employee(String designation, int personID) {
		super();
		this.designation = designation;
		this.personID = personID;
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
