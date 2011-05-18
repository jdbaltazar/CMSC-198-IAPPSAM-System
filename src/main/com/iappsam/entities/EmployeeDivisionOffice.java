package com.iappsam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_DivisionOffice")
public class EmployeeDivisionOffice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5098728539858688842L;

	@Id
	@Column(name = "Employee_ID")
	private int employeeID;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	public EmployeeDivisionOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDivisionOffice(int employeeID, int divisionOfficeID) {
		super();
		this.employeeID = employeeID;
		this.divisionOfficeID = divisionOfficeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

}
