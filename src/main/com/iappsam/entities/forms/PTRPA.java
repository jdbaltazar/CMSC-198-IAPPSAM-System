package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PTRPA")
public class PTRPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PTRPA_ID")
	private int ptrpaID;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeIDRecepient;

	@Column(name = "DivisionOffice_ID1")
	private int divisionOfficeIDSender;
	@Column(name = "UP_Control_Number")
	private String upControlNumber;

	@Column(name = "Signatory_ID")
	private int transferredBySignatoryID;

	@Column(name = "Signatory_ID1")
	private int acceptedBySignatoryID;

	@Column(name = "Signatory_ID2")
	private int witnessedBySignatoryID;

	private void init(int ptrpaID, int divisionOfficeIDRecepient, int transferredBySignatoryID, int acceptedBySignatoryID, int witnessedBySignatoryID, int divisionOfficeIDSender, String upControlNumber) {
		this.ptrpaID = ptrpaID;
		this.divisionOfficeIDRecepient = divisionOfficeIDRecepient;
		this.divisionOfficeIDSender = divisionOfficeIDSender;
		this.transferredBySignatoryID = transferredBySignatoryID;
		this.acceptedBySignatoryID = acceptedBySignatoryID;
		this.witnessedBySignatoryID = witnessedBySignatoryID;
		this.upControlNumber = upControlNumber;
	}

	public PTRPA(int ptrpaID, int divisionOfficeIDRecepient, int transferredBySignatoryID, int acceptedBySignatoryID, int witnessedBySignatoryID, int divisionOfficeIDSender) {
		init(ptrpaID, divisionOfficeIDRecepient, transferredBySignatoryID, acceptedBySignatoryID, witnessedBySignatoryID, divisionOfficeIDSender, upControlNumber);
	}

	public PTRPA(int ptrpaID, int divisionOfficeIDRecepient, int transferredBySignatoryID, int acceptedBySignatoryID, int witnessedBySignatoryID, int divisionOfficeIDSender, String upControlNumber) {
		init(ptrpaID, divisionOfficeIDRecepient, transferredBySignatoryID, acceptedBySignatoryID, witnessedBySignatoryID, divisionOfficeIDSender, upControlNumber);
	}

	public String getUpControlNumber() {
		return upControlNumber;
	}

	public void setUpControlNumber(String upControlNumber) {
		this.upControlNumber = upControlNumber;
	}

	public int getPtrpaID() {
		return ptrpaID;
	}

	public int getDivisionOfficeIDRecepient() {
		return divisionOfficeIDRecepient;
	}

	public int getDivisionOfficeIDSender() {
		return divisionOfficeIDSender;
	}

	public int[] getSignatoryID() {
		int[] signatories = { transferredBySignatoryID, acceptedBySignatoryID, witnessedBySignatoryID };
		return signatories;
	}
}
