package com.iappsam.forms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;

@Indexed
@Entity
@Table(name = "Purchase_Request")
public class PR implements Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Purchase_Request_ID")
	private int id;

	@Field(name = "prNumber")
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

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Requested_by")
	private Employee requestedBy;

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Approved_by")
	private Employee approvedBy;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "purchaseRequest", cascade = CascadeType.ALL)
	private Set<PRLine> lines = new HashSet<PRLine>();

	public PR() {
		super();
	}

	public PR(DivisionOffice divisionOffice, String purpose, Employee requestedBy, Employee approvedBy) {
		super();

		this.divisionOffice = divisionOffice;
		this.purpose = purpose;
		this.requestedBy = requestedBy;
		this.approvedBy = approvedBy;
	}

	@Override
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

	public Set<PRLine> getLines() {
		return lines;
	}

	public void addLine(PRLine line) {
		line.setPurchaseRequest(this);
		lines.add(line);
	}

	public void addLine(int quantity, Item item) {
		addLine(new PRLine(this, quantity, item));
	}

	public void removeLine(int itemId) {

		PRLine delete = null;

		for (PRLine line : lines)
			if (line.getItem().getId() == itemId)
				delete = line;

		lines.remove(delete);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAlobsDate(String parameter) {
		try {
			alobsDate = Date.valueOf(parameter);
		} catch (Exception e) {
		}
	}

	public void setSaiDate(String parameter) {
		try {
			saiDate = Date.valueOf(parameter);
		} catch (Exception e) {
		}
	}

	public void setPrDate(String date) {
		try {
			prDate = Date.valueOf(date);
		} catch (Exception e) {
		}
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public Employee getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Employee requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Employee getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Employee approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public void setPrDate(Date prDate) {
		if (prNumber != null && !prNumber.isEmpty())
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
		result = prime * result + ((alobsDate == null) ? 0 : alobsDate.hashCode());
		result = prime * result + ((alobsNumber == null) ? 0 : alobsNumber.hashCode());
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((prDate == null) ? 0 : prDate.hashCode());
		result = prime * result + ((prNumber == null) ? 0 : prNumber.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((requestedBy == null) ? 0 : requestedBy.hashCode());
		result = prime * result + ((saiDate == null) ? 0 : saiDate.hashCode());
		result = prime * result + ((saiNumber == null) ? 0 : saiNumber.hashCode());
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
		PR other = (PR) obj;
		if (alobsDate == null) {
			if (other.alobsDate != null)
				return false;
		} else if (!alobsDate.equals(other.alobsDate))
			return false;
		if (alobsNumber == null) {
			if (other.alobsNumber != null)
				return false;
		} else if (!alobsNumber.equals(other.alobsNumber))
			return false;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (divisionOffice == null) {
			if (other.divisionOffice != null)
				return false;
		} else if (!divisionOffice.equals(other.divisionOffice))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (prDate == null) {
			if (other.prDate != null)
				return false;
		} else if (!prDate.equals(other.prDate))
			return false;
		if (prNumber == null) {
			if (other.prNumber != null)
				return false;
		} else if (!prNumber.equals(other.prNumber))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (requestedBy == null) {
			if (other.requestedBy != null)
				return false;
		} else if (!requestedBy.equals(other.requestedBy))
			return false;
		if (saiDate == null) {
			if (other.saiDate != null)
				return false;
		} else if (!saiDate.equals(other.saiDate))
			return false;
		if (saiNumber == null) {
			if (other.saiNumber != null)
				return false;
		} else if (!saiNumber.equals(other.saiNumber))
			return false;
		return true;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		for (PRLine line : lines)
			items.add(line.getItem());
		return items;
	}

	@Override
	public void addItem(Item item) {
		addLine(0, item);
	}

	@Override
	public boolean validate() {
		boolean validDivisionOffice = divisionOffice != null && divisionOffice.validate();
		boolean validPurpose = purpose != null && !purpose.isEmpty();
		boolean validRequestedBy = requestedBy != null && requestedBy.validate();
		boolean validApprovedBy = approvedBy != null && approvedBy.validate();
		boolean validLines = !lines.isEmpty();

		for (PRLine line : lines)
			validLines &= line.validate();

		return validDivisionOffice && validLines && validPurpose && validRequestedBy && validApprovedBy;
	}

	@Override
	public void removeItem(Item item) {
		PRLine remove = null;

		for (PRLine line : lines)
			if (line.getItem().equals(item))
				remove = line;

		lines.remove(remove);
	}
}