package com.iappsam.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Signatory")
public class Signatory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Signatory_ID", nullable = false)
	private int signatoryID;
	
	private String description;
	private Date signitureDate;
	private int employeeID;

	private void init(int signatoryID, String description, Date signatureDate,
			int employeeID) {
		this.signatoryID = signatoryID;
		this.employeeID = employeeID;
		this.description = description;
		this.signitureDate = signatureDate;
	}

	public Signatory(int signatoryID, String description, int employeeID) {
		init(signatoryID, description, null, employeeID);
	}

	public Signatory(int signatoryID, String description, Date signatureDate,
			int employeeID) {
		init(signatoryID, description, signatureDate, employeeID);

	}

	public Date getSignitureDate() {
		return signitureDate;
	}

	public void setSignitureDate(Date signitureDate) {
		this.signitureDate = signitureDate;
	}

	public int getSignatoryID() {
		return signatoryID;
	}

	public String getDescription() {
		return description;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
}
