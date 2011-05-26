package com.iappsam.servlet.stocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

@WebServlet("/stocks/stocks/SearchAllItemCategories.do")
public class SearchAllItemCategories extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7700104491260715251L;

	public SearchAllItemCategories(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemManager itemManager = new ItemManagerSession();
		RequestDispatcher view = request.getRequestDispatcher("../../stocks/stocks/category/ViewItemCategories.jsp");
		
		ArrayList<String> itemCategory = new ArrayList<String>();
		
		List<ItemCategory> categories = new ArrayList<ItemCategory>();
		
		try {
			categories = itemManager.getAllItemCategory();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ItemCategory ic: categories){
			itemCategory.add(ic.getName());
		}
		
		request.setAttribute("itemCategory", itemCategory);
		
		view.forward(request, response);
	}
}
