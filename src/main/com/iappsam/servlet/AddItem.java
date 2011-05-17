package com.iappsam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/stocks/AddItem.do")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItem() {
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
		ItemManager iManager = new ItemManagerSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("items/AddItem.jsp");
		try {
			List<Unit> units = iManager.getAllUnits();
			List<ItemStatus> itemStatus = iManager.getAllItemStatus();
			List<ItemCondition> itemCondition = iManager.getAllItemCondition();
			ArrayList<String> unitList = new ArrayList<String>();
			ArrayList<String> itemStatusList=new ArrayList<String>();
			ArrayList<String> itemConditionList = new ArrayList<String>();
			for (int i = 0; i < units.size(); i++) {
				unitList.add(units.get(i).getUnit());
			}
			for(int i=0;i<itemStatus.size();i++){
				itemStatusList.add(itemStatus.get(i).getItemStatus());
			}
			for(int i=0;i<itemCondition.size();i++){
				itemConditionList.add(itemCondition.get(i).getItemCondition());
			}

			request.setAttribute("unitList", unitList);
			request.setAttribute("itemConditionList", itemConditionList);
			request.setAttribute("itemStatusList", itemStatusList);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestDispatcher.forward(request, response);
	}

}
