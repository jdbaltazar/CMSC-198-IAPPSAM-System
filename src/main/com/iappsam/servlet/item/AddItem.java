package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/stocks/AddItem.do")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItem() {
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
		ItemManager iManager = new ItemManagerSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("items/AddItem.jsp");

		List<Unit> units = new ArrayList<Unit>();
		List<ItemCategory> categories = new ArrayList<ItemCategory>();
		List<ItemStatus> status = new ArrayList<ItemStatus>();
		List<ItemCondition> conditions = new ArrayList<ItemCondition>();
		
		ArrayList<String> itemUnits = new ArrayList<String>();
		ArrayList<String> itemCategories = new ArrayList<String>();
		ArrayList<String> itemStatuses = new ArrayList<String>();
		ArrayList<String> itemConditions = new ArrayList<String>();

		try{
		
		units = iManager.getAllUnits();
		categories = iManager.getAllItemCategory();
		status = iManager.getAllItemStatus();
		conditions = iManager.getAllItemCondition();
		
		if(units==null)
			units = new ArrayList<Unit>();
		
		if(categories==null)
			categories = new ArrayList<ItemCategory>();
		
		if(status==null)
			status = new ArrayList<ItemStatus>();
		
		if(conditions==null)
			conditions = new ArrayList<ItemCondition>();
		
		

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Unit u : units) {
			itemUnits.add(u.getUnit());
		}

		for (ItemCategory i : categories) {
			itemCategories.add(i.getItemCategory());
		}

		for (ItemStatus i : status) {
			itemStatuses.add(i.getItemStatus());
		}

		for (ItemCondition i : conditions) {
			itemConditions.add(i.getItemCondition());
		}

		request.setAttribute("finishedInputting", "false");
		request.setAttribute("validInputForItem", "true");
		request.setAttribute("itemUnits", itemUnits);
		request.setAttribute("itemCategories", itemCategories);
		request.setAttribute("itemStatuses", itemStatuses);
		request.setAttribute("itemConditions", itemConditions);

		requestDispatcher.forward(request, response);
	}

}
