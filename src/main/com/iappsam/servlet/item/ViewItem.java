package com.iappsam.servlet.item;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.util.DateUtil;

@WebServlet("/items/ViewItem.do")
public class ViewItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewItem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("view item was called!!!");


		ItemManager iManager = new ItemManagerSession();
		String description = (String) request.getParameter("description");

		System.out.println("item description: " + description);

		Item item = null;
		try {
			item = iManager.getItemByDescription(description);
		} catch (TransactionException e1) {
			e1.printStackTrace();
		}

		if (item != null) {

			request.setAttribute("item", item);

			if (item.getDateAcquired() != null) {
				Date date = item.getDateAcquired();
				String day = DateUtil.getDayEquivalent(date);
				String month = DateUtil.getMonthEquivalentInWords(date);
				String year = DateUtil.getYearEquivalent(date);

				System.out.println("vvvvvvvvvvvvvvvvvvvvvvvviiiiiiiiiiiiiiiiiiiiewwwwwwwwwwwwwwwwwwwww");

				System.out.println("day:month:year>" + day + ":" + month + ":" + year);

				request.setAttribute("day", day);
				request.setAttribute("month", month);
				request.setAttribute("year", year);
			}

		} else {

			System.out.println("item is NULLLLLLLLLLLLLLLL");
		}
		RequestDispatcher view = request.getRequestDispatcher("../stocks/items/ViewItem.jsp");
		view.forward(request, response);

	}

}
