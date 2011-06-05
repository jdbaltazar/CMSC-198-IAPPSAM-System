package com.iappsam.servlet.stocks.mop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ManagerBin;

/**
 * Servlet implementation class EditModeOfProcurement
 */
@WebServlet("/stocks/stocks/EditModeOfProcurement.do")
public class EditModeOfProcurement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditModeOfProcurement() {
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
		// TODO Auto-generated method stub
		
		System.out.println(".........inside editmop.java");
		int mopID = Integer.parseInt((String)request.getParameter("mopID"));
		ModeOfProcurement mop= new ModeOfProcurement();
		RequestDispatcher edit = request.getRequestDispatcher("EditModeOfProc.jsp");
		try {
			mop = ManagerBin.poManager.getModeOfProcurement(mopID);
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("mop", mop);
		edit.forward(request, response);
	}

}
