package com.iappsam.entities.forms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP")
public class AnnualProcurementPlan {
	private static final long serialVersionUID = 6436021267469992187L;

	@Embeddable
	public static class Id implements Serializable {
		private static final long serialVersionUID = -8852829263574541273L;

		@Column(name = "Year")
		private int year;
		@Column(name = "DivisionOffice_ID")
		private int divisionOfficeID;

		public void id() {
		}

		public Id(int year, int divisionOfficeID) {
			super();
			this.year = year;
			this.divisionOfficeID = divisionOfficeID;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getDivisionOfficeID() {
			return divisionOfficeID;
		}

		public void setDivisionOfficeID(int divisionOfficeID) {
			this.divisionOfficeID = divisionOfficeID;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + divisionOfficeID;
			result = prime * result + year;
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
			Id other = (Id) obj;
			if (divisionOfficeID != other.divisionOfficeID)
				return false;
			if (year != other.year)
				return false;
			return true;
		}
	}

	@EmbeddedId
	private Id id;

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
	}

	public AnnualProcurementPlan(AnnualProcurementPlan.Id id, String planControlNumber, Date dateScheduled, int preparedBySignatoryID,
			int recommendedBySignatoryID) {
		this(id, preparedBySignatoryID, recommendedBySignatoryID);
		this.planControlNumber = planControlNumber;
		this.dateScheduled = dateScheduled;
	}

	public AnnualProcurementPlan(AnnualProcurementPlan.Id id, int preparedBySignatoryID, int recommendedBySignatoryID) {
		super();
		this.id = id;
		this.preparedBySignatoryID = preparedBySignatoryID;
		this.recommendedBySignatoryID = recommendedBySignatoryID;
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

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
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
