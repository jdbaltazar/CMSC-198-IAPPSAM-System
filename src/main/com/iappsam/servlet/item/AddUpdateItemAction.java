package com.iappsam.servlet.item;

import static com.iappsam.servlet.item.ItemAttribute.CATEGORIES;
import static com.iappsam.servlet.item.ItemAttribute.CONDITIONS;
import static com.iappsam.servlet.item.ItemAttribute.STATUSES;
import static com.iappsam.servlet.item.ItemAttribute.UNITS;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

public class AddUpdateItemAction implements Action {

	private ItemManager itemManager;

	public AddUpdateItemAction(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Item item = new Item();

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
				throw new RuntimeException();

			itemManager.addItem(item);
//			Logger.log(request, new java.sql.Date((new java.util.Date()).getTime()), "Item \"" + description + "\" was added");
			response.sendRedirect("/items?id=" + item.getId());
		} catch (Exception e) {
			try {
				request.setAttribute(CATEGORIES, itemManager.getAllItemCategory());
				request.setAttribute(UNITS, itemManager.getAllUnits());
				request.setAttribute(STATUSES, itemManager.getAllItemStatus());
				request.setAttribute(CONDITIONS, itemManager.getAllItemCondition());
				RequestDispatcher dispatcher = request.getRequestDispatcher(ItemServlet.NEW_ITEM_JSP);
				dispatcher.forward(request, response);
			} catch (TransactionException e1) {
				e1.printStackTrace();
			}
		}
	}
}