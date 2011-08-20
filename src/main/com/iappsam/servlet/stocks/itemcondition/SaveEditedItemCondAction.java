package com.iappsam.servlet.stocks.itemcondition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemCondition;
import com.iappsam.logging.Logger;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedItemCondAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = new EditItemCondAction();

		int itemConditionID = Integer.parseInt(request.getParameter("itemConditionID"));
		String name = request.getParameter("itemCondition").trim();

		ItemCondition itemCondition = null;

		try {
			itemCondition = ApplicationContext.INSTANCE.getItemManager().getItemCondition(itemConditionID);
			if (Validator.validField(name)) {
				itemCondition.setName(name);
				ApplicationContext.INSTANCE.getItemManager().updateItemCondition(itemCondition);
				Logger.log(request, "Item Condition \""+name+"\" was updated");
				Action vAction = new ViewItemCondsAction();
				vAction.process(request, response);
				return;
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("itemCondition", itemCondition);
		}

		request.setAttribute("itemConditionID", "" + itemConditionID);
		action.process(request, response);
	}

}
