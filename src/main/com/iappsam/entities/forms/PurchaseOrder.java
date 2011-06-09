package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Supplier;

@Entity
@Table(name = "Purchase_Order")
public class PurchaseOrder {

	@Id
	@Column(name = "PO_Number")
	private String poNumber;

	@ManyToOne
	@JoinColumn(name = "Supplier_ID")
	private Supplier supplier;

	@Column(name = "Date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "Mode_Of_Procurement_ID")
	private ModeOfProcurement modeOfProcurement;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

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

	@ManyToOne
	@JoinColumn(name = "Supplier_Name_ID")
	private Employee supplierName;

	@ManyToOne
	@JoinColumn(name = "Accountant_ID")
	private Employee accountant;

	@ManyToOne
	@JoinColumn(name = "Dean_ID")
	private Employee dean;

	public PurchaseOrder() {
	}

	public PurchaseOrder(String poNumber, Supplier supplier, Date date, ModeOfProcurement modeOfProcurement, DivisionOffice divisionOffice,
			Date dateOfDelivery, Employee supplierName, Employee accountant, Employee dean) {
		super();
		this.poNumber = poNumber;
		this.supplier = supplier;
		this.date = date;
		this.modeOfProcurement = modeOfProcurement;
		this.divisionOffice = divisionOffice;
		this.dateOfDelivery = dateOfDelivery;
		this.supplierName = supplierName;
		this.accountant = accountant;
		this.dean = dean;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public Date getDate() {
		return date;
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

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ModeOfProcurement getModeOfProcurement() {
		return modeOfProcurement;
	}

	public void setModeOfProcurement(ModeOfProcurement modeOfProcurement) {
		this.modeOfProcurement = modeOfProcurement;
	}

	public Employee getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(Employee supplierName) {
		this.supplierName = supplierName;
	}

	public Employee getAccountant() {
		return accountant;
	}

	public void setAccountant(Employee accountant) {
		this.accountant = accountant;
	}

	public Employee getDean() {
		return dean;
	}

	public void setDean(Employee dean) {
		this.dean = dean;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poNumber == null) ? 0 : poNumber.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (poNumber == null) {
			if (other.poNumber != null)
				return false;
		} else if (!poNumber.equals(other.poNumber))
			return false;
		return true;
	}
}
