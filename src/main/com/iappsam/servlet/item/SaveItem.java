package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.Date;

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
		Date dateAcquired = new Date();
		String inventoryItemNumber = (String) request.getParameter("inventoryItemNum");
		String propertyNumber = (String) request.getParameter("itemPropertyNumber");
		String itemStatus = (String) request.getParameter("itemStatus");//
		String itemCondition = (String) request.getParameter("itemCondition");//
		String itemCategory = (String) request.getParameter("itemCategory");//

		// System.out.println("description: " + description);
		// System.out.println("stockNumber: " + stockNumber);
		// System.out.println("unit: " + unit);
		// System.out.println("price: " + price);
		// System.out.println("invenItemNum: " + inventoryItemNumber);
		// System.out.println("propNumber: " + propertyNumber);
		// System.out.println("itemStatus: " + itemStatus);
		// System.out.println("itemCondition: " + itemCondition);
		// System.out.println("itemCategory: " + itemCategory);

		if (validInputs(description, stockNumber, itemCategory, unit, price, dateAcquired, inventoryItemNumber, propertyNumber, itemStatus, itemCondition)) {

			// flags
			request.setAttribute("finishedInputting", "true");
			request.setAttribute("validInputForItem", "true");

			request.setAttribute("itemDescription", description);
			request.setAttribute("stockNumber", stockNumber);
			request.setAttribute("itemUnit", unit);
			request.setAttribute("itemPrice", Float.toString(price));
			// request.setAttribute("date", arg1);
			request.setAttribute("inventoryItemNumber", inventoryItemNumber);
			request.setAttribute("itemPropertyNumber", propertyNumber);
			request.setAttribute("itemStatus", itemStatus);
			request.setAttribute("itemCondition", itemCondition);
			request.setAttribute("itemCategory", itemCategory);

			item.setDescription(description);
			item.setStockNumber(stockNumber);
			item.setUnit(unit);
			item.setPrice(price);
			// item.setDateAcquired(dateAcquired);
			item.setInventoryItemNumber(inventoryItemNumber);
			item.setPropertyNumber(propertyNumber);
			item.setStatus(itemStatus);
			item.setCondition(itemCondition);
			item.setCategory(itemCategory);

			try {
				iManager.addItem(item);
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		System.out.println("Success!");
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

	private boolean validInputs(String description, String stockNumber, String itemCategory, String unit, float price, Date dateAcquired, String inventoryItemNumber, String propertyNumber, String itemStatus, String itemCondition) {

		return true;
	}

}