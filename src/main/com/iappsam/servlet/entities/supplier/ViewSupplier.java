package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.Set;

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
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class ViewSupplier
 */
@WebServlet("/entities/supplier/SaveSupplier.do")
public class ViewSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewSupplier() {
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

		
		System.out.println("..........inside viewsupplier.java");
		String sID = (String) request.getParameter("supplierID");
		if(sID==null){
			sID = (String) request.getAttribute("supplierID");
		}
		int supplierID = Integer.parseInt(sID);
		
	
		
		Supplier s = null;
		Employee emp =null;
		Person p = null;
		try {
			s = ManagerBin.sManager.getSupplier(supplierID);
			request.setAttribute("supplier", s);
			emp = ManagerBin.pManager.getEmployee(s.getContactPersonID());
			p = emp.getPerson();
			
			request.setAttribute("supplier", s);
			request.setAttribute("employee",emp);
			request.setAttribute("person", p);
			
//			String mobile=null, landline=null, email=null;
//			Set<Contact>contacts = p.getContacts();
//			for(Contact c: contacts){
//				if(c.getType().equals(ContactType.MOBILE))
//					mobile = c.getData();
//				if(c.getType().equals(ContactType.LANDLINE))
//					landline = c.getData();
//				if(c.getType().equals(ContactType.EMAIL))
//					email = c.getData();
//			}
//			
//			request.setAttribute("mobile", mobile);
//			request.setAttribute("landline",landline);
//			request.setAttribute("email", email);
			
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
