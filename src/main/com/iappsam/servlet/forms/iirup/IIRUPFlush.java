package com.iappsam.servlet.forms.iirup;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.IIRUP;

/**
 * Servlet implementation class IIRUPFlush
 */
@WebServlet( urlPatterns={"/forms/IIRUPFlush.do","/forms/iirup/IIRUPFlush.do"})
public class IIRUPFlush extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPFlush() {
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
		Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
		while (sessionAttributeNames.hasMoreElements()) {
			String sessionAttributeName = sessionAttributeNames.nextElement();
			if (!sessionAttributeName.equalsIgnoreCase("userName") && !sessionAttributeName.equalsIgnoreCase("iirupForm"))
				request.getSession().removeAttribute(sessionAttributeName);
			else
				continue;
		}
		IIRUP iirupForm = (IIRUP)request.getAttribute("iirupForm");
		
		if(iirupForm!=null)
		System.out.println("IIRUPForm ID:!!!!!"+iirupForm.getId());
		else
		System.out.println("Pass fail");
		request.setAttribute("iirupForm", iirupForm);
		RequestDispatcher view = request.getRequestDispatcher("IIRUPFormFinalize.jsp");
		view.forward(request, response);

	}

}
