package com.iappsam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Indexed
public class Employee implements Validatable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_ID")
	private int id;

	@Field(name = "designation")
	@Column(name = "Designation")
	private String designation;

	@Column(name = "Employee_Number")
	private String employeeNumber;

	@IndexedEmbedded
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Person_ID")
	private Person person;

	@ManyToOne
	@JoinTable(name = "Employee_DivisionOffice", joinColumns = @JoinColumn(name = "Employee_ID"), inverseJoinColumns = @JoinColumn(name = "DivisionOffice_ID"))
	private DivisionOffice divisionOffice;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contactPerson")
	private Set<Supplier> suppliers = new HashSet<Supplier>();

	public Employee() {
		super();
	}

	public Employee(String designation, String employeeNumber, Person person) {
		super();
		setDesignation(designation);
		this.employeeNumber = employeeNumber;
		this.person = person;
	}

	public Employee(String designation, Person person) {
		this(designation, null, person);
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

	public boolean hasDivisionOffice() {
		return divisionOffice != null;
	}

	public void setId(int employeeID) {
		this.id = employeeID;
	}

	public void setDesignation(String designation) {
		if (designation != null)
			this.designation = designation.trim();
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (divisionOffice == null) {
			if (other.divisionOffice != null)
				return false;
		} else if (!divisionOffice.equals(other.divisionOffice))
			return false;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	public static Employee create(String designation, String title, String name) {
		return new Employee(designation, new Person(title, name));
	}

	public static Employee create(String designation, String name) {
		return new Employee(designation, new Person(name));
	}

	public Set<Supplier> getSuppliers() {
		return suppliers;
	}

	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}

	public boolean hasSuppliers() {
		if (suppliers != null)
			return !suppliers.isEmpty();

		return false;
	}

	public void removeSupplier(Supplier supplier) {
		suppliers.remove(supplier);
	}

	public int getSupplierCount() {
		return getSuppliers().size();
	}

	@Override
	public boolean validate() {
		boolean validDesignation = designation != null && !designation.isEmpty();
		boolean validPerson = person != null && person.validate();
		return validDesignation && validPerson;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", person, designation);
	}
}
