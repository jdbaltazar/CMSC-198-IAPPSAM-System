package com.iappsam.servlet.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class UpdateDivisionOffice
 */
@WebServlet("/divisions/UpdateDivisionOffice.do")
public class UpdateDivisionOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDivisionOffice() {
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
		
		String dOfficeId = (String)request.getParameter("dOfficeID");
		List<DivisionOffice>dos = new ArrayList<DivisionOffice>();
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		DivisionOffice dOffice = null;
		
		try {
			dos = doManager.getAllDivisionOffice();
			dOffice = doManager.getDivisionOffice(Integer.parseInt(dOfficeId));
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("divOffices", dos);
		request.setAttribute("dOffice", dOffice);
		
		RequestDispatcher view = request.getRequestDispatcher("../entities/division/UpdateDivisionOffice.jsp");
		view.forward(request, response);
	}

}
