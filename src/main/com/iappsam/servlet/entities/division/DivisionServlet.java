package com.iappsam.servlet.entities.division;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;

/**
 * Servlet implementation class DivisionServlet
 */
@WebServlet("/division")
public class DivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VIEW_DIVISIONS = "/entities/division/SearchDivisions.jsp";
	public static final String ADD_DIVISION = "/entities/division/AddDivision.jsp";
	public static final String VIEW_SUPPLIER = "/entities/supplier/ViewSupplier.jsp";

	public static final String DIVISION_ACTION = "action";
	public static final String VIEW_DIVISIONS_ACTION = "view";
	public static final String NEW_DIVISION_ACTION = "new-division";
	
	public static final String VIEW_SUPPLIERS_ACTION = "view-suppliers";
	public static final String NEW_SUPPLIER_ACTION = "new-supplier";
	public static final String SEARCH_SUPPLIERS_ACTION = "search-suppliers";
	public static final String VIEW_SUPPLIER_ACTION = "view-supplier";
	public static final String EDIT_SUPPLIER_ACTION = "edit-supplier";
	public static final String SAVE_SUPPLIER_ACTION = "save-supplier";
	
    public DivisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(DIVISION_ACTION);
		if(action.equalsIgnoreCase(VIEW_DIVISIONS_ACTION)){
			Action viewAction = new ViewDivisionsAction();
			try {
				viewAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(DIVISION_ACTION);
		if(action.equalsIgnoreCase(VIEW_DIVISIONS_ACTION)){
			Action viewDivisionsAction = new ViewDivisionsAction();
			try {
				viewDivisionsAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equalsIgnoreCase(NEW_DIVISION_ACTION)){
			Action newDivisionAction = new NewDivisionAction();
			try {
				newDivisionAction.process(request, response);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
