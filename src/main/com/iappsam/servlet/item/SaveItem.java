package com.iappsam.servlet.item;

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

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.DateUtil;

/**
 * Servlet implementation class SaveItem
 */
@WebServlet("/stocks/SaveItem.do")
public class SaveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveItem() {
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
		Item item = new Item();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("items/AddItem.jsp");

		String description = (String) request.getParameter("itemDescription"); //
		String stockNumber = (String) request.getParameter("stockNumber");
		String unit = (String) request.getParameter("itemUnit");//
		String priceS = (String) request.getParameter("itemPrice");
		float price = 0;

		// System.out.println("Price: " + priceS);
		if (priceS != null && validPrice(priceS))
			price = Float.parseFloat(priceS);
		Date dateAcquired = null;

		String day = (String) request.getParameter("day");
		String month = (String) request.getParameter("month");
		String year = (String) request.getParameter("year");

		System.out.println("year:month:day " + year + ":" + month + ":" + day);

		try {
			if (!(day.equalsIgnoreCase("DD") || month.equalsIgnoreCase("MM") || year.equalsIgnoreCase("YYYY")))
				dateAcquired = Date.valueOf(year + "-" + month + "-" + day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hey Bitch:-"+dateAcquired.toString());
		String inventoryItemNumber = (String) request.getParameter("inventoryItemNum");
		String propertyNumber = (String) request.getParameter("itemPropertyNumber");
		String itemStatus = (String) request.getParameter("itemStatus");//
		String itemCondition = (String) request.getParameter("itemCondition");//
		String itemCategory = (String) request.getParameter("itemCategory");//

		List<Unit> units = new ArrayList<Unit>();
		List<ItemCategory> categories = new ArrayList<ItemCategory>();
		List<ItemStatus> status = new ArrayList<ItemStatus>();
		List<ItemCondition> conditions = new ArrayList<ItemCondition>();

		ArrayList<String> itemUnits = new ArrayList<String>();
		ArrayList<String> itemCategories = new ArrayList<String>();
		ArrayList<String> itemStatuses = new ArrayList<String>();
		ArrayList<String> itemConditions = new ArrayList<String>();

		System.out.println("description: " + description);
		System.out.println("stockNumber: " + stockNumber);
		System.out.println("unit: " + unit);
		System.out.println("price: " + price);
		System.out.println("invenItemNum: " + inventoryItemNumber);
		System.out.println("propNumber: " + propertyNumber);
		System.out.println("itemStatus: " + itemStatus);
		System.out.println("itemCondition: " + itemCondition);
		System.out.println("itemCategory: " + itemCategory);

		if (validInputs(description, stockNumber, itemCategory, unit, priceS, dateAcquired, inventoryItemNumber, propertyNumber, itemStatus,
				itemCondition)) {

			// flags
			request.setAttribute("firstAttempt", "false");
			request.setAttribute("validEntries", "true");

			// request.setAttribute("itemDescription", description);
			// request.setAttribute("stockNumber", stockNumber);
			// request.setAttribute("itemUnit", unit);
			// request.setAttribute("itemPrice", Float.toString(price));
			// // request.setAttribute("date", arg1);
			// request.setAttribute("inventoryItemNumber", inventoryItemNumber);
			// request.setAttribute("itemPropertyNumber", propertyNumber);
			// request.setAttribute("itemStatus", itemStatus);
			// request.setAttribute("itemCondition", itemCondition);
			// request.setAttribute("itemCategory", itemCategory);

			item.setDescription(description);
			item.setStockNumber(stockNumber);
			try {
				item.setUnit(iManager.getUnitByName(unit));
			} catch (TransactionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			item.setPrice(price);
			if (dateAcquired != null)
				item.setDateAcquired(dateAcquired);
			item.setInventoryItemNumber(inventoryItemNumber);
			item.setPropertyNumber(propertyNumber);
			try {
				item.setItemStatus(iManager.getItemStatus(itemStatus));
			} catch (TransactionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				item.setItemCondition(iManager.getItemCondition(itemCondition));
			} catch (TransactionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (itemCategory != null) {

				ItemCategory iC = iManager.getItemCategoryByName(itemCategory);
				if (iC != null)
					item.setItemCategory(iC);
			}
			else {
				item.setItemCategory(iManager.getItemCategoryByName("Others"));
			}
			request.setAttribute("item", item);

			try {
				iManager.addItem(item);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			requestDispatcher = request.getRequestDispatcher("items/ViewItem.jsp");

			System.out.println("Item was saved!!!!!");
		} else {
			request.setAttribute("firstAttempt", "false");
			request.setAttribute("validEntries", "false");

			try {

				units = iManager.getAllUnits();
				categories = iManager.getAllItemCategory();
				status = iManager.getAllItemStatus();
				conditions = iManager.getAllItemCondition();

				if (units == null)
					units = new ArrayList<Unit>();

				if (categories == null)
					categories = new ArrayList<ItemCategory>();

				if (status == null)
					status = new ArrayList<ItemStatus>();

				if (conditions == null)
					conditions = new ArrayList<ItemCondition>();

			} catch (TransactionException e) {
				e.printStackTrace();
			}
			for (Unit u : units) {
				itemUnits.add(u.getName());
			}

			for (ItemCategory i : categories) {
				itemCategories.add(i.getName());
			}

			for (ItemStatus i : status) {
				itemStatuses.add(i.getName());
			}

			for (ItemCondition i : conditions) {
				itemConditions.add(i.getName());
			}
			request.setAttribute("itemUnits", itemUnits);
			request.setAttribute("itemCategories", itemCategories);
			request.setAttribute("itemStatuses", itemStatuses);
			request.setAttribute("itemConditions", itemConditions);

			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("day", DateUtil.getDayEquivalent(date));
			request.setAttribute("month", DateUtil.getMonthEquivalentInWords(date));
			request.setAttribute("year", DateUtil.getYearEquivalent(date));

			requestDispatcher = request.getRequestDispatcher("items/AddItem.jsp");

			System.out.println("Item was not saved!!!");
		}

		requestDispatcher.forward(request, response);
	}

	private boolean validPrice(String priceS) {
		// TODO Auto-generated method stub

		try {
			float f = Float.parseFloat(priceS);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	private boolean validInputs(String description, String stockNumber, String itemCategory, String unit, String priceS, Date dateAcquired,
			String inventoryItemNumber, String propertyNumber, String itemStatus, String itemCondition) {
		if (description == null) {
			return false;
		}
		if (description.equalsIgnoreCase("")) {
			return false;
		}
		// if(priceS!=null){
		// if(!validPrice(priceS))
		// return false;
		// }
		return true;
	}

}