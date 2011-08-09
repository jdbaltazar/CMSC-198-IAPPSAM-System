package com.iappsam.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iappsam.Item;
import com.iappsam.Validatable;

@Entity
@Table(name = "PO_Line")
public class POLine implements Serializable, Validatable {
	private static final long serialVersionUID = 7312439919136440157L;

	@Id
	@Column(name = "Id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "PO_ID")
	private PO po;

	public POLine() {
		super();
	}

	public POLine(PO po, Item item) {
		super();
		this.po = po;
		this.item = item;
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

	public PO getPo() {
		return po;
	}

	public void setPo(PO po) {
		this.po = po;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((po == null) ? 0 : po.hashCode());
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
		POLine other = (POLine) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (po == null) {
			if (other.po != null)
				return false;
		} else if (!po.equals(other.po))
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		return item != null && item.validate() && po != null;
	}
}
