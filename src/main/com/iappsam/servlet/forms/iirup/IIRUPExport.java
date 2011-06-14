package com.iappsam.servlet.forms.iirup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.IIRUP;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.Managers;

/**
 * Servlet implementation class IIRUPExport
 */
@WebServlet(name = "IIRUPExport.do", urlPatterns = { "/forms/iirup/IIRUPExport.do" })
public class IIRUPExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IIRUPExport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iirup = (String)request.getAttribute("iirupID");
		int iirupID = Integer.parseInt(iirup);
		String iirupExport = request.getParameter("exportType");
		try {
			IIRUP iirupForm = Managers.IIRUP_MANAGER.getIIRUP(iirupID);
			if(iirupExport.equalsIgnoreCase("pdf")){
				System.out.println("Will export to pdf");
				//PDF Export area use{
				
				//}	
			}
			if(iirupExport.equalsIgnoreCase("exce;l")){
				System.out.println("Will export to excel");
				//Excel Export area use{
				
				//}	
			}
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("SearchIIRUPForm.do");
		view.forward(request, response);
	}

}
