package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCategory;
import com.iappsam.logging.Logger;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveItemCatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemCategory category = new ItemCategory();

		RequestDispatcher add = request.getRequestDispatcher(ItemCategoryServlet.ADD_ITEM_CAT);

		String categoryInput = request.getParameter("itemCategory").trim();
		if (Validator.validField(categoryInput)) {
			category.setName(categoryInput);
			try {
				itemManager.addItemCategory(category);
				Logger.log(request, "Item Category \""+categoryInput+"\" was added");
				Action viewAction = new ViewItemCatsAction();
				viewAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}

}
