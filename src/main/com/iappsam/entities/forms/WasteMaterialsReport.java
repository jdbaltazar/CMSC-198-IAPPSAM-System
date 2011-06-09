package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Waste_Materials_Report")
public class WasteMaterialsReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Waste_Materials_Report_ID")
	private int wmrID;

	@Column(name = "Place_Of_Storage")
	private String placeOfStorage;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Signatory_ID")
	private int propertyOfficerSignatoryID;

	@Column(name = "Signatory_ID1")
	private int approvedBySignatoryID;

	@Column(name = "Signatory_ID2")
	private int propertyInspectorSignatoryID;

	@Column(name = "Signatory_ID3")
	private int witnessToSignatoryID;

	public WasteMaterialsReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WasteMaterialsReport(String placeOfStorage, int divisionOfficeID, Date date, int propertyOfficerSignatoryID, int approvedBySignatoryID, int propertyInspectorSignatoryID, int witnessToSignatoryID) {
		super();
		this.placeOfStorage = placeOfStorage;
		this.divisionOfficeID = divisionOfficeID;
		this.date = date;
		this.propertyOfficerSignatoryID = propertyOfficerSignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
		this.propertyInspectorSignatoryID = propertyInspectorSignatoryID;
		this.witnessToSignatoryID = witnessToSignatoryID;
	}

	public WasteMaterialsReport(int divisionOfficeID, Date date, int propertyOfficerSignatoryID, int approvedBySignatoryID, int propertyInspectorSignatoryID, int witnessToSignatoryID) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.date = date;
		this.propertyOfficerSignatoryID = propertyOfficerSignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
		this.propertyInspectorSignatoryID = propertyInspectorSignatoryID;
		this.witnessToSignatoryID = witnessToSignatoryID;
	}

	public int getID() {
		return wmrID;
	}

	public String getPlaceOfStorage() {
		return placeOfStorage;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public Date getDate() {
		return date;
	}

	public int getPropertyOfficerSignatoryID() {
		return propertyOfficerSignatoryID;
	}

	public int getApprovedBySignatoryID() {
		return approvedBySignatoryID;
	}

	public int getPropertyInspectorSignatoryID() {
		return propertyInspectorSignatoryID;
	}

	public int getWitnessToSignatoryID() {
		return witnessToSignatoryID;
	}

	public void setWmrID(int wmrID) {
		this.wmrID = wmrID;
	}

	public void setPlaceOfStorage(String placeOfStorage) {
		this.placeOfStorage = placeOfStorage;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPropertyOfficerSignatoryID(int propertyOfficerSignatoryID) {
		this.propertyOfficerSignatoryID = propertyOfficerSignatoryID;
	}

	public void setApprovedBySignatoryID(int approvedBySignatoryID) {
		this.approvedBySignatoryID = approvedBySignatoryID;
	}

	public void setPropertyInspectorSignatoryID(int propertyInspectorSignatoryID) {
		this.propertyInspectorSignatoryID = propertyInspectorSignatoryID;
	}

	public void setWitnessToSignatoryID(int witnessToSignatoryID) {
		this.witnessToSignatoryID = witnessToSignatoryID;
	}

}
