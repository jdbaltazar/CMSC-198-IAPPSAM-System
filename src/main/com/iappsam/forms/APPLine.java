package com.iappsam.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iappsam.Item;
import com.iappsam.Validatable;
import com.iappsam.util.DecimalRounder;

@Entity
@Table(name = "APP_Line")
public class APPLine implements Validatable {

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

	@ManyToOne
	@JoinColumn(name = "APP_ID")
	private APP app;

	@OneToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	public APPLine() {
		super();
	}

	public APPLine(APP app, Item item, int quantityQ1, int quantityQ2, int quantityQ3, int quantityQ4) {
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

	public float getAmount1() {
		return (float) DecimalRounder.roundOff((quantityQuarter1 * item.getPrice()), 2);
	}

	public float getAmount2() {
		return (float) DecimalRounder.roundOff((quantityQuarter2 * item.getPrice()), 2);
	}

	public float getAmount3() {
		return (float) DecimalRounder.roundOff((quantityQuarter3 * item.getPrice()), 2);
	}

	public float getAmount4() {
		return (float) DecimalRounder.roundOff((quantityQuarter4 * item.getPrice()), 2);
	}

	public float getAmount() {
		return DecimalRounder.roundOff(getAmount1() + getAmount2() + getAmount3() + getAmount4(),2);
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

	public int getQuantity() {
		return quantityQuarter1 + quantityQuarter2 + quantityQuarter3 + quantityQuarter4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public APP getApp() {
		return app;
	}

	public void setApp(APP app) {
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
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantityQuarter1;
		result = prime * result + quantityQuarter2;
		result = prime * result + quantityQuarter3;
		result = prime * result + quantityQuarter4;
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
		APPLine other = (APPLine) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantityQuarter1 != other.quantityQuarter1)
			return false;
		if (quantityQuarter2 != other.quantityQuarter2)
			return false;
		if (quantityQuarter3 != other.quantityQuarter3)
			return false;
		if (quantityQuarter4 != other.quantityQuarter4)
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		boolean validApp = app != null;
		boolean validItem = item != null && item.validate();
		boolean validQ1 = quantityQuarter1 >= 0;
		boolean validQ2 = quantityQuarter2 >= 0;
		boolean validQ3 = quantityQuarter3 >= 0;
		boolean validQ4 = quantityQuarter4 >= 0;
		return validApp && validItem && validQ1 && validQ2 && validQ3 && validQ4;
	}

	public Object[] toArrayObject() {
		String description = item.getDescription();
		String stockNumber = item.getStockNumber();
		float price = item.getPrice();

		int quantity1 = getQuantityQuarter1();
		int quantity2 = getQuantityQuarter2();
		int quantity3 = getQuantityQuarter3();
		int quantity4 = getQuantityQuarter4();
		int quantity = getQuantity();

		float amount1 = getAmount1();
		float amount2 = getAmount2();
		float amount3 = getAmount3();
		float amount4 = getAmount4();
		float amountTotal = getAmount();

		return new Object[] { stockNumber, description, item.getUnit().getName(), quantity + "", price + "", quantity1 + "", amount1 + "",
				quantity2 + "", amount2 + "", quantity3 + "", amount3 + "", quantity4 + "", amount4 + "", amountTotal + "" };
	}
}
