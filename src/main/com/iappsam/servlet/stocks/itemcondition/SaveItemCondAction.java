package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCondition;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveItemCondAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		ItemCondition condition = new ItemCondition();

		RequestDispatcher add = request.getRequestDispatcher(ItemConditionServlet.ADD_ITEM_COND);

		String conditionInput = request.getParameter("itemCondition").trim();
		if (Validator.validField(conditionInput)) {
			condition.setName(conditionInput);
			try {
				itemManager.addItemCondition(condition);
				Action vAction = new ViewItemCondsAction();
				vAction.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}

}
