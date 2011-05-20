package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iappsam.entities.Item;

@Entity
@Table(name = "APP_Line")
public class AnnualProcurementPlanLine {

	@Embeddable
	public static class Id implements Serializable {
		private static final long serialVersionUID = 3314610323734035453L;
		private int appId; // @Column(name = "APP_ID")
		private String itemDescription; // @Column(name = "Item_Description")

		public int getAppId() {
			return appId;
		}

		public String getItemDescription() {
			return itemDescription;
		}
	}

	@EmbeddedId
	private Id id;

	@Column(name = "Quantity_Quarter_1")
	private int quantityQuarter1;

	@Column(name = "Quantity_Quarter_2")
	private int quantityQuarter2;

	@Column(name = "Quantity_Quarter_3")
	private int quantityQuarter3;

	@Column(name = "Quantity_Quarter_4")
	private int quantityQuarter4;

	@ManyToOne
	@MapsId("appId")
	@JoinColumn(name = "APP_ID")
	private AnnualProcurementPlan app;

	@OneToOne
	@MapsId("itemDescription")
	@JoinColumn(name = "Item_Description")
	private Item item;

	public AnnualProcurementPlanLine() {
		super();
	}

	public AnnualProcurementPlanLine(AnnualProcurementPlan app, Item item, int quantityQ1, int quantityQ2, int quantityQ3, int quantityQ4) {
		super();
		this.app = app;
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

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
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

}