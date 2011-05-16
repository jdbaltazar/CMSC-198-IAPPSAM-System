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
	@Column(name = "Signatory_ID")
	private int propertyOfficerSignatoryID;

	@Column(name = "Signator_ID1")
	private int approvedBySignatoryID;

	@Column(name = "Signatory_ID2")
	private int propertyInspectorSignatoryID;

	@Column(name = "Signatory_ID3")
	private int witnessToSignatoryID;

	private Date wmrDate;

	private void init(int wmrID, int divisionOfficeID, int propertyOfficerSignatoryID, int approvedBySignatoryID, int propertyInspectorySignatoryID, int witnessToSignatoryID, Date wmrDate, String placeOfStorage) {
		this.wmrDate = wmrDate;
		this.divisionOfficeID = divisionOfficeID;
		this.propertyInspectorSignatoryID = propertyInspectorySignatoryID;
		this.propertyOfficerSignatoryID = propertyOfficerSignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
		this.witnessToSignatoryID = witnessToSignatoryID;
		this.wmrID = wmrID;
		this.placeOfStorage = placeOfStorage;
	}

	public WasteMaterialsReport(int wmrID, int divisionOfficeID, int propertyOfficerSignatoryID, int approvedBySignatoryID, int propertyInspectorySignatoryID, int witnessToSignatoryID, Date wmrDate) {
		init(wmrID, divisionOfficeID, propertyOfficerSignatoryID, propertyInspectorySignatoryID, approvedBySignatoryID, witnessToSignatoryID, wmrDate, "");
	}

	public WasteMaterialsReport(int wmrID, int divisionOfficeID, int propertyOfficerSignatoryID, int approvedBySignatoryID, int propertyInspectorySignatoryID, int witnessToSignatoryID, Date wmrDate, String placeOfStorage) {
		init(wmrID, divisionOfficeID, propertyOfficerSignatoryID, propertyInspectorySignatoryID, approvedBySignatoryID, witnessToSignatoryID, wmrDate, placeOfStorage);
	}

	public String getPlaceOfStorage() {
		return placeOfStorage;
	}

	public void setPlaceOfStorage(String placeOfStorage) {
		this.placeOfStorage = placeOfStorage;
	}

	public int getWmrID() {
		return wmrID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int[] getSignatoryID() {
		int[] signatories = { propertyOfficerSignatoryID, propertyInspectorSignatoryID, approvedBySignatoryID, witnessToSignatoryID };
		return signatories;
	}

	public Date getWmrDate() {
		return wmrDate;
	}
}
