package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Unit;
import com.iappsam.logging.Logger;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.util.Validator;

public class SaveItemUnitAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		Unit unit = new Unit();

		RequestDispatcher add = request.getRequestDispatcher(ItemUnitServlet.ADD_ITEM_UNIT);
		String unitInput = request.getParameter("itemUnit").trim();
		if (Validator.validField(unitInput)) {
			unit.setName(unitInput);
			try {
				itemManager.addUnit(unit);
				Logger.log(request, "Unit \""+unitInput+"\" was added");
				Action vUnits = new ViewItemUnitsAction();
				vUnits.process(request, response);
				return;
			} catch (TransactionException e) {
				e.printStackTrace();
			}
		}
		add.forward(request, response);
	}

}
