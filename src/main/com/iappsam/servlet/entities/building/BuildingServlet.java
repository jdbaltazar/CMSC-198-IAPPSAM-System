package com.iappsam.servlet.entities.building;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

/**
 * Servlet implementation class BuildingServlet
 */
@WebServlet("/building")
public class BuildingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6524025640333074089L;

	public static final String VIEW_BUILDINGS = "/entities/building/ViewBuildings.jsp";
	public static final String ADD_BUILDING = "/entities/building/AddBuilding.jsp";
	public static final String EDIT_BUILDING = "/entities/building/EditBuilding.jsp";

	public static final String BUILDING_ACTION = "building-action";

	public static final String VIEW_BUILDINGS_ACTION = "view-buildings";
	public static final String ADD_BUILDING_ACTION = "add-building";
	public static final String EDIT_BUILDING_ACTION = "edit-building";
	public static final String SAVE_BUILDING_ACTION = "save-building";
	public static final String SAVE_EDITED_BUILDING_ACTION = "save-edited-building";

	public BuildingServlet() {
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

		String action = request.getParameter(BUILDING_ACTION);

		if (action.equalsIgnoreCase(VIEW_BUILDINGS_ACTION))
			return new ViewBuildingsAction();
		if (action.equalsIgnoreCase(ADD_BUILDING_ACTION))
			return new AddBuildingAction();
		if (action.equalsIgnoreCase(EDIT_BUILDING_ACTION))
			return new EditBuildingAction();
		if (action.equalsIgnoreCase(SAVE_BUILDING_ACTION))
			return new SaveBuildingAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_BUILDING_ACTION))
			return new SaveEditedBuildingAction();

		return null;
	}
}
