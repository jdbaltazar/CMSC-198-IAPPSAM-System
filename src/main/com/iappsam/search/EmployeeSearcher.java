package com.iappsam.search;

import com.iappsam.Employee;

public class EmployeeSearcher extends AbstractSearcher<Employee> {

	public EmployeeSearcher() {
		super(Employee.class, "person.name", "designation", "divisionOffice.division", "divisionOffice.office");
	}
}
