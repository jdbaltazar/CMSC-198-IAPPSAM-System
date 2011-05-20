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
	private int id;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Employee_Number")
	private String employeeNumber;

	@ManyToOne
	@JoinColumn(name = "Person_ID")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	public Employee() {
		super();
	}

	public Employee(String designation, String employeeNumber, Person p) {
		super();
		this.designation = designation;
		this.employeeNumber = employeeNumber;
		this.person = p;
	}

	public Employee(String designation, Person p) {
		super();
		this.designation = designation;
		this.person = p;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public Person getPerson() {
		return person;
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice office) {
		this.divisionOffice = office;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setId(int employeeID) {
		this.id = employeeID;
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
}
