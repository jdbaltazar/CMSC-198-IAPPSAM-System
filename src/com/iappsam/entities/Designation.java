package com.iappsam.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Designation {
	private ArrayList<String> designations = new ArrayList<String>();
	private ArrayList<Date> designationDue = new ArrayList<Date>();
	private int employeeID;

	public Designation(int employeeID) {
		this.employeeID = employeeID;
	}

	public void addDesignation(String designation, Date dateApplied) {
		designations.add(designation);
		designationDue.add(dateApplied);
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getDesignation(Date dateOfDesignation) {
		int i = 0;
		while (!designationDue.isEmpty()) {
			if (i < designationDue.size()
					&& (dateOfDesignation.after(designationDue.get(i)) && dateOfDesignation
							.before(designationDue.get(i + 1))))
				return designations.get(i);
		}

		return designations.get(designations.size() - 1);

	}

}
