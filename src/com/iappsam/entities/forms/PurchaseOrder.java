package com.iappsam.entities.forms;

import java.sql.Date;

public class PurchaseOrder {
	private int supplierID;
	private int poNumber;
	private Date date;
	private String modeOfProcurement;
	private int divisionOfficeID;
	private Date dateOfDelivery;
	private String totalAmountInWords;
	private int[] signatoryID;

	private String paymentTerm;
	private String deliveryTerm;
	private String orNumber;
	private float amount;

	public PurchaseOrder(int supplierID, int poNumber, Date date,
			String modeOfProcurement, int divisionOfficeID,
			Date dateOfDelivery, String totalAmountInWords, int[] signatoryID) {

		init(supplierID, poNumber, date, modeOfProcurement, divisionOfficeID,
				dateOfDelivery, totalAmountInWords, signatoryID, "", "", "",
				-0.1f);
	}

	public PurchaseOrder(int supplierID, int poNumber, Date date,
			String modeOfProcurement, int divisionOfficeID,
			Date dateOfDelivery, String totalAmountInWords, int[] signatoryID,
			String paymentTerm, String deliveryTerm, String orNumber,
			float amount) {
		init(supplierID, poNumber, date, modeOfProcurement, divisionOfficeID,
				dateOfDelivery, totalAmountInWords, signatoryID, paymentTerm,
				deliveryTerm, orNumber, amount);

	}

	public int getSupplierID() {
		return supplierID;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public Date getDate() {
		return date;
	}

	public String getModeOfProcurement() {
		return modeOfProcurement;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public String getTotalAmountInWords() {
		return totalAmountInWords;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void init(int supplierID, int poNumber, Date date,
			String modeOfProcurement, int divisionOfficeID,
			Date dateOfDelivery, String totalAmountInWords, int[] signatoryID,
			String paymentTerm, String deliveryTerm, String orNumber,
			float amount) {
		this.supplierID = supplierID;
		this.poNumber = poNumber;
		this.date = date;
		this.modeOfProcurement = modeOfProcurement;
		this.divisionOfficeID = divisionOfficeID;
		this.dateOfDelivery = dateOfDelivery;
		this.totalAmountInWords = totalAmountInWords;
		this.signatoryID = signatoryID;
		this.paymentTerm = paymentTerm;
		this.deliveryTerm = deliveryTerm;
		this.orNumber = orNumber;
		this.amount = amount;
	}
}
