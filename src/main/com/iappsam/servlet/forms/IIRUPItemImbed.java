package com.iappsam.servlet.forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class IIRUPItemImber
 */
@WebServlet("/forms/view/IIRUPImbedItems.do")
public class IIRUPItemImbed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPItemImbed() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] itemList = request.getParameterValues("include_1");
		request.getSession().setAttribute("itemList", itemList);
		ArrayList<String> article = new ArrayList<String>();
		ArrayList<String> unitCost = new ArrayList<String>();
		ArrayList<String> propertyNo = new ArrayList<String>();
		ArrayList<String> dateAcquired = new ArrayList<String>();
		try {
			for (int i = 0; i < itemList.length; i++) {
				Item item = ManagerBin.iManager.getItem(Integer.parseInt(itemList[i]));
				article.add(item.getDescription());
				unitCost.add("" + item.getPrice());
				propertyNo.add(item.getPropertyNumber());
				// ------>>>><><<><>
				if (item.getDateAcquired() != null)
					dateAcquired.add("" + item.getDateAcquired().toString());
				else
					dateAcquired.add("");
			}
			request.setAttribute("article", article);
			request.setAttribute("unitCost", unitCost);
			request.setAttribute("propertyNo", propertyNo);
			request.setAttribute("dateAcquired", dateAcquired);

			RequestDispatcher view = request.getRequestDispatcher("/forms/view/IIRUPForm2.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {

		}
	}
}
