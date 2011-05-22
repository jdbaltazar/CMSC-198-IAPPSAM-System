package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iappsam.entities.Item;

@Entity
@Table(name = "APP_Line")
public class AnnualProcurementPlanLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7955015943267730159L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APP_Line_ID")
	private int id;

	@Column(name = "Quantity_Quarter_1")
	private int quantityQuarter1;

	@Column(name = "Quantity_Quarter_2")
	private int quantityQuarter2;

	@Column(name = "Quantity_Quarter_3")
	private int quantityQuarter3;

	@Column(name = "Quantity_Quarter_4")
	private int quantityQuarter4;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "APP_ID")
	private AnnualProcurementPlan app;

	@OneToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	public AnnualProcurementPlanLine() {
		super();
	}

	public AnnualProcurementPlanLine(Item item, int quantityQ1, int quantityQ2, int quantityQ3, int quantityQ4) {
		super();
		this.item = item;
		this.quantityQuarter1 = quantityQ1;
		this.quantityQuarter2 = quantityQ2;
		this.quantityQuarter3 = quantityQ3;
		this.quantityQuarter4 = quantityQ4;
	}

	public int getQuantityQuarter1() {
		return quantityQuarter1;
	}

	public int getQuantityQuarter2() {
		return quantityQuarter2;
	}

	public int getQuantityQuarter3() {
		return quantityQuarter3;
	}

	public int getQuantityQuarter4() {
		return quantityQuarter4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AnnualProcurementPlan getApp() {
		return app;
	}

	public void setApp(AnnualProcurementPlan app) {
		this.app = app;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setQuantityQuarter1(int quantityQuarter1) {
		this.quantityQuarter1 = quantityQuarter1;
	}

	public void setQuantityQuarter2(int quantityQuarter2) {
		this.quantityQuarter2 = quantityQuarter2;
	}

	public void setQuantityQuarter3(int quantityQuarter3) {
		this.quantityQuarter3 = quantityQuarter3;
	}

	public void setQuantityQuarter4(int quantityQuarter4) {
		this.quantityQuarter4 = quantityQuarter4;
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
		AnnualProcurementPlanLine other = (AnnualProcurementPlanLine) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
