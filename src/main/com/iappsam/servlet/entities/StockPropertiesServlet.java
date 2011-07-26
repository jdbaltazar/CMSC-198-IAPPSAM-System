package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

@WebServlet("/stocks")
public class StockPropertiesServlet extends HttpServlet {

	private static final long serialVersionUID = 485171585908096811L;

	public static final String STOCK_PROPERTIES = "/stocks/StockProperties.jsp";
	public static final String STOCK_PROPERTIES_ACTION = "stock-properties-action";
	public static final String VIEW_STOCK_PROPERTIES_ACTION = "view-stock-properties";

	public StockPropertiesServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = parseAction(request);

		if (action != null)
			action.process(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = parseAction(request);

		if (action != null)
			action.process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {

		String action = (String) request.getParameter(STOCK_PROPERTIES_ACTION);

		if (action.equalsIgnoreCase(VIEW_STOCK_PROPERTIES_ACTION))
			return new ViewStockPropertiesAction();

		return null;
	}
}
