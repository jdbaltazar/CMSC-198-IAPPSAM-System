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

import com.iappsam.entities.Building;
import com.iappsam.entities.Item;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.search.ItemSearcher;
import com.iappsam.search.Searcher;

@WebServlet("/entities/building/SearchAllBuildings.do")
public class SearchAllBuildings extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAllBuildings() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../entities/building/SearchBuildings.jsp");
		
		ArrayList<String> buildingName = new ArrayList<String>();
		ArrayList<String> buildingAddress = new ArrayList<String>();
		
		List<Building> buildings = new ArrayList<Building>();

		try {
			buildings = doManager.getAllBuildings();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
//		if (searchItemField == null || searchItemField.equalsIgnoreCase("")) {
//			try {
//				items = iManager.getAllItems();
//			} catch (TransactionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			items = s.search(searchItemField);
//		}

		for (Building b: buildings){
			buildingName.add(b.getBuildingName());
			buildingAddress.add(b.getBuildingAddress());
		}
		System.out.println("maaay sulooooooooood!!");
		request.setAttribute("buildingName", buildingName);
		request.setAttribute("buildingAddress", buildingAddress);
		
		
		view.forward(request, response);

	}

}
