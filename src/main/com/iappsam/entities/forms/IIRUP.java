package com.iappsam.entities.forms;

import java.sql.Date;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;

// Inventory and Inspection of Report of Unserviceable Property
@Entity
@Indexed
public class IIRUP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Field(name = "iirup_date")
	@DateBridge(resolution = Resolution.DAY)
	@Column(name = "As_Of")
	private Date asOfDate;

	@ManyToOne
	@JoinColumn(name = "Accountable_Officer_ID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Employee accountableOfficer;

	@Field(name = "iirup_station")
	@Column(name = "Station")
	private String station;

	@ManyToOne
	@JoinColumn(name = "Requested_by_ID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Employee requestedBy;

	@ManyToOne
	@JoinColumn(name = "Approved_by_ID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Employee approvedBy;

	@ManyToOne
	@JoinColumn(name = "Inspector_ID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Employee inspector;

	@ManyToOne
	@JoinColumn(name = "Witness_ID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Employee witness;

	@IndexedEmbedded
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "iirup")
	private Set<IIRUPLine> lines = new HashSet<IIRUPLine>();

	public IIRUP() {
		super();
	}

	public IIRUP(Date asOfDate, Employee accountableOfficer, Employee requestedBy, Employee approvedBy, Employee inspector, Employee witness) {
		super();
		this.asOfDate = asOfDate;
		this.accountableOfficer = accountableOfficer;
		this.requestedBy = requestedBy;
		this.approvedBy = approvedBy;
		this.inspector = inspector;
		this.witness = witness;
	}

	public void addLine(Item item, int quantity, int yearsInService, float accumulatedDepreciation, Disposal disposal, String orNumber) {
		lines.add(new IIRUPLine(this, item, quantity, yearsInService, accumulatedDepreciation, disposal, orNumber));
	}

	public int getId() {
		return id;
	}

	public Date getAsOfDate() {
		return asOfDate;
	}

	public String getStation() {
		return station;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getAccountableOfficer() {
		return accountableOfficer;
	}

	public Employee getRequestedBy() {
		return requestedBy;
	}

	public Employee getApprovedBy() {
		return approvedBy;
	}

	public Employee getInspector() {
		return inspector;
	}

	public Employee getWitness() {
		return witness;
	}

	public void setAccountableOfficer(Employee accountableOfficer) {
		this.accountableOfficer = accountableOfficer;
	}

	public void setRequestedBy(Employee requestedBy) {
		this.requestedBy = requestedBy;
	}

	public void setApprovedBy(Employee approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setInspector(Employee inspector) {
		this.inspector = inspector;
	}

	public void setWitness(Employee witness) {
		this.witness = witness;
	}

	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Set<IIRUPLine> getLines() {
		return lines;
	}

	public void addLine(IIRUPLine line) {
		lines.add(line);
	}

	public void removeLine(IIRUPLine line) {
		lines.remove(line);
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
		IIRUP other = (IIRUP) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
