package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

@WebServlet("/stocks/item-status")
public class ItemStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 8743386494034832467L;

	public static final String VIEW_ITEM_STATS = "/stocks/item_stats/ViewItemStatuses.jsp";
	public static final String ADD_ITEM_STAT = "/stocks/item_stats/AddItemStatus.jsp";
	public static final String EDIT_ITEM_STAT = "/stocks/item_stats/EditItemStatus.jsp";

	public static final String ITEM_STAT_ACTION = "item-stat-action";

	public static final String VIEW_ITEM_STATS_ACTION = "view-item-stats";
	public static final String ADD_ITEM_STAT_ACTION = "add-item-stat";
	public static final String EDIT_ITEM_STAT_ACTION = "edit-item-stat";
	public static final String SAVE_ITEM_STAT_ACTION = "save-item-stat";
	public static final String SAVE_EDITED_ITEM_STAT_ACTION = "save-edited-item-stat";

	public ItemStatusServlet() {
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

		String action = request.getParameter(ITEM_STAT_ACTION);

		if (action.equalsIgnoreCase(VIEW_ITEM_STATS_ACTION))
			return new ViewItemStatsAction();
		if (action.equalsIgnoreCase(ADD_ITEM_STAT_ACTION))
			return new AddItemStatAction();
		if (action.equalsIgnoreCase(EDIT_ITEM_STAT_ACTION))
			return new EditItemStatAction();
		if (action.equalsIgnoreCase(SAVE_ITEM_STAT_ACTION))
			return new SaveItemStatAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_ITEM_STAT_ACTION))
			return new SaveEditedItemStatAction();

		return null;

	}
}