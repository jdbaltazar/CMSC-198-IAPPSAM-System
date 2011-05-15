package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase_Order")
public class PurchaseOrder {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Supplier_ID")
	private int supplierID;

	@Id
	@Column(name = "PO_Number")
	private int poNumber;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Mode_Of_Procurement")
	private String modeOfProcurement;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	@Column(name = "Date_Of_Delivery")
	private Date dateOfDelivery;

	@Column(name = "Payment_Term")
	private String paymentTerm;

	@Column(name = "Delivery_Term")
	private String deliveryTerm;

	@Column(name = "Total_Amount_In_Words")
	private String totalAmountInWords;

	@Column(name = "Signatory_ID")
	private int supplierSignatoryID;

	@Column(name = "Signatory_ID1")
	private int deanSignatoryID;

	@Column(name = "Signatory_ID2")
	private int accountantSignatoryID;

	private String orNumber;
	private float amount;

	public PurchaseOrder() {

	}

	public PurchaseOrder(int supplierID, int poNumber, Date date, String modeOfProcurement, int divisionOfficeID, Date dateOfDelivery, String totalAmountInWords, int supplierSignatoryID, int deanSignatoryID, int accountantSignatoryID) {
		init(supplierID, poNumber, date, modeOfProcurement, divisionOfficeID, dateOfDelivery, totalAmountInWords, supplierSignatoryID, deanSignatoryID, accountantSignatoryID, "", "", "", -1);

	}

	public PurchaseOrder(int supplierID, int poNumber, Date date, String modeOfProcurement, int divisionOfficeID, Date dateOfDelivery, String totalAmountInWords, int supplierSignatoryID, int deanSignatoryID, int accountantSignatoryID,
			String paymentTerm, String deliveryTerm, String orNumber, float amount) {
		init(supplierID, poNumber, date, modeOfProcurement, divisionOfficeID, dateOfDelivery, totalAmountInWords, supplierSignatoryID, deanSignatoryID, accountantSignatoryID, paymentTerm, deliveryTerm, orNumber, amount);

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
		int[] signatoryID = { supplierSignatoryID, deanSignatoryID, accountantSignatoryID };
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

	public void init(int supplierID, int poNumber, Date date, String modeOfProcurement, int divisionOfficeID, Date dateOfDelivery, String totalAmountInWords, int supplierSignatoryID, int deanSignatoryID, int accountantSignatoryID,
			String paymentTerm, String deliveryTerm, String orNumber, float amount) {
		this.supplierID = supplierID;
		this.poNumber = poNumber;
		this.date = date;
		this.modeOfProcurement = modeOfProcurement;
		this.divisionOfficeID = divisionOfficeID;
		this.dateOfDelivery = dateOfDelivery;
		this.totalAmountInWords = totalAmountInWords;
		this.accountantSignatoryID = accountantSignatoryID;
		this.deanSignatoryID = deanSignatoryID;
		this.supplierSignatoryID = supplierSignatoryID;
		this.paymentTerm = paymentTerm;
		this.deliveryTerm = deliveryTerm;
		this.orNumber = orNumber;
		this.amount = amount;
	}
}
