package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.iappsam.entities.Item;

@Entity
@Table(name = "IIRUP_Line")
public class IIRUPLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "IIRUP_ID")
	private IIRUP iirup;

	@OneToOne
	@JoinColumn(name = "Item_ID")
	private Item item;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Years_In_Service")
	private int yearsInService;

	@Column(name = "Accumulated_Depreciation")
	private float accumulatedDepreciation;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Disposal_ID")
	private Disposal disposal;

	@Column(name = "Appraisal")
	private String appraisal;

	@Column(name = "OR_Number")
	private String orNumber;

	public IIRUPLine() {
		super();
	}

	public IIRUPLine(IIRUP iirup, Item item, int quantity, int yearsInService, float accumulatedDepreciation, Disposal disposal, String orNumber) {
		super();
		this.iirup = iirup;
		this.item = item;
		this.quantity = quantity;
		this.yearsInService = yearsInService;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.disposal = disposal;
		this.orNumber = orNumber;
	}

	public int getId() {
		return id;
	}

	public IIRUP getIirup() {
		return iirup;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getYearsInService() {
		return yearsInService;
	}

	public float getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}

	public Disposal getDisposal() {
		return disposal;
	}

	public String getAppraisal() {
		return appraisal;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIirup(IIRUP iirup) {
		this.iirup = iirup;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setYearsInService(int yearsInService) {
		this.yearsInService = yearsInService;
	}

	public void setAccumulatedDepreciation(float accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public void setDisposal(Disposal disposal) {
		this.disposal = disposal;
	}

	public void setAppraisal(String appraisal) {
		this.appraisal = appraisal;
	}

	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((iirup == null) ? 0 : iirup.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IIRUPLine))
			return false;
		IIRUPLine other = (IIRUPLine) obj;
		if (id != other.id)
			return false;
		if (iirup == null) {
			if (other.iirup != null)
				return false;
		} else if (!iirup.equals(other.iirup))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
}
