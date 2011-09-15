package com.iappsam.servlet.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.logging.Logger;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

public class AddItemAction implements Action {

	private ItemManager itemManager;

	protected ItemManager getItemManager() {
		return itemManager;
	}

	public AddItemAction(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Item item = getItem(request, response);

		String idParam = request.getParameter("id");
		String description = request.getParameter("description");
		String stockNumber = request.getParameter("stockNumber");
		String unit = request.getParameter("unit");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String inventoryItemNumber = request.getParameter("inventoryItemNum");
		String propertyNumber = request.getParameter("propertyNumber");
		String statusName = request.getParameter("itemStatus");
		String conditionName = request.getParameter("itemCondition");
		String categoryName = request.getParameter("itemCategory");

		try {
			if (idParam != null)
				item.setId(Integer.parseInt(idParam));
			item.setDescription(description);
			item.setStockNumber(stockNumber);
			item.setPrice(price);
			item.setDateAcquired(date);
			item.setInventoryItemNumber(inventoryItemNumber);
			item.setPropertyNumber(propertyNumber);
			item.setUnit(itemManager.getUnitByName(unit));
			item.setStatus(itemManager.getItemStatusByName(statusName));
			item.setCondition(itemManager.getItemConditionByName(conditionName));
			item.setCategory(itemManager.getItemCategoryByName(categoryName));

			if (!item.validate())
				processInvalidItem(request, response, item);
			else
				processValidItem(request, response, item, idParam, description);
		} catch (Exception e) {
			try {
				processInvalidItem(request, response, item);
			} catch (TransactionException e1) {
			}
		}
	}

	protected Item getItem(HttpServletRequest req, HttpServletResponse res) {
		return new Item();
	}

	private void processValidItem(HttpServletRequest request, HttpServletResponse response, Item item, String idParam, String description)
			throws TransactionException, IOException {
		itemManager.addItem(item);
		if (idParam != null)
			Logger.log(request, "Item  \"" + description + "\" was updated");
		else
			Logger.log(request, "Item  \"" + description + "\" was added");
		response.sendRedirect("/items");
	}

	private void processInvalidItem(HttpServletRequest req, HttpServletResponse response, Item item) throws TransactionException, ServletException,
			IOException {

		req.setAttribute("description", req.getParameter("description"));
		req.setAttribute("categories", itemManager.getAllItemCategory());
		req.setAttribute("units", itemManager.getAllUnits());
		req.setAttribute("statuses", itemManager.getAllItemStatus());
		req.setAttribute("conditions", itemManager.getAllItemCondition());
		req.setAttribute("item", item);

		forward(req, response);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP);
		dispatcher.forward(req, response);
	}
}
