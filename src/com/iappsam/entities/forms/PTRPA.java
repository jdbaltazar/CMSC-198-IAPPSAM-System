package com.iappsam.entities.forms;

public class PTRPA {
	private int ptrpaID;
	private int divisionOfficeIDRecepient;
	private int divisionOfficeIDSender;
	private int[] signatoryID;

	private String upControlNumber;

	private void init(int ptrpaID, int divisionOfficeIDRecepient,
			int divisionOfficeIDSender, int[] signatoryID,
			String upControlNumber) {
		this.ptrpaID = ptrpaID;
		this.divisionOfficeIDRecepient = divisionOfficeIDRecepient;
		this.divisionOfficeIDSender = divisionOfficeIDSender;
		this.signatoryID = signatoryID;
		this.upControlNumber = upControlNumber;
	}

	public PTRPA(int ptrpaID, int divisionOfficeIDRecepient,
			int divisionOfficeIDSender, int[] signatoryID) {
		init(ptrpaID, divisionOfficeIDRecepient, divisionOfficeIDSender,
				signatoryID, "");
	}

	public PTRPA(int ptrpaID, int divisionOfficeIDRecepient,
			int divisionOfficeIDSender, int[] signatoryID,
			String upControlNumber) {
		init(ptrpaID, divisionOfficeIDRecepient, divisionOfficeIDSender,
				signatoryID, upControlNumber);
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
		return signatoryID;
	}
}
