package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCategory;
import com.iappsam.logging.Logger;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedItemCatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// RequestDispatcher save =
		// request.getRequestDispatcher("EditItemCategory.do");
		Action action = new EditItemCatAction();

		int itemCategoryID = Integer.parseInt(request.getParameter("itemCategoryID"));
		String name = request.getParameter("itemCategory").trim();

		ItemCategory itemCategory = null;

		try {
			itemCategory = ApplicationContext.INSTANCE.getItemManager().getItemCategory(itemCategoryID);
			if (Validator.validField(name)) {
				itemCategory.setName(name);
				ApplicationContext.INSTANCE.getItemManager().updateItemCategory(itemCategory);
				Logger.log(request,  "Item Category \""+name+"\" was updated");
				Action vAction = new ViewItemCatsAction();
				vAction.process(request, response);
				return;

			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("itemCategory", itemCategory);
		}

		request.setAttribute("itemCategoryID", "" + itemCategoryID);
		action.process(request, response);
	}

}
