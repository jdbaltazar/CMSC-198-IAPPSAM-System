package com.iappsam.servlet.forms.iirup;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.IIRUP;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.IIRUPSearcher;
import com.iappsam.util.ApplicationContext;

/**
 * Servlet implementation class SearchIIRUPForm
 */
@WebServlet("/forms/iirup/SearchIIRUPForm.do")
public class SearchIIRUPForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchIIRUPForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchField");
		if (query != null && !query.isEmpty()) {
			IIRUPSearcher searcher = new IIRUPSearcher();
			List<IIRUP> iirupList = searcher.search(query);
			request.setAttribute("iirupList", iirupList);
		} else {
			try {
				request.setAttribute("iirupList", ApplicationContext.INSTANCE.getIIRUPManager().getAllIIRUP());
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		RequestDispatcher view = request.getRequestDispatcher("SearchIIRUPForm.jsp");
		view.forward(request, response);
	}

}
