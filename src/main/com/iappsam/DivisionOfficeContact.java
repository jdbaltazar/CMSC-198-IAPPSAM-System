package com.iappsam;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DivisionOffice_Contact")
public class DivisionOfficeContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1601304928203744011L;

	@Id
	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	@Id
	@Column(name = "Contact_ID")
	private int contactID;

	public DivisionOfficeContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DivisionOfficeContact(int divisionOfficeID, int contactID) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.contactID = contactID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int getContactID() {
		return contactID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

}
