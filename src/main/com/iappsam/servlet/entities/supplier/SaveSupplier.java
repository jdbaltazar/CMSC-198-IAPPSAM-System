package com.iappsam.servlet.entities.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Contact;
import com.iappsam.ContactType;
import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Supplier;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(".............inside savesupplier.java");
		
		
		String supplierName = request.getParameter("supplierName");
		String address = request.getParameter("supplierAddress");
		String tin = request.getParameter("tin");

		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation2");
		String employeeNumber = request.getParameter("employeeNumber");
		String mobileNumber = request.getParameter("mobileNumber");
		String landline = request.getParameter("landline");
		String emailad = request.getParameter("emailad");

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
				Managers.INSTANCE.getSupplierManager().addSupplier(supplier);
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
