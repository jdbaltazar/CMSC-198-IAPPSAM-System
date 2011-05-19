package com.iappsam.entities.forms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP")
public class AnnualProcurementPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6436021267469992187L;

	@Id
	@Column(name = "Year")
	private int year;
	
	@Id
	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	@Column(name = "Plan_Control_Number")
	private String planControlNumber;

	@Column(name = "Date_Scheduled")
	private Date dateScheduled;

	@Column(name = "Signatory_ID")
	private int preparedBySignatoryID;

	@Column(name = "Signatory_ID1")
	private int recommendedBySignatoryID;

	public AnnualProcurementPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnualProcurementPlan(int year, int divisionOfficeID, String planControlNumber, Date dateScheduled, int preparedBySignatoryID, int recommendedBySignatoryID) {
		super();
		this.year = year;
		this.divisionOfficeID = divisionOfficeID;
		this.planControlNumber = planControlNumber;
		this.dateScheduled = dateScheduled;
		this.preparedBySignatoryID = preparedBySignatoryID;
		this.recommendedBySignatoryID = recommendedBySignatoryID;
	}

	public AnnualProcurementPlan(int year, int divisionOfficeID, int preparedBySignatoryID, int recommendedBySignatoryID) {
		super();
		this.year = year;
		this.divisionOfficeID = divisionOfficeID;
		this.preparedBySignatoryID = preparedBySignatoryID;
		this.recommendedBySignatoryID = recommendedBySignatoryID;
	}

	public int getYear() {
		return year;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public String getPlanControlNumber() {
		return planControlNumber;
	}

	public Date getDateScheduled() {
		return dateScheduled;
	}

	public int getPreparedBySignatoryID() {
		return preparedBySignatoryID;
	}

	public int getRecommendedBySignatoryID() {
		return recommendedBySignatoryID;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setPlanControlNumber(String planControlNumber) {
		this.planControlNumber = planControlNumber;
	}

	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public void setPreparedBySignatoryID(int preparedBySignatoryID) {
		this.preparedBySignatoryID = preparedBySignatoryID;
	}

	public void setRecommendedBySignatoryID(int recommendedBySignatoryID) {
		this.recommendedBySignatoryID = recommendedBySignatoryID;
	}
	
}
