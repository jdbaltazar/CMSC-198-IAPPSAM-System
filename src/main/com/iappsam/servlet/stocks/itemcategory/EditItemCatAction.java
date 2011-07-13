package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCategory;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditItemCatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		System.out.println("........inside edititemcategory.java");

		int itemCategoryID = Integer.parseInt(request.getParameter("itemCategoryID"));
		ItemCategory itemCategory = new ItemCategory();
		RequestDispatcher edit = request.getRequestDispatcher(ItemCategoryServlet.EDIT_ITEM_CAT);
		try {
			itemCategory = ApplicationContext.INSTANCE.getItemManager().getItemCategory(itemCategoryID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("itemCategory", itemCategory);
		edit.forward(request, response);
	}

}
