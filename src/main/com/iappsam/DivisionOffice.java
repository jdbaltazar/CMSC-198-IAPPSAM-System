package com.iappsam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
public class DivisionOffice implements Validatable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Field(name = "division")
	@Column(name = "Division")
	private String divisionName;

	@Field(name = "office")
	@Column(name = "Office")
	private String officeName;

	public DivisionOffice() {
		super();
	}

	public DivisionOffice(String divisionName, String officeName) {
		super();
		setDivisionName(divisionName);
		setOfficeName(officeName);
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
		if (divisionName != null)
			this.divisionName = divisionName.trim();
	}

	public void setOfficeName(String officeName) {
		if (officeName != null)
			this.officeName = officeName.trim();
	}

	@Override
	public String toString() {
		return divisionName + ", " + officeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisionName == null) ? 0 : divisionName.hashCode());
		result = prime * result + ((officeName == null) ? 0 : officeName.hashCode());
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
		if (divisionName == null) {
			if (other.divisionName != null)
				return false;
		} else if (!divisionName.equals(other.divisionName))
			return false;
		if (officeName == null) {
			if (other.officeName != null)
				return false;
		} else if (!officeName.equals(other.officeName))
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		return divisionName != null && !divisionName.isEmpty();
	}
}
