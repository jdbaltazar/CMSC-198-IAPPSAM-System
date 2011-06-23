package com.iappsam.jetty;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.Menu;
import com.iappsam.servlet.account.AccountCreation;
import com.iappsam.servlet.account.AccountUpdate;
import com.iappsam.servlet.account.AccountsView;
import com.iappsam.servlet.entities.AddDivisionOffice;
import com.iappsam.servlet.entities.building.AddBuilding;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.pr.PRLineServlet;
import com.iappsam.servlet.pr.PRServlet;
import com.iappsam.servlet.stocks.disposal.AddDisposal;
import com.iappsam.servlet.stocks.itemcategory.AddItemCategory;
import com.iappsam.servlet.stocks.itemcondition.AddItemCondition;
import com.iappsam.servlet.stocks.itemstatus.AddItemStatus;
import com.iappsam.servlet.stocks.itemunit.AddItemUnit;
import com.iappsam.servlet.stocks.mop.AddModeOfProcurement;

public class WebServer {

	private static WebAppContext context;

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		context = new WebAppContext();
		context.setResourceBase("webapp");
		context.setParentLoaderPriority(true);

		addServlet(new LoginServlet(), "/login");
		addServlet(new ItemServlet(), "/items");
		addServlet(new PRServlet(), "/pr");
		addServlet(new PRLineServlet(), "/pr/line");
		addServlet(new Menu(), "/menu");
		addServlet(new AccountCreation(), "/accounts/CreateAccount.do");
		addServlet(new AccountsView(), "/accounts/ViewAccounts.do");
		addServlet(new AccountUpdate(), "/AccountUpdate");
		addServlet(new AddBuilding(), "/entities/building/AddBuilding.do");
		addServlet(new AddDisposal(), "/stocks/stocks/AddDisposal.do");
		addServlet(new AddDivisionOffice(), "/divisions/AddDivisionOffice.do");
		addServlet(new AddItemCategory(), "/stocks/stocks/AddItemCategory.do");
		addServlet(new AddItemCondition(), "/stocks/stocks/AddItemCondition.do");
		addServlet(new AddItemStatus(), "/stocks/stocks/AddItemStatus.do");
		addServlet(new AddItemUnit(), "/stocks/stocks/AddItemUnit.do");
		addServlet(new AddModeOfProcurement(), "/stocks/stocks/AddModeOfProc.do");

		server.setHandler(context);

		server.start();
		server.join();
	}

	private static void addServlet(Servlet servlet, String path) {
		context.addServlet(new ServletHolder(servlet), path);
	}
}
