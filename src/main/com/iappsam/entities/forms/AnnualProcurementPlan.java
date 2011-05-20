package com.iappsam.entities.forms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP")
public class AnnualProcurementPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APP_ID")
	private int appID;

	@Column(name = "Year")
	private int year;

	@Column(name = "Plan_Control_Number")
	private String planControlNumber;

	@Column(name = "Date_Scheduled")
	private Date dateScheduled;

	@Column (name = "Signatory_ID")
	private int preparedBySignatoryID;

	@Column (name = "Signatory_ID1")
	private int recommendedBySignatoryID;

	public AnnualProcurementPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnualProcurementPlan(int year, String planControlNumber, Date dateScheduled, int preparedBySignatoryID, int recommendedBySignatoryID) {
		super();
		this.year = year;
		this.planControlNumber = planControlNumber;
		this.dateScheduled = dateScheduled;
		this.preparedBySignatoryID = preparedBySignatoryID;
		this.recommendedBySignatoryID = recommendedBySignatoryID;
	}

	public AnnualProcurementPlan(int year, int preparedBySignatoryID, int recommendedBySignatoryID) {
		super();
		this.year = year;
		this.preparedBySignatoryID = preparedBySignatoryID;
		this.recommendedBySignatoryID = recommendedBySignatoryID;
	}

	public int getAppID() {
		return appID;
	}

	public int getYear() {
		return year;
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

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public void setYear(int year) {
		this.year = year;
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