package com.iappsam.servlet.employee;

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
 * Servlet implementation class AddEmployee
 */
@WebServlet("/entities/AddEmployee.do")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
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
		DivisionOfficeManager manager =new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("/entities/employees/AddEmployee.jsp");
		
		try {
			List<DivisionOffice> divisionOfficeList = manager.getAllDivisionOffice();
			ArrayList<String> divisionOfficeListFinal= new ArrayList<String>();
			int i =0;
			while(i<divisionOfficeList.size()){
				divisionOfficeListFinal.add(divisionOfficeList.get(i).getDivisionName());
				i++;
			}
			request.setAttribute("divisionOfficeListFinal", divisionOfficeListFinal);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.forward(request, response);
	}

}
