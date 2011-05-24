package com.iappsam.servlet.forms.iirup;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Employee;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

/**
 * Servlet implementation class IIRUPForm
 */
@WebServlet(name = "IIRUPForm.do", urlPatterns = { "/iirup.do" })
public class IIRUPForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	private String getPerson(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ':')
				return input.substring(i + 2);
		}

		return null;
	}

	private String getDesignation(String input) {
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

		String asOfDate = (String) request.getSession().getAttribute("asOfDate");
		String station = (String) request.getSession().getAttribute("session");
		String[] itemIDs = (String[]) request.getSession().getAttribute("include_1");

		String[] yearsInService = (String[]) request.getSession().getAttribute("yearsInService");
		String[] depreciation = (String[]) request.getSession().getAttribute("depreciation");
		String[] disposition = (String[]) request.getSession().getAttribute("disposition");
		String[] appraisal = (String[]) request.getSession().getAttribute("appraisal");
		String[] orNumber = (String[]) request.getSession().getAttribute("orNumber");
		String[] amount = (String[]) request.getSession().getAttribute("amount");

		String accountableOfficerEmployeeID = "";
		int limit;
		try {
			limit = pManager.getEmployeeByPerson(pManager.getPerson(getPerson(accountableOfficer)).getId()).size();
			for (int i = 0; i < limit; i++) {
				Employee temp;
				temp = pManager.getEmployeeByPerson(pManager.getPerson(accountableOfficer).getId()).get(i);
				if (temp.getDesignation().equals(getDesignation(accountableOfficer))) {
					accountableOfficerEmployeeID = "" + temp.getId();
				}
			}
		} catch (TransactionException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		IIRUP iirupForm = new IIRUP(new Date(0), Integer.parseInt(accountableOfficerEmployeeID), 1, 1, 1, 1);
		try {
			iManage.addIIRUP(iirupForm);
		} catch (TransactionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < itemIDs.length; i++) {
			IIRUPLine iLine = new IIRUPLine(Integer.parseInt(itemIDs[i]), 0, 0, 0, "0", "0", iirupForm.getIirupID());
			try {
				iManage.addIIRUPLine(iLine);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
