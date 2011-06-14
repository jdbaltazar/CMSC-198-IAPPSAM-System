package com.iappsam.servlet.forms.iirup;

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
import com.iappsam.util.Managers;

/**
 * Servlet implementation class IIRUPItemImber
 */
@WebServlet("/forms/iirup/IIRUPRemoveItem.do")
public class IIRUPItemRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IIRUPItemRemove() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] itemList1 = request.getParameterValues("include1");
		ArrayList<String> itemList = (ArrayList<String>) request.getSession()
				.getAttribute("itemList");
		for(int i=0;i<itemList1.length;i++){
			itemList.remove(itemList1[i]);
		}
		ArrayList<String> article = new ArrayList<String>();
		ArrayList<String> unitCost = new ArrayList<String>();
		ArrayList<String> propertyNo = new ArrayList<String>();
		ArrayList<String> dateAcquired = new ArrayList<String>();
		try {
			for (int i = 0; i < itemList.size(); i++) {

				Item item = Managers.INSTANCE.getItemManager().getItem(Integer
						.parseInt(itemList.get(i)));
				article.add(item.getDescription());
				unitCost.add("" + item.getPrice());
				propertyNo.add(item.getPropertyNumber());
				if (item.getDateAcquired() != null)
					dateAcquired.add("" + item.getDateAcquired().toString());
				else
					dateAcquired.add("");
			}
			request.getSession().setAttribute("itemList", itemList);
			request.setAttribute("article", article);
			request.setAttribute("unitCost", unitCost);
			request.setAttribute("propertyNo", propertyNo);
			request.setAttribute("dateAcquired", dateAcquired);
			RequestDispatcher view = request
					.getRequestDispatcher("/forms/iirup/IIRUPForm2.jsp");
			view.forward(request, response);
		} catch (TransactionException e) {

		}
	}
}
