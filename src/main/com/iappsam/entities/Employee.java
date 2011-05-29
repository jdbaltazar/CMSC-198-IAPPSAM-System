package com.iappsam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_ID")
	private int id;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Employee_Number")
	private String employeeNumber;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Person_ID")
	private Person person;

	@ManyToOne
	@JoinTable(name = "Employee_DivisionOffice", joinColumns = @JoinColumn(name = "Employee_ID"), inverseJoinColumns = @JoinColumn(name = "DivisionOffice_ID"))
	private DivisionOffice divisionOffice;

	public Employee() {
		super();
	}

	public Employee(String designation, String employeeNumber, Person person) {
		super();
		this.designation = designation;
		this.employeeNumber = employeeNumber;
		this.person = person;
	}

	public Employee(String designation, Person person) {
		super();
		this.designation = designation;
		this.person = person;
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

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
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

	public static Employee create(String designation, String title, String name) {
		return new Employee(designation, new Person(title, name));
	}
}
