package com.iappsam.servlet.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Employee;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class IIRUPFormCreate
 */
@WebServlet(name = "IIRUP_FormCreate.do", urlPatterns = { "/forms/view/forms/IIRUP_FormCreate.do" })
public class IIRUPForm1Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPForm1Create() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private Enumeration<String> attributeNames;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> designationName = new ArrayList<String>();
		List<Employee> employeeList;

		if (request.getAttribute("articleName") != null)
			imbedSession(request);

		try {
			employeeList = ManagerBin.getInstance().pManager.getAllEmployee();
			for (int i = 0; i < employeeList.size(); i++) {
				designationName.add(employeeList.get(i).getPerson().getName() + ":" + employeeList.get(i).getDesignation());
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("designationName", designationName);
		RequestDispatcher view = request.getRequestDispatcher("../IIRUPForm.jsp");

		view.forward(request, response);
	}
	
	private void imbedSession(HttpServletRequest request) {
		ArrayList<String> articleName = (ArrayList<String>) request.getAttribute("articleName");
		ArrayList<String> quantity = (ArrayList<String>) request.getAttribute("quantity");
		ArrayList<String> unitCost = (ArrayList<String>) request.getAttribute("unitCost");
		ArrayList<String> totalCost = (ArrayList<String>) request.getAttribute("totalCost");
		ArrayList<String> propertyNo = (ArrayList<String>) request.getAttribute("propertyNo");
		ArrayList<String> dateAcquired = (ArrayList<String>) request.getAttribute("dateAcquired");
		ArrayList<String> noOfYearsInService = (ArrayList<String>) request.getAttribute("noOfYearsInService");
		ArrayList<String> accumulatedDepreciation = (ArrayList<String>) request.getAttribute("accumulatedDepreciation");
		ArrayList<String> disposition = (ArrayList<String>) request.getAttribute("disposition");
		ArrayList<String> appraisal = (ArrayList<String>) request.getAttribute("appraisal");
		ArrayList<String> orNumber = (ArrayList<String>) request.getAttribute("orNumber");
		ArrayList<String> amount = (ArrayList<String>) request.getAttribute("amount");

		if (request.getAttribute("station") != null) {
			String station = (String) request.getAttribute("session");
			String designation = (String) request.getAttribute("designation");
			String nameOfAcctableOffice = (String) request.getAttribute("nameOfAcctableOfficer");
			String asOfField = (String) request.getAttribute("asOfField");
			request.setAttribute("station", station);
			request.setAttribute("designation", designation);
			request.setAttribute("nameOfAcctableOfficer", nameOfAcctableOffice);
			request.setAttribute("asOfField", asOfField);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
