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

	@Column(name = "Supplier_ID")
	private int supplierID;

	@Id
	@Column(name = "PO_Number")
	private String poNumber;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Mode_Of_Procurement_ID")
	private int modeOfProcurementID;

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

	@Column(name = "OR_Number")
	private String orNumber;

	@Column(name = "Amount")
	private long amount;

	@Column(name = "Signatory_ID")
	private int supplierSignatoryID;

	@Column(name = "Signatory_ID1")
	private int deanSignatoryID;

	@Column(name = "Signatory_ID2")
	private int accountantSignatoryID;

	public PurchaseOrder() {

	}

	public PurchaseOrder(int supplierID, String poNumber, Date date, int modeOfProcurementID, int divisionOfficeID, Date dateOfDelivery, String paymentTerm, String deliveryTerm, String totalAmountInWords, String orNumber, long amount,
			int supplierSignatoryID, int deanSignatoryID, int accountantSignatoryID) {
		super();
		this.supplierID = supplierID;
		this.poNumber = poNumber;
		this.date = date;
		this.modeOfProcurementID = modeOfProcurementID;
		this.divisionOfficeID = divisionOfficeID;
		this.dateOfDelivery = dateOfDelivery;
		this.paymentTerm = paymentTerm;
		this.deliveryTerm = deliveryTerm;
		this.totalAmountInWords = totalAmountInWords;
		this.orNumber = orNumber;
		this.amount = amount;
		this.supplierSignatoryID = supplierSignatoryID;
		this.deanSignatoryID = deanSignatoryID;
		this.accountantSignatoryID = accountantSignatoryID;
	}

	public PurchaseOrder(int supplierID, String poNumber, Date date, int modeOfProcurementID, int divisionOfficeID, Date dateOfDelivery, String totalAmountInWords, int supplierSignatoryID, int deanSignatoryID, int accountantSignatoryID) {
		super();
		this.supplierID = supplierID;
		this.poNumber = poNumber;
		this.date = date;
		this.modeOfProcurementID = modeOfProcurementID;
		this.divisionOfficeID = divisionOfficeID;
		this.dateOfDelivery = dateOfDelivery;
		this.totalAmountInWords = totalAmountInWords;
		this.supplierSignatoryID = supplierSignatoryID;
		this.deanSignatoryID = deanSignatoryID;
		this.accountantSignatoryID = accountantSignatoryID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public Date getDate() {
		return date;
	}

	public int getModeOfProcurementID() {
		return modeOfProcurementID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public String getDeliveryTerm() {
		return deliveryTerm;
	}

	public String getTotalAmountInWords() {
		return totalAmountInWords;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public long getAmount() {
		return amount;
	}

	public int getSupplierSignatoryID() {
		return supplierSignatoryID;
	}

	public int getDeanSignatoryID() {
		return deanSignatoryID;
	}

	public int getAccountantSignatoryID() {
		return accountantSignatoryID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setModeOfProcurementID(int modeOfProcurementID) {
		this.modeOfProcurementID = modeOfProcurementID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public void setDeliveryTerm(String deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public void setTotalAmountInWords(String totalAmountInWords) {
		this.totalAmountInWords = totalAmountInWords;
	}

	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setSupplierSignatoryID(int supplierSignatoryID) {
		this.supplierSignatoryID = supplierSignatoryID;
	}

	public void setDeanSignatoryID(int deanSignatoryID) {
		this.deanSignatoryID = deanSignatoryID;
	}

	public void setAccountantSignatoryID(int accountantSignatoryID) {
		this.accountantSignatoryID = accountantSignatoryID;
	}

}
