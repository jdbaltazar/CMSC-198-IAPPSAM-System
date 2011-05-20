package com.iappsam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Serializable {

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

	public void setPersonID(int personID) {
		this.personID = personID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}
}
