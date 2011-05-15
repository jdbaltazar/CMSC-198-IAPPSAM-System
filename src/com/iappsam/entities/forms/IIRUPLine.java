package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IIRUP_Line")
public class IIRUPLine {

	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Years_In_Service")
	private int yearsInService;

	@Column(name = "Accumulated_Depreciation")
	private int accumulatedDepreciation;

	@Column(name = "Disposal_Type")
	private String disposalType;

	@Column(name = "OR_Number")
	private String orNumber;
	@Id
	@Column(name = "IIRUP_ID")
	private int iirupID;
	@Column(name = "Appraisal")
	private String appraisal;

	private void init(int itemID, int quantity, int yearsInService, int accumulatedDepreciation, String disposalType, String orNumber, int iirupID, String appraisal) {
		this.itemID = itemID;
		this.iirupID = iirupID;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.disposalType = disposalType;
		this.orNumber = orNumber;
		this.yearsInService = yearsInService;
		this.appraisal = appraisal;
		this.quantity = quantity;
	}

	public IIRUPLine(int itemID, int quantity, int yearsInService, int accumulatedDepreciation, String disposalType, String orNumber, int iirupID) {
		init(itemID, quantity, yearsInService, accumulatedDepreciation, disposalType, orNumber, iirupID, "");

	}

	public IIRUPLine(int itemID, int quantity, int yearsInService, int accumulatedDepreciation, String disposalType, String orNumber, int iirupID, String appraisal) {
		init(itemID, quantity, yearsInService, accumulatedDepreciation, disposalType, orNumber, iirupID, appraisal);
	}

	public IIRUPLine() {

	}

	public String getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(String appraisal) {
		this.appraisal = appraisal;
	}

	public int getIirupLineID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getYearsInService() {
		return yearsInService;
	}

	public int getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}

	public String getDisposalType() {
		return disposalType;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public int getIirupID() {
		return iirupID;
	}
}
