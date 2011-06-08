package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Item;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

/**
 * Servlet implementation class PRItemImbed
 */
@WebServlet("/forms/purchase_request/pr_imbed_item.do")
public class PRItemImbed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PRItemImbed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] itemList = request.getParameterValues("include1");
		if (itemList == null) {
			RequestDispatcher view = request.getRequestDispatcher("/forms/iirup/IIRUPForm2.jsp");
			view.forward(request, response);
			return;
		}
		DivisionOffice station = (DivisionOffice) request.getSession().getAttribute("station");
		System.out.println("Station:  " + station.getDivisionName()+"/"+station.getOfficeName());
		ArrayList<String> trueItemList = (ArrayList<String>) request.getSession().getAttribute("itemList");
		if (trueItemList == null || trueItemList.isEmpty()) {
			trueItemList = new ArrayList<String>();
		}

		ArrayList<String> article = new ArrayList<String>();
		ArrayList<String> unitCost = new ArrayList<String>();
		ArrayList<String> propertyNo = new ArrayList<String>();
		ArrayList<String> dateAcquired = new ArrayList<String>();
		try {
			for (int i = 0; i < itemList.length; i++) {
				Item item = Managers.ITEM_MANAGER.getItem(Integer.parseInt(itemList[i]));
				if (trueItemList.contains(itemList[i]))
					continue;

				trueItemList.add(itemList[i]);

			}

			for (int i = 0; i < trueItemList.size(); i++) {
				Item item = Managers.ITEM_MANAGER.getItem(Integer.parseInt(trueItemList.get(i)));

				article.add(item.getDescription());
				unitCost.add("" + item.getPrice());
				propertyNo.add(item.getPropertyNumber());
				if (item.getDateAcquired() != null)
					dateAcquired.add("" + item.getDateAcquired().toString());
				else
					dateAcquired.add("");
			}

			request.getSession().setAttribute("itemList", trueItemList);
			request.setAttribute("article", article);
			request.setAttribute("unitCost", unitCost);
			request.setAttribute("propertyNo", propertyNo);
			request.setAttribute("dateAcquired", dateAcquired);
			RequestDispatcher view = request.getRequestDispatcher("pr_form_2.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {

		}
	}

}
