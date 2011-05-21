package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DivisionOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DivisionOffice_ID")
	private int id;

	@Column(name = "Division")
	private String divisionName;

	@Column(name = "Office")
	private String officeName;

	public DivisionOffice() {
		super();
	}

	public DivisionOffice(String divisionName, String officeName) {
		super();
		this.divisionName = divisionName;
		this.officeName = officeName;
	}

	public int getId() {
		return id;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Override
	public String toString() {
		return divisionName + ", " + officeName;
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
		DivisionOffice other = (DivisionOffice) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
