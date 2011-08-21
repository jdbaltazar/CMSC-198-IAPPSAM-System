package com.iappsam.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iappsam.Item;
import com.iappsam.Validatable;

@Entity
@Table(name = "RIS_Line")
public class RISLine implements Serializable, Validatable {

	private static final long serialVersionUID = 7888860671840670652L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "RIS_ID")
	private RIS ris;

	@Column(name = "Quantity_Requested")
	private int quantityRequested;

	@Column(name = "Quantity_Issued")
	private int quantityIssued;

	@Column(name = "Remarks")
	private String remarks;

	public RISLine() {
		super();
	}

	public RISLine(RIS ris, Item item, int quantityRequested, int quantityIssued, String remarks) {
		super();
		this.ris = ris;
		this.item = item;
		this.quantityRequested = quantityRequested;
		this.quantityIssued = quantityIssued;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public RIS getRis() {
		return ris;
	}

	public void setRis(RIS ris) {
		this.ris = ris;
	}

	public int getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public int getQuantityIssued() {
		return quantityIssued;
	}

	public void setQuantityIssued(int quantityIssued) {
		this.quantityIssued = quantityIssued;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantityIssued;
		result = prime * result + quantityRequested;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
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
		RISLine other = (RISLine) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantityIssued != other.quantityIssued)
			return false;
		if (quantityRequested != other.quantityRequested)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		boolean vItem = item != null && item.validate();
		if (quantityRequested < 0)
			quantityRequested = 0;
		if (quantityIssued < 0)
			quantityIssued = 0;
		boolean vRequested = quantityRequested >= 0;
		boolean vIssued = quantityIssued >= 0;
		boolean match = !(quantityRequested == 0 && quantityIssued == 0);

		return vItem && vRequested && vIssued && match;
	}
}
