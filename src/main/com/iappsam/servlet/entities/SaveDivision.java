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
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;

/**
 * Servlet implementation class SaveDivisionOffice
 */
@WebServlet("/divisions/SaveDivision.do")
public class SaveDivision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDivision() {
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
		String name = (String)request.getParameter("name");
		if(name!=null){
			if(!name.equalsIgnoreCase("")){
				System.out.println("division name: "+name);
				DivisionOffice dOffice = new DivisionOffice(name, null);
				DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
				
				try {
					doManager.addDivisionOffice(dOffice);
					System.out.println("Saved division successfully!");
					view = request.getRequestDispatcher("../divisions/SearchDivisionOffice.do");
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DuplicateEntryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		view.forward(request, response);

	}

}
