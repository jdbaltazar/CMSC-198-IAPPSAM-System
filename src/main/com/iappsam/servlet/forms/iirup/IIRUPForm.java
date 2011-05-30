package com.iappsam.servlet.forms.iirup;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class IIRUPForm
 */
@WebServlet("/forms/iirup/iirup.do")
public class IIRUPForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// IIRUP
	private Date asOfDate;

	// iirupLine
	private ArrayList<String> quantity;
	private ArrayList<String> itemIDs;
	private ArrayList<String> yearsInService;
	private ArrayList<String> depreciation;
	private ArrayList<String> disposition;
	private ArrayList<String> appraisal;
	private ArrayList<String> orNumber;
	private ArrayList<String> amount;

	private String approvedBy;

	private String nameOfInspector;

	private String nameOfWitness;
	private String requestedBy;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPForm() {
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
	private String getDesignationFromEntry(String input) {
		System.out.println(input);
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ':')
				return input.substring(i + 2);
		}

		return null;
	}

	private String getPersonFromEntry(String input) {
		System.out.println("Input for getPersonFromEntry: " + input);
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ':')
				return input.substring(0, i - 1);
		}

		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IIRUPManager iManage = new IIRUPManagerSession();
		PersonManager pManager = new PersonManagerSession();

		// extra
		String accountableOfficer = (String) request.getSession().getAttribute("accountableOfficer");
		Date asOfDate = (Date) request.getSession().getAttribute("asOfDate");

		String station = (String) request.getSession().getAttribute("session");
		approvedBy = (String) request.getParameter("approvedBy");
		nameOfInspector = (String) request.getParameter("nameOfInspector");
		nameOfWitness = (String) request.getParameter("nameOfWitness");
		requestedBy = (String) request.getSession().getAttribute("requestedBy");
		itemIDs = (ArrayList<String>) request.getSession().getAttribute("itemList");
		quantity = (ArrayList<String>) request.getSession().getAttribute("quantity");
		yearsInService = (ArrayList<String>) request.getSession().getAttribute("yearsInService");
		depreciation = (ArrayList<String>) request.getSession().getAttribute("depreciation");
		disposition = (ArrayList<String>) request.getSession().getAttribute("disposition");
		appraisal = (ArrayList<String>) request.getSession().getAttribute("appraisal");
		orNumber = (ArrayList<String>) request.getSession().getAttribute("orNumber");
		amount = (ArrayList<String>) request.getSession().getAttribute("amount");

		String accountableOfficerEmployeeID = "";
		int limit;

		try {
			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(accountableOfficer)).getId()).size();
			Employee accountableEmployee = null;
			Employee approvedByEmployee = null;
			Employee requestedByEmployee = null;
			Employee witnessedByEmployee = null;
			Employee inspectedByEmployee = null;

			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(accountableOfficer)).getId()).get(i);
				if (temp.getDesignation().equals(getDesignationFromEntry(accountableOfficer))) {
					accountableOfficerEmployeeID = "" + temp.getId();
					accountableEmployee = temp;
					break;
				}
			}
			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(approvedBy)).getId()).size();
			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(approvedBy)).getId()).get(i);
				if (temp.getDesignation().equals(getDesignationFromEntry(approvedBy))) {
					approvedByEmployee = temp;
					break;
				}
			}

			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(requestedBy)).getId()).size();
			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(requestedBy)).getId()).get(i);
				if (temp.getDesignation().equals(getDesignationFromEntry(requestedBy))) {
					requestedByEmployee = temp;
					break;
				}
			}

			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(nameOfInspector)).getId()).size();
			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(nameOfInspector)).getId()).get(i);
				if (temp.getDesignation().equals(getDesignationFromEntry(nameOfInspector))) {
					inspectedByEmployee = temp;
					break;
				}
			}
			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(nameOfWitness)).getId()).size();
			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(getPersonFromEntry(nameOfWitness)).getId()).get(i);
				if (temp.getDesignation().equals(getDesignationFromEntry(nameOfWitness))) {
					witnessedByEmployee = temp;
					break;
				}
			}
			IIRUP iirupForm = new IIRUP(asOfDate, accountableEmployee, requestedByEmployee, approvedByEmployee, inspectedByEmployee, witnessedByEmployee);
			ArrayList<Item> item = new ArrayList<Item>();
			for (int i = 0; i < itemIDs.size(); i++) {
				Item itemInstance = ManagerBin.iManager.getItem(Integer.parseInt(itemIDs.get(i)));
				item.add(itemInstance);
			}
			for (int i = 0; i < item.size(); i++) {
				Disposal disposal = new Disposal();
				if (disposition.get(i).equalsIgnoreCase(Disposal.DESTROYED))
					disposal = new Disposal(Disposal.DESTROYED);
				if (disposition.get(i).equalsIgnoreCase(Disposal.SOLD_AT_PRIVATE_SALE))
					disposal = new Disposal(Disposal.SOLD_AT_PRIVATE_SALE);
				IIRUPLine line = new IIRUPLine(iirupForm, item.get(i), Integer.parseInt(quantity.get(i)), Integer.parseInt(yearsInService.get(i)), Float.parseFloat(depreciation.get(i)), disposal, orNumber.get(i));
				line.setAppraisal(appraisal.get(i));

				iirupForm.addLine(line);

			}
			try {
				ManagerBin.iirupManager.addIIRUP(iirupForm);

				System.out.println("successfully saved IIRUP!!");
				request.getSession().setAttribute("iirupForm", iirupForm);
				RequestDispatcher view = request.getRequestDispatcher("IIRUPFlush.do");
				view.forward(request, response);
			} catch (TransactionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (TransactionException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
}
