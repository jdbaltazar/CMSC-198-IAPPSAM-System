package com.iappsam.servlet.entities;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.helpers.ParseConversionEventImpl;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.ItemManagerSessionTest;

/**
 * Servlet implementation class ItemCreation
 */
@WebServlet("/stocks/createItem.do")
public class ItemCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	String name;
	String unit;
	String description;
	String price;
	String month;
	String day;
	String year;
	String stockNumber;
	String invItemNumber;
	String propertyNumber;
	String itemStatus;
	String itemCondition;

	public ItemCreation() {
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
	java.sql.Date date;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		name = request.getParameter("itemName");
		unit = request.getParameter("itemUnit");
		price = request.getParameter("itemPrice");
		description = request.getParameter("itemDescription");
		try {
			month = "" + Integer.parseInt(request.getParameter("month"));
			day = "" + Integer.parseInt(request.getParameter("dayAcquired"));
			year = "" + Integer.parseInt(request.getParameter("yearAcquired"));

			date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			month = request.getParameter("month");
			day = request.getParameter("dayAcquired");
			year = request.getParameter("yearAcquired");
		}
		stockNumber = request.getParameter("stockNumber");
		invItemNumber = request.getParameter("inventoryItemNum");
		propertyNumber = request.getParameter("itemPropertyNumber");
		itemStatus = request.getParameter("itemStatus");
		itemCondition = request.getParameter("itemCondition");

		if (name.isEmpty() || unit.isEmpty() || price.isEmpty() || description.isEmpty() || month.equalsIgnoreCase("MM") || itemStatus.isEmpty() || itemCondition.isEmpty() || day.equalsIgnoreCase("DD") || year.equalsIgnoreCase("YYYY")){
			failRequest(request, response);
			System.out.println("Heyoooo");
		}
		else
			succesfulRequest(request, response);

	}

	private void failRequest(HttpServletRequest request, HttpServletResponse response) {
		if (name.isEmpty())
			request.setAttribute("nameIsOK", "true");
		else
			request.setAttribute("nameIsOK", "false");
		if (unit.isEmpty())
			request.setAttribute("unitIsOK", "true");
		else
			request.setAttribute("unitIsOK", "false");
		if (price.isEmpty())
			request.setAttribute("priceIsOK", "true");
		else
			request.setAttribute("priceIsOK", "false");
		if (description.isEmpty())
			request.setAttribute("descriptionIsOK", "true");
		else
			request.setAttribute("descriptionIsOK", "false");
		if (date == null)
			request.setAttribute("dateIsOK", "true");
		else
			request.setAttribute("dateIsOK", "true");
		
		ItemManager iManager = new ItemManagerSession();
		
		try {
			request.setAttribute("name", name);
			request.setAttribute("unit", unit);
			request.setAttribute("price", price);
			request.setAttribute("description", description);
			request.setAttribute("propertyNumber", propertyNumber);
			request.setAttribute("inventoryItemNumber", invItemNumber);
			List<Unit> units;
			units = iManager.getAllUnits();
			List<ItemStatus> itemStatus = iManager.getAllItemStatus();
			List<ItemCondition> itemCondition = iManager.getAllItemCondition();
			ArrayList<String> unitList = new ArrayList<String>();
			ArrayList<String> itemStatusList=new ArrayList<String>();
			ArrayList<String> itemConditionList = new ArrayList<String>();
			for (int i = 0; i < units.size(); i++) {
				unitList.add(units.get(i).getName());
			}
			for(int i=0;i<itemStatus.size();i++){
				itemStatusList.add(itemStatus.get(i).getName());
			}
			for(int i=0;i<itemCondition.size();i++){
				itemConditionList.add(itemCondition.get(i).getName());
			}

			request.setAttribute("unitList", unitList);
			request.setAttribute("itemConditionList", itemConditionList);
			request.setAttribute("itemStatusList", itemStatusList);
		} catch (TransactionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("../jsp/stocks/CreateItemFail.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void succesfulRequest(HttpServletRequest request, HttpServletResponse response) {
//		Item item;
//		if (stockNumber.isEmpty())
//			item = new Item(name, unit, description, Float.parseFloat(price), date, itemStatus, itemCondition);
//		else
//			item = new Item(name, stockNumber, unit, description, Float.parseFloat(price), date, Integer.parseInt(invItemNumber), propertyNumber, itemStatus, itemCondition);
//		ItemManager manager = new ItemManagerSession();
//		try {
//			manager.addItem(item);
//		} catch (TransactionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
