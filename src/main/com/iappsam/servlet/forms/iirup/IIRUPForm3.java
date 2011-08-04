package com.iappsam.servlet.forms.iirup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IIRUPForm2Form3Interval
 */
@WebServlet("/forms/iirup/IIRUPForm3.do")
public class IIRUPForm3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPForm3() {
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
		String[] yearsInService1 = request.getParameterValues("yearsInService");
		String[] quantity1 = request.getParameterValues("quantity");
		String[] depreciation1 = request.getParameterValues("depreciation");
		String[] disposition1 = request.getParameterValues("disposition");
		String[] appraisal1 = request.getParameterValues("appraisal");
		String[] orNumber1 = request.getParameterValues("orNumber");

		ArrayList<String> itemList = (ArrayList<String>) request.getSession().getAttribute("itemList");
		ArrayList<String> quantity = new ArrayList<String>();
		ArrayList<String> yearsInService = new ArrayList<String>();
		ArrayList<String> depreciation = new ArrayList<String>();
		ArrayList<String> disposition = new ArrayList<String>();
		ArrayList<String> appraisal = new ArrayList<String>();
		ArrayList<String> orNumber = new ArrayList<String>();
		ArrayList<String> amount = new ArrayList<String>();
		for (int i = 0; i < itemList.size(); i++) {
			if (yearsInService1 != null)
				yearsInService.add(yearsInService1[i]);
			else
				yearsInService.add("");

			if (quantity1 != null)
				quantity.add(quantity1[i]);
			else
				quantity.add("");

			if (depreciation1 != null)
				depreciation.add(depreciation1[i]);
			else
				depreciation.add("");

			if (disposition1 != null)
				disposition.add(disposition1[i]);
			else
				disposition.add("");

			if (appraisal1 != null)
				appraisal.add(appraisal1[i]);
			else
				appraisal.add("");

			if (orNumber1 != null)
				orNumber.add(orNumber1[i]);
			else
				orNumber.add("");

		}
		request.getSession().setAttribute("quantity", quantity);
		request.getSession().setAttribute("yearsInService", yearsInService);
		request.getSession().setAttribute("depreciation", depreciation);
		request.getSession().setAttribute("disposition", disposition);
		request.getSession().setAttribute("appraisal", appraisal);
		request.getSession().setAttribute("orNumber", orNumber);
		RequestDispatcher view = request.getRequestDispatcher("IIRUPForm3.jsp");

		view.forward(request, response);
	}

}
