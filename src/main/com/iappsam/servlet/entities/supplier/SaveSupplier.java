package com.iappsam.servlet.entities.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;
import com.iappsam.util.Verifier;

/**
 * Servlet implementation class SaveSupplier
 */
@WebServlet("/entities/supplier/SaveSupplier.do")
public class SaveSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(".............inside savesupplier.java");
		
		
		String supplierName = (String) request.getParameter("supplierName");
		String address = (String) request.getParameter("supplierAddress");
		String tin = (String) request.getParameter("tin");

		String title = (String) request.getParameter("title");
		String name = (String) request.getParameter("name");
		String designation = (String) request.getParameter("designation2");
		String employeeNumber = (String) request.getParameter("employeeNumber");
		String mobileNumber = (String) request.getParameter("mobileNumber");
		String landline = (String) request.getParameter("landline");
		String emailad = (String) request.getParameter("emailad");

		RequestDispatcher view = request.getRequestDispatcher("AddSupplier.jsp");

		//if (Verifier.validEntry(supplierName) && Verifier.validEntry(address) && Verifier.validEntry(name) && Verifier.validEntry(designation)) {
			
			Person person = new Person(title, name);
			if(mobileNumber!=null)
				person.addContact(new Contact(mobileNumber, ContactType.MOBILE));
			if(landline!=null)
				person.addContact(new Contact(landline, ContactType.LANDLINE));
			if(emailad!=null)
				person.addContact(new Contact(emailad, ContactType.EMAIL));
			Employee employee = new Employee(designation, person);
			if(employeeNumber!=null)
				employee.setEmployeeNumber(employeeNumber);
			Supplier supplier = new Supplier(supplierName, address, tin, employee);
			try {
				Managers.sManager.addSupplier(supplier);
				request.setAttribute("supplierID", "" + supplier.getId());
				view = request.getRequestDispatcher("ViewSupplier.do");
				System.out.println("supplier was saved!!!");
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//
//			Person p = null;
//			Employee emp = null;
//			Supplier s = null;
//			p = new Person(title, name);
//			try {
//				ManagerBin.pManager.addPerson(p);
//				emp = new Employee(designation, employeeNumber, p);
//				ManagerBin.pManager.addEmployee(emp);
//				s = new Supplier(supplierName, supplierAddress, emp);
//				s.setTin(tin);
//				ManagerBin.sManager.addSupplier(s);
//				request.setAttribute("supplierID", "" + s.getId());
//				view = request.getRequestDispatcher("ViewSupplier.do");
//				System.out.println("supplier was saved!!!");
//			} catch (TransactionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (DuplicateEntryException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
//		} else {
//
//			System.out.println("supName: " + supplierName);
//			System.out.println("supAdd: " + address);
//			System.out.println("dsgntn: " + designation);
//			System.out.println("name: " + name);
//			System.out.println("item was not saved!!!!!!!!!!!");
//		}
		view.forward(request, response);
	}

}
