package com.iappsam.servlet.forms;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

public class IIRUPFormUtil {
	public ArrayList<String> getdesignationName() {
		ArrayList<String> designationName = new ArrayList<String>();
		List<Employee> employeeList;
		try {
			employeeList = ManagerBin.getInstance().pManager.getAllEmployee();
			for (int i = 0; i < employeeList.size(); i++) {
				designationName.add(employeeList.get(i).getPerson().getName() + ":" + employeeList.get(i).getDesignation());
			}
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return designationName;
	}
}
