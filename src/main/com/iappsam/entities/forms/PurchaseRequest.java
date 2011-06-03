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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Signatory;

@Entity
@Table(name = "Purchase_Request")
public class PurchaseRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Purchase_Request_ID")
	private int id;

	@Column(name = "PR_Number")
	private String prNumber;

	@Column(name = "PR_Date")
	private Date prDate;

	@Column(name = "SAI_Number")
	private String saiNumber;

	@Column(name = "SAI_Date")
	private Date saiDate;

	@Column(name = "ALOBS_Number")
	private String alobsNumber;

	@Column(name = "ALOBS_DATE")
	private Date alobsDate;

	@Column(name = "Purpose")
	private String purpose;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	@OneToOne
	@JoinColumn(name = "Signatory_ID")
	private Signatory requestedBy;

	@OneToOne
	@JoinColumn(name = "Signatory_ID1")
	private Signatory approvedBy;

	@OneToMany(mappedBy = "purchaseRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<PurchaseRequestLine> lines = new HashSet<PurchaseRequestLine>();

	public PurchaseRequest() {
		super();
	}

	public PurchaseRequest(DivisionOffice divisionOffice, String prNumber, Date prDate, String saiNumber, Date saiDate, String alobsNumber, Date alobsDate, String purpose, Signatory requestedBy,
			Signatory approvedBy) {
		super();

		this.divisionOffice = divisionOffice;
		this.prNumber = prNumber;
		this.prDate = prDate;
		this.saiNumber = saiNumber;
		this.saiDate = saiDate;
		this.alobsNumber = alobsNumber;
		this.alobsDate = alobsDate;
		this.purpose = purpose;
		this.requestedBy = requestedBy;
		this.approvedBy = approvedBy;
	}

	public PurchaseRequest(DivisionOffice divisionOffice, String purpose, Signatory requestedBy, Signatory approvedBy) {
		super();
		this.divisionOffice = divisionOffice;
		this.purpose = purpose;
		this.requestedBy = requestedBy;
		this.approvedBy = approvedBy;
	}

	public int getId() {
		return id;
	}

	public String getPrNumber() {
		return prNumber;
	}

	public Date getPrDate() {
		return prDate;
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public String getAlobsNumber() {
		return alobsNumber;
	}

	public Date getAlobsDate() {
		return alobsDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public Set<PurchaseRequestLine> getLines() {
		return lines;
	}

	public void addLine(PurchaseRequestLine line) {
		line.setPurchaseRequest(this);
		lines.add(line);
	}

	public void setId(int id) {
		this.id = id;
	}

	public Signatory getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Signatory requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Signatory getApprovedBy() {
		return approvedBy;
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public void setApprovedBy(Signatory approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public void setAlobsNumber(String alobsNumber) {
		this.alobsNumber = alobsNumber;
	}

	public void setAlobsDate(Date alobsDate) {
		this.alobsDate = alobsDate;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PurchaseRequest other = (PurchaseRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
