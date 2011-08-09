package com.iappsam.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.iappsam.Validatable;

@Entity
public class Disposal implements Validatable {

	public static final String DESTROYED = "DESTROYED";
	public static final String SOLD_AT_PRIVATE_SALE = "SOLD_AT_PRIVATE_SALE";
	public static final String SOLD_AT_PUBLIC_AUCTION = "SOLD_AT_PUBLIC_AUCTION";
	public static final String TRANSFERRED_WITHOUT_COST = "TRANSFERRED_WITHOUT_COST";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "name")
	private String name;

	public Disposal() {
		super();
	}

	public Disposal(String name) {
		setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name.trim();
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
		Disposal other = (Disposal) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		return name != null && !name.equals("");
	}
}
