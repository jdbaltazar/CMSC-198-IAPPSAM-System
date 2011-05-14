package com.iappsam.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Signatory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Signatory_ID")
	private int signatoryID;
	
	@Column(name = "Description")
	private String description;
	
	@Column (name = "Date")
	private Date signatureDate;
	
	@Column (name = "Employee_ID")
	private int employeeID;

	public Signatory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Signatory(String description, Date signatureDate, int employeeID) {
		super();
		this.description = description;
		this.signatureDate = signatureDate;
		this.employeeID = employeeID;
	}

	public Signatory(String description, int employeeID) {
		super();
		this.description = description;
		this.employeeID = employeeID;
	}

	public int getSignatoryID() {
		return signatoryID;
	}

	public String getDescription() {
		return description;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setSignatoryID(int signatoryID) {
		this.signatoryID = signatoryID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

}
