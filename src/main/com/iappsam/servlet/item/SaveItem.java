package com.iappsam.servlet.item;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class SaveItem
 */
@WebServlet("/stocks/SaveItem.do")
public class SaveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveItem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager iManager = new ItemManagerSession();
		Item item = new Item();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("items/AddItem.jsp");

		String description = request.getParameter("itemDescription"); //
		String stockNumber = request.getParameter("stockNumber");
		String unitName = request.getParameter("itemUnit");//

		float price = 0;

		Date dateAcquired = parseDateFrom(request);

		String inventoryItemNumber = (String) request.getParameter("inventoryItemNum");
		String propertyNumber = (String) request.getParameter("itemPropertyNumber");
		String itemStatusName = (String) request.getParameter("itemStatus");
		String itemCondition = (String) request.getParameter("itemCondition");
		String itemCategory = (String) request.getParameter("itemCategory");

		// flags
		request.setAttribute("finishedInputting", "true");
		request.setAttribute("validInputForItem", "true");

		request.setAttribute("itemDescription", description);
		request.setAttribute("stockNumber", stockNumber);
		request.setAttribute("itemUnit", unitName);
		request.setAttribute("itemPrice", Float.toString(price));
		request.setAttribute("inventoryItemNumber", inventoryItemNumber);
		request.setAttribute("itemPropertyNumber", propertyNumber);
		request.setAttribute("itemStatus", itemStatusName);
		request.setAttribute("itemCondition", itemCondition);
		request.setAttribute("itemCategory", itemCategory);

		item.setDescription(description);
		item.setStockNumber(stockNumber);
		try {
			item.setUnit(ManagerBin.iManager.getUnitByName(unitName));
			item.setPrice(price);
			item.setDateAcquired(dateAcquired);
			item.setInventoryItemNumber(inventoryItemNumber);
			item.setPropertyNumber(propertyNumber);
			item.setItemStatus(ManagerBin.iManager.getItemStatus(itemStatusName));
			item.setItemCondition(ManagerBin.iManager.getItemCondition(itemCondition));
			item.setItemCategory(ManagerBin.iManager.getItemCategoryByName(itemCategory));
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}
		try {
			iManager.addItem(item);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		System.out.println("Success!");
		requestDispatcher.forward(request, response);
	}

	public static Date parseDateFrom(HttpServletRequest request) {
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		StringBuilder dateBuilder = new StringBuilder(year);
		dateBuilder.append("-").append(month).append("-").append(day);
		Date dateAcquired = Date.valueOf(dateBuilder.toString());
		return dateAcquired;
	}
}