package com.iappsam.servlet.forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IIRUPForm
 */
@WebServlet(name = "IIRUPForm.do", urlPatterns = { "/IIRUPForm.do" })
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String asOfField = (String) request.getAttribute("asOfField");
		String station = (String) request.getSession().getAttribute("station");
		int articleLength = (Integer) request.getSession().getAttribute("articleLength");
		ArrayList<String> articleUnitNumbers = (ArrayList<String>) request.getSession().getAttribute("articleUnitNumbers");

		request.getSession().setAttribute("asOfField", asOfField);
		request.getSession().setAttribute("station", station);
		request.getSession().setAttribute("articleLength", articleLength);
		request.getSession().setAttribute("articleUnitNumbers", articleUnitNumbers);

	}
}
