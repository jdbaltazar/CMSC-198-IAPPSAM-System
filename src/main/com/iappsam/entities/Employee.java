package com.iappsam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7665203460744028855L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_ID")
	private int employeeID;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Employee_Number")
	private String employeeNumber;

	@Column(name = "Person_ID")
	private int personID;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String designation, String employeeNumber, int personID) {
		super();
		this.designation = designation;
		this.employeeNumber = employeeNumber;
		this.personID = personID;
	}

	public Employee(String designation, int personID) {
		super();
		this.designation = designation;
		this.personID = personID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public void setPersonID(int personID) {
		this.personID = personID;
	}
}
