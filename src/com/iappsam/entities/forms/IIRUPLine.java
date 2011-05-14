package com.iappsam.entities.forms;

public class IIRUPLine {
	private int iirupLineID;
	private int quantity;
	private int yearsInService;
	private int accumulatedDepreciation;
	private String disposalType;
	private String orNumber;
	private int iirupID;

	private String appraisal;

	private void init(int iirupLineID, int quantity, int yearsInService,
			int accumulatedDepreciation, String disposalType, String orNumber,
			int iirupID, String appraisal) {
		this.iirupLineID = iirupLineID;
		this.iirupID = iirupID;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.disposalType = disposalType;
		this.orNumber = orNumber;
		this.yearsInService = yearsInService;
		this.appraisal = appraisal;
		this.quantity = quantity;
	}

	public IIRUPLine(int iirupLineID, int quantity, int yearsInService,
			int accumulatedDepreciation, String disposalType, String orNumber,
			int iirupID) {
		init(iirupLineID, quantity, yearsInService, accumulatedDepreciation,
				disposalType, orNumber, iirupID, "");

	}

	public IIRUPLine(int iirupLineID, int quantity, int yearsInService,
			int accumulatedDepreciation, String disposalType, String orNumber,
			int iirupID, String appraisal) {
		init(iirupLineID, quantity, yearsInService, accumulatedDepreciation,
				disposalType, orNumber, iirupID, appraisal);
	}

	public String getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(String appraisal) {
		this.appraisal = appraisal;
	}

	public int getIirupLineID() {
		return iirupLineID;
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
