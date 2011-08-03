package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCondition;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditItemCondAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int itemConditionID = Integer.parseInt(request.getParameter("itemConditionID"));
		ItemCondition itemCondition = new ItemCondition();
		RequestDispatcher edit = request.getRequestDispatcher(ItemConditionServlet.EDIT_ITEM_COND);
		try {
			itemCondition = ApplicationContext.INSTANCE.getItemManager().getItemCondition(itemConditionID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("itemCondition", itemCondition);
		edit.forward(request, response);
	}

}
