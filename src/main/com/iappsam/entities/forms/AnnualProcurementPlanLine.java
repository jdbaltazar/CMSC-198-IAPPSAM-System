package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iappsam.entities.Item;

@Entity
@Table(name = "APP_Line")
public class AnnualProcurementPlanLine {

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Quantity_Quarter_1")
	private int quantityQuarter1;

	@Column(name = "Quantity_Quarter_2")
	private int quantityQuarter2;

	@Column(name = "Quantity_Quarter_3")
	private int quantityQuarter3;

	@Column(name = "Quantity_Quarter_4")
	private int quantityQuarter4;

	@Id
	@Column(name = "APP_ID")
	private int appID;

	@OneToOne
	@MapsId("Item_Description")
	@JoinColumn(name = "Item_Description")
	private Item item;

	public AnnualProcurementPlanLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnualProcurementPlanLine(String itemDescription, int quantityQuarter1, int quantityQuarter2, int quantityQuarter3, int quantityQuarter4,
			int appID) {
		super();
		this.itemDescription = itemDescription;
		this.quantityQuarter1 = quantityQuarter1;
		this.quantityQuarter2 = quantityQuarter2;
		this.quantityQuarter3 = quantityQuarter3;
		this.quantityQuarter4 = quantityQuarter4;
		this.appID = appID;
	}

	public int getItemID() {
		return itemID;
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

	public int getAppID() {
		return appID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
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

	public void setAppID(int appID) {
		this.appID = appID;
	}

}