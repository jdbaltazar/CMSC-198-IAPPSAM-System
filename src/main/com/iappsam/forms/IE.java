package com.iappsam.forms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ie")
	private Set<IELine> lines = new HashSet<IELine>();

	public IE() {
		super();
	}

	public IE(DivisionOffice divisionOffice, Building building) {
		super();
		this.divisionOffice = divisionOffice;
		this.building = building;
	}

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

	public void addLine(Item item, int quantity, Employee employee, String howAcquired) {
		lines.add(new IELine(this, item, quantity, employee, howAcquired));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
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
		return true;
	}

	@Override
	public boolean validate() {
		boolean validDivisionOffice = divisionOffice != null && divisionOffice.validate();
		boolean validBuilding = building != null && building.validate();
		boolean validLines = !lines.isEmpty();

		for (IELine line : lines)
			validLines &= line.validate();

		return validDivisionOffice && validBuilding && validLines;
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
		addLine(item, 0, null, null);
	}

	@Override
	public void removeItem(Item item) {
		IELine remove = null;

		for (IELine line : lines)
			if (line.getItem().equals(item))
				remove = line;

		lines.remove(remove);
	}
}
