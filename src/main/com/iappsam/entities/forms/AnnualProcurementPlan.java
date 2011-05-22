package com.iappsam.entities.forms;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Signatory;

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

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	@ManyToOne
	@JoinColumn(name = "Signatory_ID")
	private Signatory preparedBy;

	@ManyToOne
	@JoinColumn(name = "Signatory_ID1")
	private Signatory recommendedBy;

	@OneToMany(mappedBy = "app", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<AnnualProcurementPlanLine> lines = new HashSet<AnnualProcurementPlanLine>();

	public AnnualProcurementPlan() {
		super();
	}

	public AnnualProcurementPlan(int year, String planControlNumber, Date dateScheduled, DivisionOffice office, Signatory s, Signatory s2) {
		this(year, office, s, s2);
		this.planControlNumber = planControlNumber;
		this.dateScheduled = dateScheduled;
	}

	public AnnualProcurementPlan(int year, DivisionOffice office, Signatory s, Signatory s2) {
		this.year = year;
		this.divisionOffice = office;
		this.preparedBy = s;
		this.recommendedBy = s2;
	}

	public Set<AnnualProcurementPlanLine> getLines() {
		return lines;
	}

	public int getId() {
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

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void addLine(AnnualProcurementPlanLine line) {
		line.setApp(this);
		lines.add(line);
	}

	public void removeLine(AnnualProcurementPlanLine line) {
		line.setApp(null);
		lines.remove(line);
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public Signatory getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(Signatory preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Signatory getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(Signatory recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public void setPlanControlNumber(String planControlNumber) {
		this.planControlNumber = planControlNumber;
	}

	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appID;
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
		AnnualProcurementPlan other = (AnnualProcurementPlan) obj;
		if (appID != other.appID)
			return false;
		return true;
	}

}