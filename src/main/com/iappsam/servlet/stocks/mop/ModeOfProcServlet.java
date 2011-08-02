package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

@WebServlet("/stocks/mode")
public class ModeOfProcServlet extends HttpServlet {

	private static final long serialVersionUID = -8768727199610885812L;

	public static final String VIEW_MODES = "/stocks/modes/ViewModesOfProc.jsp";
	public static final String ADD_MODE = "/stocks/modes/AddModeOfProc.jsp";
	public static final String EDIT_MODE = "/stocks/modes/EditModeOfProc.jsp";

	public static final String MODE_ACTION = "mode-action";

	public static final String VIEW_MODES_ACTION = "view-modes";
	public static final String ADD_MODE_ACTION = "add-mode";
	public static final String EDIT_MODE_ACTION = "edit-mode";
	public static final String SAVE_MODE_ACTION = "save-mode";
	public static final String SAVE_EDITED_MODE_ACTION = "save-edited-mode";

	public ModeOfProcServlet() {
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

		String action = (String) request.getParameter(MODE_ACTION);

		if (action.equalsIgnoreCase(VIEW_MODES_ACTION))
			return new ViewModesAction();
		if (action.equalsIgnoreCase(ADD_MODE_ACTION))
			return new AddModeAction();
		if (action.equalsIgnoreCase(EDIT_MODE_ACTION))
			return new EditModeAction();
		if (action.equalsIgnoreCase(SAVE_MODE_ACTION))
			return new SaveModeAction();
		if (action.equalsIgnoreCase(SAVE_EDITED_MODE_ACTION))
			return new SaveEditedModeAction();

		return null;

	}
}