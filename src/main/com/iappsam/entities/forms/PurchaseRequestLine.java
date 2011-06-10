package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iappsam.entities.Item;

@Entity
@Table(name = "PR_Line")
public class PurchaseRequestLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PR_Line_ID")
	private int id;

	@Column(name = "Quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	@Column(name = "Estimated_Unit_Cost")
	private long estimatedUnitCost;

	@ManyToOne
	@JoinColumn(name = "Purchase_Request_ID")
	private PurchaseRequest purchaseRequest;

	public PurchaseRequestLine() {
		super();
	}

	public PurchaseRequestLine(PurchaseRequest pr, int quantity, Item item) {
		super();
		this.quantity = quantity;
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItemDescription() {
		return item.getDescription();
	}

	public long getEstimatedUnitCost() {
		return estimatedUnitCost;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}

	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
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

	public void setEstimatedUnitCost(long estimatedUnitCost) {
		this.estimatedUnitCost = estimatedUnitCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((purchaseRequest == null) ? 0 : purchaseRequest.hashCode());
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
		PurchaseRequestLine other = (PurchaseRequestLine) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (purchaseRequest == null) {
			if (other.purchaseRequest != null)
				return false;
		} else if (!purchaseRequest.equals(other.purchaseRequest))
			return false;
		return true;
	}
}
