package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IIRUP_Line")
public class IIRUPLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7906331383568019394L;

	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Years_In_Service")
	private int yearsInService;

	@Column(name = "Accumulated_Depreciation")
	private float accumulatedDepreciation;

	@Column(name = "Disposal_Type")
	private String disposalType;

	@Column(name = "Appraisal")
	private String appraisal;
	
	@Column(name = "OR_Number")
	private String orNumber;
	
	@Id
	@Column(name = "IIRUP_ID")
	private int iirupID;

	public IIRUPLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IIRUPLine(int itemID, int quantity, int yearsInService, float accumulatedDepreciation, String disposalType, String appraisal, String orNumber, int iirupID) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
		this.yearsInService = yearsInService;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.disposalType = disposalType;
		this.appraisal = appraisal;
		this.orNumber = orNumber;
		this.iirupID = iirupID;
	}

	public IIRUPLine(int itemID, int quantity, int yearsInService, float accumulatedDepreciation, String disposalType, String orNumber, int iirupID) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
		this.yearsInService = yearsInService;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.disposalType = disposalType;
		this.orNumber = orNumber;
		this.iirupID = iirupID;
	}

	public int getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getYearsInService() {
		return yearsInService;
	}

	public float getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}

	public String getDisposalType() {
		return disposalType;
	}

	public String getAppraisal() {
		return appraisal;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public int getIirupID() {
		return iirupID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setYearsInService(int yearsInService) {
		this.yearsInService = yearsInService;
	}

	public void setAccumulatedDepreciation(float accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public void setDisposalType(String disposalType) {
		this.disposalType = disposalType;
	}

	public void setAppraisal(String appraisal) {
		this.appraisal = appraisal;
	}

	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	public void setIirupID(int iirupID) {
		this.iirupID = iirupID;
	}

}
