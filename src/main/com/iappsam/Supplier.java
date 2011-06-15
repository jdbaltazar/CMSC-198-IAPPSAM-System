package com.iappsam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Supplier implements Validatable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Supplier_ID")
	private int id;

	@Column(name = "Name")
	private String supplierName;

	@Column(name = "Address")
	private String address;

	@Column(name = "TIN")
	private String tin;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Contact_Person_ID")
	private Employee contactPerson;

	public Supplier() {
		super();
	}

	public Supplier(String supplierName, String address, String tin, Employee employee) {
		super();
		setSupplierName(supplierName);
		setAddress(address);
		setTin(tin);
		setContactPerson(employee);
	}

	public Supplier(String supplierName, String address, Employee employee) {
		super();
		setSupplierName(supplierName);
		setAddress(address);
		setContactPerson(employee);
	}

	public Employee getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(Employee contactPerson) {
		if (this.contactPerson != null)
			this.contactPerson.removeSupplier(this);
		this.contactPerson = contactPerson;
		this.contactPerson.addSupplier(this);
	}

	public int getId() {
		return id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getAddress() {
		return address;
	}

	public String getTin() {
		return tin;
	}

	public void setId(int supplierID) {
		this.id = supplierID;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Supplier))
			return false;
		Supplier other = (Supplier) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		boolean validAddress = address != null && !address.isEmpty();
		boolean validSupplierName = supplierName != null && !supplierName.isEmpty();
		boolean validContactPerson = contactPerson != null && contactPerson.validate();
		return validSupplierName && validAddress && validContactPerson;
	}
}
