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

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;

@Entity
@Table(name = "Requisition_And_Issue_Slip")
public class RIS implements Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "RIS_Number")
	private String risNumber;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	@Column(name = "RC_Code")
	private String rcCode;

	@Column(name = "RIS_Date")
	private Date risDate;

	@Column(name = "SAI_Number")
	private String saiNumber;

	@Column(name = "SAI_Date")
	private Date saiDate;

	@Column(name = "Purpose")
	private String purpose;

	@ManyToOne
	@JoinColumn(name = "Requested_by")
	private Employee requestedBy;

	@Column(name = "Requested_by_date")
	private Date requestedByDate;

	@ManyToOne
	@JoinColumn(name = "Approved_by")
	private Employee approvedBy;

	@Column(name = "Approved_by_date")
	private Date approvedByDate;

	@ManyToOne
	@JoinColumn(name = "Issued_by")
	private Employee issuedBy;

	@Column(name = "Issued_by_date")
	private Date issuedByDate;

	@ManyToOne
	@JoinColumn(name = "Received_by")
	private Employee receivedBy;

	@Column(name = "Received_by_date")
	private Date receivedByDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ris")
	private Set<RISLine> lines = new HashSet<RISLine>();

	public RIS() {
		super();
	}

	public String getRisNumber() {
		return risNumber;
	}

	public void setRisNumber(String risNumber) {
		if (risNumber != null)
			this.risNumber = risNumber.trim();
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public String getRcCode() {
		return rcCode;
	}

	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}

	public Date getRisDate() {
		return risDate;
	}

	public void setRisDate(Date risDate) {
		this.risDate = risDate;
	}

	public void setRisDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setRisDate(d);
			} catch (Exception e) {
			}
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public void setSaiDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setSaiDate(d);
			} catch (Exception e) {
			}
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Employee getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Employee requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Date getRequestedByDate() {
		return requestedByDate;
	}

	public void setRequestedByDate(Date requestedByDate) {
		this.requestedByDate = requestedByDate;
	}

	public void setRequestedByDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setRequestedByDate(d);
			} catch (Exception e) {
			}
	}

	public Employee getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Employee approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedByDate() {
		return approvedByDate;
	}

	public void setApprovedByDate(Date approvedByDate) {
		this.approvedByDate = approvedByDate;
	}

	public void setApprovedByDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setApprovedByDate(d);
			} catch (Exception e) {
			}
	}

	public Employee getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(Employee issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getIssuedByDate() {
		return issuedByDate;
	}

	public void setIssuedByDate(Date issuedByDate) {
		this.issuedByDate = issuedByDate;
	}

	public void setIssuedByDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setIssuedByDate(d);
			} catch (Exception e) {
			}
	}

	public Employee getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(Employee receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getReceivedByDate() {
		return receivedByDate;
	}

	public void setReceivedByDate(Date receivedByDate) {
		this.receivedByDate = receivedByDate;
	}

	public void setReceivedByDate(String date) {
		if (date != null)
			try {
				Date d = Date.valueOf(date);
				setReceivedByDate(d);
			} catch (Exception e) {
			}
	}

	public void addLine(Item item, int quantityReq, int quantityIssued, String remarks) {
		lines.add(new RISLine(this, item, quantityReq, quantityIssued, remarks));
	}

	public void addLine(Item item, String quantityReq, String quantityIssued, String remarks) {
		int req = 0;
		int issued = 0;
		try {
			req = checkNum(quantityReq);
			issued = checkNum(quantityIssued);
		} catch (Exception e) {
		}
		addLine(item, req, issued, remarks);
	}
	
	private int checkNum(String value) {
		int num;
		try {
			num = Integer.parseInt(value);
			if (num < 0)
				return 0;
		} catch (Exception e) {
			return 0;
		}
		return num;
	}

	@Override
	public boolean validate() {
		boolean validDivisionOffice = divisionOffice != null && divisionOffice.validate();
		boolean validRISNumber = risNumber != null && !risNumber.isEmpty();
		boolean validRISDate = risDate != null;
		boolean validPurpose = purpose != null && !purpose.isEmpty();
		boolean validRequestedBy = requestedBy != null && requestedBy.validate();
		boolean validRequestedDate = requestedByDate != null;
		boolean validApprovedBy = approvedBy != null && approvedBy.validate();
		boolean validApprovedDate = approvedByDate != null;
		boolean validIssuedBy = issuedBy != null && issuedBy.validate();
		boolean validIssuedDate = issuedByDate != null;
		boolean validReceivedBy = receivedBy != null && receivedBy.validate();
		boolean validReceivedDate = receivedByDate != null;
		boolean validLines = !lines.isEmpty();

		for (RISLine line : lines)
			validLines &= line.validate();

		return validDivisionOffice && validRISNumber && validRISDate && validPurpose && validRequestedBy && validRequestedDate && validApprovedBy
				&& validApprovedDate && validIssuedBy && validIssuedDate && validReceivedBy && validReceivedDate && validLines;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();

		for (RISLine line : lines)
			items.add(line.getItem());

		return items;
	}

	@Override
	public void addItem(Item item) {
		addLine(item, 0, 0, "");
	}

	@Override
	public void removeItem(Item item) {
		RISLine toRemove = null;
		for (RISLine line : lines)
			if (line.getItem().equals(item))
				toRemove = line;
		lines.remove(toRemove);
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	public Set<RISLine> getLines() {
		return lines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((approvedByDate == null) ? 0 : approvedByDate.hashCode());
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + ((issuedBy == null) ? 0 : issuedBy.hashCode());
		result = prime * result + ((issuedByDate == null) ? 0 : issuedByDate.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((rcCode == null) ? 0 : rcCode.hashCode());
		result = prime * result + ((receivedBy == null) ? 0 : receivedBy.hashCode());
		result = prime * result + ((receivedByDate == null) ? 0 : receivedByDate.hashCode());
		result = prime * result + ((requestedBy == null) ? 0 : requestedBy.hashCode());
		result = prime * result + ((requestedByDate == null) ? 0 : requestedByDate.hashCode());
		result = prime * result + ((risDate == null) ? 0 : risDate.hashCode());
		result = prime * result + ((risNumber == null) ? 0 : risNumber.hashCode());
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
		RIS other = (RIS) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (approvedByDate == null) {
			if (other.approvedByDate != null)
				return false;
		} else if (!approvedByDate.equals(other.approvedByDate))
			return false;
		if (divisionOffice == null) {
			if (other.divisionOffice != null)
				return false;
		} else if (!divisionOffice.equals(other.divisionOffice))
			return false;
		if (issuedBy == null) {
			if (other.issuedBy != null)
				return false;
		} else if (!issuedBy.equals(other.issuedBy))
			return false;
		if (issuedByDate == null) {
			if (other.issuedByDate != null)
				return false;
		} else if (!issuedByDate.equals(other.issuedByDate))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (rcCode == null) {
			if (other.rcCode != null)
				return false;
		} else if (!rcCode.equals(other.rcCode))
			return false;
		if (receivedBy == null) {
			if (other.receivedBy != null)
				return false;
		} else if (!receivedBy.equals(other.receivedBy))
			return false;
		if (receivedByDate == null) {
			if (other.receivedByDate != null)
				return false;
		} else if (!receivedByDate.equals(other.receivedByDate))
			return false;
		if (requestedBy == null) {
			if (other.requestedBy != null)
				return false;
		} else if (!requestedBy.equals(other.requestedBy))
			return false;
		if (requestedByDate == null) {
			if (other.requestedByDate != null)
				return false;
		} else if (!requestedByDate.equals(other.requestedByDate))
			return false;
		if (risDate == null) {
			if (other.risDate != null)
				return false;
		} else if (!risDate.equals(other.risDate))
			return false;
		if (risNumber == null) {
			if (other.risNumber != null)
				return false;
		} else if (!risNumber.equals(other.risNumber))
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

}
