package com.iappsam.forms;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;

@Entity
@Table(name = "APP")
public class APP implements Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "Year")
	private int year;

	@Column(name = "Plan_Control_Number")
	private String planControlNumber;

	@Column(name = "Date_Scheduled")
	private Date dateScheduled;

	@ManyToOne
	@JoinColumn(name = "DivisionOffice_ID")
	private DivisionOffice divisionOffice;

	@ManyToOne
	@JoinColumn(name = "Prepared_by")
	private Employee preparedBy;

	@ManyToOne
	@JoinColumn(name = "Recommended_by")
	private Employee recommendedBy;

	@OneToMany(mappedBy = "app", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<APPLine> lines = new HashSet<APPLine>();

	public APP() {
		super();
	}

	public APP(int year, DivisionOffice divisionOffice, Employee preparedBy, Employee recommendedBy) {
		super();
		this.year = year;
		this.divisionOffice = divisionOffice;
		this.preparedBy = preparedBy;
		this.recommendedBy = recommendedBy;
	}

	public Set<APPLine> getLines() {
		return lines;
	}

	public int getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public String getPlanControlNumber() {
		return planControlNumber;
	}

	public Date getDateScheduled() {
		return dateScheduled;
	}

	public void setId(int appID) {
		this.id = appID;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void addLine(APPLine line) {
		lines.add(line);
	}

	public void addLine(Item item, int quantityQ1, int quantityQ2, int quantityQ3, int quantityQ4) {
		addLine(new APPLine(this, item, quantityQ1, quantityQ2, quantityQ3, quantityQ4));
	}

	public void addLine(Item item, String q1, String q2, String q3, String q4) {
		try {
			int quantity1 = Integer.parseInt(q1);
			int quantity2 = Integer.parseInt(q2);
			int quantity3 = Integer.parseInt(q3);
			int quantity4 = Integer.parseInt(q4);

			addLine(item, quantity1, quantity2, quantity3, quantity4);
		} catch (NumberFormatException e) {
		}
	}

	public void removeLine(APPLine line) {
		line.setApp(null);
		lines.remove(line);
	}

	public DivisionOffice getDivisionOffice() {
		return divisionOffice;
	}

	public void setDivisionOffice(DivisionOffice divisionOffice) {
		this.divisionOffice = divisionOffice;
	}

	public Employee getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(Employee preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Employee getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(Employee recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public void setPlanControlNumber(String planControlNumber) {
		this.planControlNumber = planControlNumber;
	}

	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisionOffice == null) ? 0 : divisionOffice.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((preparedBy == null) ? 0 : preparedBy.hashCode());
		result = prime * result + ((recommendedBy == null) ? 0 : recommendedBy.hashCode());
		result = prime * result + year;
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
		APP other = (APP) obj;
		if (divisionOffice == null) {
			if (other.divisionOffice != null)
				return false;
		} else if (!divisionOffice.equals(other.divisionOffice))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (preparedBy == null) {
			if (other.preparedBy != null)
				return false;
		} else if (!preparedBy.equals(other.preparedBy))
			return false;
		if (recommendedBy == null) {
			if (other.recommendedBy != null)
				return false;
		} else if (!recommendedBy.equals(other.recommendedBy))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public boolean validate() {
		boolean validYear = year != 0;
		boolean validRecommendedBy = recommendedBy != null && recommendedBy.validate();
		boolean validDivisionOffice = divisionOffice != null && divisionOffice.validate();
		boolean validPreparedBy = preparedBy != null && preparedBy.validate();

		return validYear && validDivisionOffice && validPreparedBy && validRecommendedBy;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();

		for (APPLine line : lines)
			items.add(line.getItem());

		return items;
	}

	@Override
	public void addItem(Item item) {
		addLine(item, 0, 0, 0, 0);
	}

	@Override
	public void removeItem(Item item) {
		APPLine remove = null;

		for (APPLine line : lines)
			if (line.getItem().equals(item))
				remove = line;

		lines.remove(remove);
	}

	public void setYear(String year) {
		try {
			if (year != null)
				setYear(Integer.parseInt(year));
		} catch (Exception e) {
		}
	}

	public void setDateScheduled(String parameter) {
		try {
			setDateScheduled(Date.valueOf(parameter));
		} catch (Exception e) {
		}
	}

}