package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Unit;
import com.iappsam.logging.Logger;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;
import com.iappsam.util.Validator;

public class SaveEditedItemUnitAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = new EditItemUnitAction();

		int itemUnitID = Integer.parseInt(request.getParameter("itemUnitID"));
		String name = request.getParameter("itemUnit").trim();

		Unit unit = null;

		try {
			unit = ApplicationContext.INSTANCE.getItemManager().getUnit(itemUnitID);
			if (Validator.validField(name)) {
				unit.setName(name);
				ApplicationContext.INSTANCE.getItemManager().updateUnit(unit);
				Logger.log(request, "Unit \""+name+"\" was updated");
				Action vAction = new ViewItemUnitsAction();
				vAction.process(request, response);
				return;
			}
		} catch (TransactionException e) {
			e.printStackTrace();
			request.setAttribute("itemUnit", unit);
		}

		request.setAttribute("itemUnitID", "" + itemUnitID);
		action.process(request, response);
	}

}
