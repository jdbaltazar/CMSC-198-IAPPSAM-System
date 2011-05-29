package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

/**
 * Servlet implementation class EditDivision
 */
@WebServlet("/entities/division/EditDivision.do")
public class EditDivision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDivision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dOfficeID = (String)request.getParameter("dOfficeID");
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		DivisionOffice dOffice = null;
		RequestDispatcher view = null;
		System.out.println("id: "+dOfficeID);
		
		try {
			dOffice = doManager.getDivisionOffice(Integer.parseInt(dOfficeID));
			request.setAttribute("dOffice", dOffice);
			view = request.getRequestDispatcher("EditDivision.jsp");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(view==null)
			view = request.getRequestDispatcher("ViewDivisionAndOffices.do");
		view.forward(request, response);
		
	}

}
