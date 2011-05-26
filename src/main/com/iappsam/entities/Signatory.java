package com.iappsam.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Signatory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Signatory_ID")
	private int id;

	@Column(name = "Description")
	private String description;

	@Column(name = "Date")
	private Date signatureDate;

	@ManyToOne
	@JoinColumn(name = "Employee_ID")
	private Employee employee;

	public Signatory() {
		super();
	}

	public Signatory(String description, Date date, Employee employee) {
		super();
		this.description = description;
		this.signatureDate = date;
		this.employee = employee;
	}

	public Signatory(String description, Employee employee) {
		super();
		this.description = description;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(int signatoryID) {
		this.id = signatoryID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
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
		Signatory other = (Signatory) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
