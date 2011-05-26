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
 * Servlet implementation class SaveDivisionOffice
 */
@WebServlet("/divisions/SaveDivisionOffice.do")
public class SaveDivisionOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDivisionOffice() {
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
		

		RequestDispatcher view = request.getRequestDispatcher("../divisions/AddDivisionOffice.do");
		String division = (String)request.getParameter("inDivision");
		String office = (String)request.getParameter("officeName");
		if(division!=null&&office!=null){
			if(!(division.equalsIgnoreCase("")||office.equalsIgnoreCase(""))){
				System.out.println("division name: "+division);
				DivisionOffice dOffice = new DivisionOffice(division, office);
				DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
				
				try {
					doManager.addDivisionOffice(dOffice);
					System.out.println("Saved division office successfully!");
					view = request.getRequestDispatcher("../divisions/SearchDivisionOffice.do");
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		view.forward(request, response);
	}

}
