package com.iappsam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Account;
import com.iappsam.AccountType;
import com.iappsam.util.Cleaner;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8715294359026881395L;

	public static final String MENU_FOR_SPSO_PERSONNEL = "menu.jsp";
	public static final String MENU_FOR_SYSTEM_ADMIN = "menu-sysadmin.jsp";
	public static final String MENU_FOR_TYPICAL_USER = "menu-typicaluser.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// String username = (String) request.getAttribute("username");
		// request.setAttribute("username", username);

		//AccountType type = ((Account) request.getSession().getAttribute("account")).getType();

		//if (type == AccountType.SPSO_PERSONNEL)
			request.getRequestDispatcher(MENU_FOR_SPSO_PERSONNEL).forward(request, response);
		//else if (type == AccountType.SYSTEM_ADMIN)
		//	request.getRequestDispatcher(MENU_FOR_SYSTEM_ADMIN).forward(request, response);
		//else
		//	request.getRequestDispatcher(MENU_FOR_TYPICAL_USER).forward(request, response);
	}
}
