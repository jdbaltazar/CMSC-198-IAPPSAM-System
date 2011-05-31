package com.iappsam.servlet.entities.supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Supplier;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class SearchSuppliers
 */
@WebServlet("/entities/supplier/SearchSuppliers.do")
public class SearchSuppliers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchSuppliers() {
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
		// TODO Auto-generated method stub

		System.out.println("..........inside searchSuppliers.java");
		List<Supplier> suppliers = new ArrayList<Supplier>();

		try {
			suppliers = ManagerBin.sManager.getAllSuppliers();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("suppliers", suppliers);
		RequestDispatcher view = request.getRequestDispatcher("SearchSuppliers.jsp");
		view.forward(request, response);

	}

}
