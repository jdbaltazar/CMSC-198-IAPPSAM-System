package com.iappsam.servlet.forms.iirup;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

public class IIRUPFormUtil {
	public ArrayList<String> getNames() {
		List<Employee> employeeList;
		ArrayList<String> names = new ArrayList<String>();
		try {
			employeeList = ManagerBin.getInstance().pManager.getAllEmployee();
			for (int i = 0; i < employeeList.size(); i++) {
				if (!names.contains(employeeList.get(i).getPerson().getName()))
					names.add(employeeList.get(i).getPerson().getName());
			}
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return names;
	}

	public ArrayList<String> getDesignationByName(String name) {
		ArrayList<String> designations = new ArrayList<String>();
		List<Employee> employeeWithNameList;
		try {
			employeeWithNameList = ManagerBin.getInstance().pManager.getEmployeeByPerson(ManagerBin.getInstance().pManager.getPerson(name).getId());
			for (int i = 0; i < employeeWithNameList.size(); i++) {
				designations.add(name+" : "+employeeWithNameList.get(i).getDesignation());
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return designations;
	}

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
