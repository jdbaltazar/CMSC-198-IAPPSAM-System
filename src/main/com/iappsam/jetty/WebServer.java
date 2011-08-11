package com.iappsam.jetty;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.LogoutServlet;
import com.iappsam.servlet.MenuServlet;
import com.iappsam.servlet.SearchItemList;
import com.iappsam.servlet.account.AccountServlet;
import com.iappsam.servlet.app.APPLineServlet;
import com.iappsam.servlet.app.APPServlet;
import com.iappsam.servlet.database.BackupDatabase;
import com.iappsam.servlet.entities.StockPropertiesServlet;
import com.iappsam.servlet.entities.building.BuildingServlet;
import com.iappsam.servlet.entities.division.DivisionOfficeServlet;
import com.iappsam.servlet.entities.employee.EmployeeServlet;
import com.iappsam.servlet.entities.supplier.SupplierServlet;
import com.iappsam.servlet.filter.SecurityFilter;
import com.iappsam.servlet.forms.iirup.SearchIIRUPForm;
import com.iappsam.servlet.ie.IELineServlet;
import com.iappsam.servlet.ie.IEServlet;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.po.POLineServlet;
import com.iappsam.servlet.po.POServlet;
import com.iappsam.servlet.pr.PRLineServlet;
import com.iappsam.servlet.pr.PRServlet;
import com.iappsam.servlet.ris.RISLineServlet;
import com.iappsam.servlet.ris.RISServlet;
import com.iappsam.servlet.stocks.disposal.DisposalServlet;
import com.iappsam.servlet.stocks.itemcategory.ItemCategoryServlet;
import com.iappsam.servlet.stocks.itemcondition.ItemConditionServlet;
import com.iappsam.servlet.stocks.itemstatus.ItemStatusServlet;
import com.iappsam.servlet.stocks.itemunit.ItemUnitServlet;
import com.iappsam.servlet.stocks.mop.ModeOfProcServlet;
import com.iappsam.servlet.systemlog.ViewSystemLogs;

public class WebServer {

	private static WebAppContext context;

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);	

		context = new WebAppContext();
		context.setWar("webapp");

		addServlet(new AccountServlet(), "/accounts");
		addServlet(new BuildingServlet(), "/building");
		addServlet(new DivisionOfficeServlet(), "/division-office");
		addServlet(new EmployeeServlet(), "/employee");
		addServlet(new APPLineServlet(), "/app/line");
		addServlet(new APPServlet(), "/app");
		addServlet(new BackupDatabase(), "/database/backup.sql");
		addServlet(new IEServlet(), "/ie");
		addServlet(new IELineServlet(), "/ie/line");
		addServlet(new ItemServlet(), "/items");
		addServlet(new LoginServlet(), "/login");
		addServlet(new LogoutServlet(), "/logout");
		addServlet(new MenuServlet(), "/menu");
		addServlet(new PRLineServlet(), "/pr/line");
		addServlet(new POServlet(), "/po");
		addServlet(new PRServlet(), "/pr");
		addServlet(new RISServlet(), "/ris");
		addServlet(new POLineServlet(), "/po/line");
		addServlet(new RISLineServlet(), "/ris/line");
		addServlet(new SearchIIRUPForm(), "/forms/iirup/SearchIIRUPForm.do");
		addServlet(new SearchItemList(), "/forms/iirup/SearchIIRUPItemList.do");
		addServlet(new StockPropertiesServlet(), "/stocks");
		addServlet(new DisposalServlet(), "/stocks/disposal");
		addServlet(new ItemCategoryServlet(), "/stocks/item-cat");
		addServlet(new ItemConditionServlet(), "/stocks/item-cond");
		addServlet(new ItemStatusServlet(), "/stocks/item-stat");
		addServlet(new ItemUnitServlet(), "/stocks/item-unit");
		addServlet(new ModeOfProcServlet(), "/stocks/mode");
		addServlet(new SupplierServlet(), "/supplier");
		addServlet(new ViewSystemLogs(), "/system-logs");

		addFilter(new SecurityFilter(), "/*");
		server.setHandler(context);
		server.start();
		server.join();
	}

	private static void addServlet(Servlet servlet, String path) {
		context.addServlet(new ServletHolder(servlet), path);
	}

	private static void addFilter(Filter filter, String path) {
		EnumSet<DispatcherType> dispatches = null;
		context.addFilter(SecurityFilter.class, path, dispatches);
	}
}
