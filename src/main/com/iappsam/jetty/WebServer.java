package com.iappsam.jetty;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.Logout;
import com.iappsam.servlet.Menu;
import com.iappsam.servlet.SearchItemList;
import com.iappsam.servlet.account.AccountCreation;
import com.iappsam.servlet.account.AccountCreationForExistingEmployee;
import com.iappsam.servlet.account.AccountUpdate;
import com.iappsam.servlet.account.AccountsView;
import com.iappsam.servlet.account.UpdateAccount;
import com.iappsam.servlet.account.ViewAccount;
import com.iappsam.servlet.account.ViewWorkInformation;
import com.iappsam.servlet.app.APPLineServlet;
import com.iappsam.servlet.app.APPServlet;
import com.iappsam.servlet.database.BackupDatabase;
import com.iappsam.servlet.entities.StockPropertiesServlet;
import com.iappsam.servlet.entities.building.AddBuilding;
import com.iappsam.servlet.entities.building.EditBuilding;
import com.iappsam.servlet.entities.building.SaveEditedBuilding;
import com.iappsam.servlet.entities.building.ViewBuildings;
import com.iappsam.servlet.entities.division.AddDivisionOffice;
import com.iappsam.servlet.entities.division.AddOffice;
import com.iappsam.servlet.entities.division.DivisionCreation;
import com.iappsam.servlet.entities.division.DivisionServlet;
import com.iappsam.servlet.entities.division.EditDivision;
import com.iappsam.servlet.entities.division.EditOffice;
import com.iappsam.servlet.entities.division.SaveDivision;
import com.iappsam.servlet.entities.division.SaveDivisionEdit;
import com.iappsam.servlet.entities.division.SaveOffice;
import com.iappsam.servlet.entities.division.SaveOfficeEdit;
import com.iappsam.servlet.entities.division.SearchDivisions;
import com.iappsam.servlet.entities.division.ViewDivisionAndOffices;
import com.iappsam.servlet.entities.employee.EmployeeCreation;
import com.iappsam.servlet.entities.employee.EmployeeUpdate;
import com.iappsam.servlet.entities.employee.SearchEmployee;
import com.iappsam.servlet.entities.supplier.SupplierServlet;
import com.iappsam.servlet.filter.SecurityFilter;
import com.iappsam.servlet.forms.iirup.SearchIIRUPForm;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.po.POServlet;
import com.iappsam.servlet.pr.AddPurchaseRequest;
import com.iappsam.servlet.pr.PRLineServlet;
import com.iappsam.servlet.pr.PRServlet;
import com.iappsam.servlet.ris.RISLineServlet;
import com.iappsam.servlet.ris.RISServlet;
import com.iappsam.servlet.stocks.disposal.DisposalServlet;
import com.iappsam.servlet.stocks.itemcategory.ItemCategoryServlet;
import com.iappsam.servlet.stocks.itemcondition.ItemConditionServlet;
import com.iappsam.servlet.stocks.itemstatus.ItemStatusServlet;
import com.iappsam.servlet.stocks.itemunit.ItemUnitServlet;
import com.iappsam.servlet.stocks.mop.AddModeOfProcurement;
import com.iappsam.servlet.stocks.mop.EditModeOfProcurement;
import com.iappsam.servlet.stocks.mop.SaveEditedModeOfProc;
import com.iappsam.servlet.stocks.mop.ViewModesOfProcurement;

public class WebServer {

	private static WebAppContext context;

	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		context = new WebAppContext();
		context.setResourceBase("webapp");
		context.setParentLoaderPriority(true);

		addServlet(new AccountCreation(), "/accounts/CreateAccount.do");
		addServlet(new AccountCreationForExistingEmployee(), "/accounts/create-account-for-employee.do");
		addServlet(new AccountsView(), "/accounts/ViewAccounts.do");
		addServlet(new AccountUpdate(), "/entities/employees/update_account.do");
		addServlet(new AddBuilding(), "/entities/building/AddBuilding.do");
		addServlet(new AddDivisionOffice(), "/divisions/AddDivisionOffice.do");
		addServlet(new AddModeOfProcurement(), "/stocks/stocks/AddModeOfProc.do");
		addServlet(new AddOffice(), "/entities/division/AddOffice.do");
		addServlet(new AddPurchaseRequest(), "/stocks/AddPurchaseRequest.do");
		addServlet(new APPLineServlet(), "/app/line");
		addServlet(new APPServlet(), "/app");
		addServlet(new BackupDatabase(), "/database/backup.sql");
		addServlet(new DivisionCreation(), "/entities/division/divisionCreate.do");
		addServlet(new DivisionServlet(), "/division");
		addServlet(new EditBuilding(), "/entities/building/EditBuilding.do");
		addServlet(new EditDivision(), "/entities/division/EditDivision.do");
		addServlet(new EditModeOfProcurement(), "/stocks/stocks/EditModeOfProcurement.do");
		addServlet(new EditOffice(), "/entities/division/EditOffice.do");
		addServlet(new EmployeeCreation(), "/entities/employees/add_employee.do");
		addServlet(new EmployeeUpdate(), "/entities/employees/update_employee.do");
		addServlet(new ItemServlet(), "/items");
		addServlet(new LoginServlet(), "/login");
		addServlet(new Logout(), "/logout");
		addServlet(new Menu(), "/menu");
		addServlet(new PRLineServlet(), "/pr/line");
		addServlet(new POServlet(), "/po");
		addServlet(new PRServlet(), "/pr");
		addServlet(new RISServlet(), "/ris");
		addServlet(new RISLineServlet(), "/ris/line");
		addServlet(new SaveDivision(), "/entities/division/SaveDivision.do");
		addServlet(new SaveDivisionEdit(), "/entities/division/SaveDivisionEdit.do");
		addServlet(new SaveEditedBuilding(), "/entities/building/SaveEditedBuilding.do");
		addServlet(new SaveEditedModeOfProc(), "/stocks/stocks/SaveEditedModeOfProc.do");
		addServlet(new SaveOffice(), "/entities/division/SaveOffice.do");
		addServlet(new SaveOfficeEdit(), "/entities/division/SaveOfficeEdit.do");
		addServlet(new SearchDivisions(), "/entities/division/SearchDivisions.do");
		addServlet(new SearchEmployee(), "/entities/employees/search_employee.do");
		addServlet(new SearchIIRUPForm(), "/forms/iirup/SearchIIRUPForm.do");
		addServlet(new SearchItemList(), "/forms/iirup/SearchIIRUPItemList.do");
		addServlet(new StockPropertiesServlet(), "/stocks");
		addServlet(new DisposalServlet(), "/stocks/disposal");
		addServlet(new ItemCategoryServlet(), "/stocks/item-cat");
		addServlet(new ItemConditionServlet(), "/stocks/item-cond");
		addServlet(new ItemStatusServlet(), "/stocks/item-stat");
		addServlet(new ItemUnitServlet(), "/stocks/item-unit");
		addServlet(new SupplierServlet(), "/supplier");
		addServlet(new UpdateAccount(), "/accounts/update_account.do");
		addServlet(new ViewAccount(), "/accounts/viewing/ViewAccount.do");
		addServlet(new ViewBuildings(), "/entities/building/ViewBuildings.do");
		addServlet(new ViewDivisionAndOffices(), "/entities/division/ViewDivisionAndOffices.do");
		addServlet(new ViewModesOfProcurement(), "/stocks/stocks/ViewModesOfProcurement.do");
		addServlet(new ViewWorkInformation(), "/accounts/viewing/ViewWorkInformation");

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
