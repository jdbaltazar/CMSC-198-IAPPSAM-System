package com.iappsam.forms;

import java.util.ArrayList;
import java.util.Date;
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

import com.iappsam.Building;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;

@Entity
@Table(name = "Inventory_of_Equipment")
public class IE implements Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	@ManyToOne
	@JoinColumn(name = "Building_ID")
	private Building building;

	@ManyToOne
	@JoinColumn(name = "Preparedby")
	private Employee preparedBy;

	@ManyToOne
	@JoinColumn(name = "CommitteeMember1")
	private Employee committeeMember1;

	@ManyToOne
	@JoinColumn(name = "CommitteeMember2")
	private Employee committeeMember2;

	@ManyToOne
	@JoinColumn(name = "CounterCheckedBy")
	private Employee counterCheckedBy;

	@ManyToOne
	@JoinColumn(name = "NotedBy")
	private Employee notedBy;

	@ManyToOne
	@JoinColumn(name = "COARepresentative")
	private Employee coaRepresentative;

	@Column(name = "DatePrepared")
	private Date datePrepared;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ie", cascade = CascadeType.ALL)
	private Set<IELine> lines = new HashSet<IELine>();

	public IE() {
		super();
	}

	public IE(DivisionOffice divisionOffice, Building building, Employee preparedBy, Employee committeeMember1, Employee committeeMember2,
			Employee counterCheckedBy, Employee notedBy, Employee coaRepresentative) {
		super();
		this.divisionOffice = divisionOffice;
		this.building = building;
		this.preparedBy = preparedBy;
		this.committeeMember1 = committeeMember1;
		this.committeeMember2 = committeeMember2;
		this.counterCheckedBy = counterCheckedBy;
		this.notedBy = notedBy;
		this.coaRepresentative = coaRepresentative;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Employee getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(Employee preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Employee getCommitteeMember1() {
		return committeeMember1;
	}

	public void setCommitteeMember1(Employee committeeMember1) {
		this.committeeMember1 = committeeMember1;
	}

	public Employee getCommitteeMember2() {
		return committeeMember2;
	}

	public void setCommitteeMember2(Employee committeeMember2) {
		this.committeeMember2 = committeeMember2;
	}

	public Employee getCounterCheckedBy() {
		return counterCheckedBy;
	}

	public void setCounterCheckedBy(Employee counterCheckedBy) {
		this.counterCheckedBy = counterCheckedBy;
	}

	public Employee getNotedBy() {
		return notedBy;
	}

	public void setNotedBy(Employee notedBy) {
		this.notedBy = notedBy;
	}

	public Employee getCoaRepresentative() {
		return coaRepresentative;
	}

	public void setCoaRepresentative(Employee coaRepresentative) {
		this.coaRepresentative = coaRepresentative;
	}

	public Date getDatePrepared() {
		return datePrepared;
	}

	public void setDatePrepared(Date datePrepared) {
		this.datePrepared = datePrepared;
	}

	public void addLine(Item item, String quantity, Employee employee, ModeOfProcurement howAcquired, String remarks) {
		lines.add(new IELine(this, item, quantity, employee, howAcquired, remarks));
	}

	public Set<IELine> getLines() {
		return lines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((coaRepresentative == null) ? 0 : coaRepresentative.hashCode());
		result = prime * result + ((committeeMember1 == null) ? 0 : committeeMember1.hashCode());
		result = prime * result + ((committeeMember2 == null) ? 0 : committeeMember2.hashCode());
		result = prime * result + ((counterCheckedBy == null) ? 0 : counterCheckedBy.hashCode());
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + id;
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((notedBy == null) ? 0 : notedBy.hashCode());
		result = prime * result + ((preparedBy == null) ? 0 : preparedBy.hashCode());
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
		IE other = (IE) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (coaRepresentative == null) {
			if (other.coaRepresentative != null)
				return false;
		} else if (!coaRepresentative.equals(other.coaRepresentative))
			return false;
		if (committeeMember1 == null) {
			if (other.committeeMember1 != null)
				return false;
		} else if (!committeeMember1.equals(other.committeeMember1))
			return false;
		if (committeeMember2 == null) {
			if (other.committeeMember2 != null)
				return false;
		} else if (!committeeMember2.equals(other.committeeMember2))
			return false;
		if (counterCheckedBy == null) {
			if (other.counterCheckedBy != null)
				return false;
		} else if (!counterCheckedBy.equals(other.counterCheckedBy))
			return false;
		if (divisionOffice == null) {
			if (other.divisionOffice != null)
				return false;
		} else if (!divisionOffice.equals(other.divisionOffice))
			return false;
		if (id != other.id)
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (notedBy == null) {
			if (other.notedBy != null)
				return false;
		} else if (!notedBy.equals(other.notedBy))
			return false;
		if (preparedBy == null) {
			if (other.preparedBy != null)
				return false;
		} else if (!preparedBy.equals(other.preparedBy))
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		boolean validDivisionOffice = divisionOffice != null && divisionOffice.validate();
		boolean validBuilding = building != null && building.validate();
		boolean validPreparedBy = preparedBy != null && preparedBy.validate();
		boolean validCommitteeMember1 = committeeMember1 != null && committeeMember1.validate();
		boolean validCommitteeMember2 = committeeMember2 != null && committeeMember2.validate();
		boolean validCounterCheckBy = counterCheckedBy != null && counterCheckedBy.validate();
		boolean validNotedBy = notedBy != null && notedBy.validate();
		boolean validCoaRep = coaRepresentative != null && coaRepresentative.validate();

		boolean validLines = !lines.isEmpty();

		for (IELine line : lines)
			validLines &= line.validate();

		return validDivisionOffice && validBuilding && validPreparedBy && validCommitteeMember1 && validCommitteeMember2 && validCounterCheckBy
				&& validNotedBy && validCoaRep && validLines;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();

		for (IELine line : lines)
			items.add(line.getItem());

		return items;
	}

	@Override
	public void addItem(Item item) {
		addLine(item, null, null, null, null);
	}

	@Override
	public void removeItem(Item item) {
		IELine remove = null;

		for (IELine line : lines)
			if (line.getItem().equals(item))
				remove = line;

		lines.remove(remove);
	}

	public void setDatePrepared(String date) {
		try {
			setDatePrepared(java.sql.Date.valueOf(date));
		} catch (Exception e) {
		}
	}
}
