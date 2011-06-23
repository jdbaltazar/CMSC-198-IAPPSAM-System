package com.iappsam.jetty;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.iappsam.servlet.LoginServlet;
import com.iappsam.servlet.Logout;
import com.iappsam.servlet.Menu;
import com.iappsam.servlet.SearchItemList;
import com.iappsam.servlet.account.AccountCreation;
import com.iappsam.servlet.account.AccountUpdate;
import com.iappsam.servlet.account.AccountsView;
import com.iappsam.servlet.account.UpdateAccount;
import com.iappsam.servlet.account.ViewAccount;
import com.iappsam.servlet.account.ViewWorkInformation;
import com.iappsam.servlet.app.APPLineServlet;
import com.iappsam.servlet.app.APPServlet;
import com.iappsam.servlet.database.BackupDatabase;
import com.iappsam.servlet.entities.AddDivisionOffice;
import com.iappsam.servlet.entities.AddOffice;
import com.iappsam.servlet.entities.AddPurchaseRequest;
import com.iappsam.servlet.entities.DivisionCreation;
import com.iappsam.servlet.entities.EditDivision;
import com.iappsam.servlet.entities.EditOffice;
import com.iappsam.servlet.entities.SaveDivision;
import com.iappsam.servlet.entities.SaveDivisionEdit;
import com.iappsam.servlet.entities.SaveOffice;
import com.iappsam.servlet.entities.SaveOfficeEdit;
import com.iappsam.servlet.entities.SearchDivisions;
import com.iappsam.servlet.entities.ViewDivisionAndOffices;
import com.iappsam.servlet.entities.building.AddBuilding;
import com.iappsam.servlet.entities.building.EditBuilding;
import com.iappsam.servlet.entities.building.SaveEditedBuilding;
import com.iappsam.servlet.entities.building.ViewBuildings;
import com.iappsam.servlet.entities.division.DivisionServlet;
import com.iappsam.servlet.entities.employee.EmployeeCreation;
import com.iappsam.servlet.entities.employee.SearchEmployee;
import com.iappsam.servlet.entities.employee.ViewEmployee;
import com.iappsam.servlet.entities.supplier.SupplierServlet;
import com.iappsam.servlet.forms.iirup.SearchIIRUPForm;
import com.iappsam.servlet.item.ItemServlet;
import com.iappsam.servlet.po.POServlet;
import com.iappsam.servlet.pr.PRLineServlet;
import com.iappsam.servlet.pr.PRServlet;
import com.iappsam.servlet.stocks.disposal.AddDisposal;
import com.iappsam.servlet.stocks.disposal.EditDisposal;
import com.iappsam.servlet.stocks.disposal.SaveEditedDisposal;
import com.iappsam.servlet.stocks.disposal.ViewDisposals;
import com.iappsam.servlet.stocks.itemcategory.AddItemCategory;
import com.iappsam.servlet.stocks.itemcategory.EditItemCategory;
import com.iappsam.servlet.stocks.itemcategory.SaveEditedItemCategory;
import com.iappsam.servlet.stocks.itemcategory.ViewItemCategories;
import com.iappsam.servlet.stocks.itemcondition.AddItemCondition;
import com.iappsam.servlet.stocks.itemcondition.EditItemCondition;
import com.iappsam.servlet.stocks.itemcondition.SaveEditedItemCondition;
import com.iappsam.servlet.stocks.itemcondition.ViewItemConditions;
import com.iappsam.servlet.stocks.itemstatus.AddItemStatus;
import com.iappsam.servlet.stocks.itemstatus.EditItemStatus;
import com.iappsam.servlet.stocks.itemstatus.SaveEditedItemStatus;
import com.iappsam.servlet.stocks.itemstatus.ViewItemStatuses;
import com.iappsam.servlet.stocks.itemunit.AddItemUnit;
import com.iappsam.servlet.stocks.itemunit.EditItemUnit;
import com.iappsam.servlet.stocks.itemunit.SaveEditedItemUnit;
import com.iappsam.servlet.stocks.itemunit.ViewItemUnits;
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
		addServlet(new AddOffice(), "/entities/division/AddOffice.do");
		addServlet(new AddPurchaseRequest(), "/stocks/AddPurchaseRequest.do");
		addServlet(new BackupDatabase(), "/database/backup.sql");
		addServlet(new DivisionCreation(), "/entities/division/divisionCreate.do");
		addServlet(new DivisionServlet(), "/division");
		addServlet(new EditBuilding(), "/entities/building/EditBuilding.do");
		addServlet(new EditDisposal(), "/stocks/stocks/EditDisposal.do");
		addServlet(new EditDivision(), "/entities/division/EditDivision.do");
		addServlet(new EditItemCategory(), "/stocks/stocks/EditItemCategory.do");
		addServlet(new EditItemCondition(), "/stocks/stocks/EditItemCondition.do");
		addServlet(new EditItemStatus(), "/stocks/stocks/EditItemStatus.do");
		addServlet(new EditItemUnit(), "/stocks/stocks/EditItemUnit.do");
		addServlet(new EditModeOfProcurement(), "/stocks/stocks/EditModeOfProcurement.do");
		addServlet(new EditOffice(), "/entities/division/EditOffice.do");
		addServlet(new EmployeeCreation(), "/entities/employees/CreateEmployee.do");
		addServlet(new APPLineServlet(), "/app/line");
		addServlet(new PRLineServlet(), "/pr/line");
		addServlet(new APPServlet(), "/app");
		addServlet(new POServlet(), "/po");
		addServlet(new PRServlet(), "/pr");
		addServlet(new ItemServlet(), "/items");
		addServlet(new LoginServlet(), "/login");
		addServlet(new Logout(), "/logout");
		addServlet(new Menu(), "/menu");
		addServlet(new SaveDivision(), "/entities/division/SaveDivision.do");
		addServlet(new SaveDivisionEdit(), "/entities/division/SaveDivisionEdit.do");
		addServlet(new SaveEditedBuilding(), "/entities/building/SaveEditedBuilding.do");
		addServlet(new SaveEditedDisposal(), "/stocks/stocks/SaveEditedDisposal.do");
		addServlet(new SaveEditedItemCategory(), "/stocks/stocks/SaveEditedItemCategory.do");
		addServlet(new SaveEditedItemCondition(), "/stocks/stocks/SaveEditedItemCondition.do");
		addServlet(new SaveEditedItemStatus(), "/stocks/stocks/SaveEditedItemStatus.do");
		addServlet(new SaveEditedItemUnit(), "/stocks/stocks/SaveEditedItemUnit.do");
		addServlet(new SaveEditedModeOfProc(), "/stocks/stocks/SaveEditedModeOfProc.do");
		addServlet(new SaveOffice(), "/entities/division/SaveOffice.do");
		addServlet(new SaveOfficeEdit(), "/entities/division/SaveOfficeEdit.do");
		addServlet(new SearchDivisions(), "/entities/division/SearchDivisions.do");
		addServlet(new SearchEmployee(), "/entities/employees/SearchEmployee.do");
		addServlet(new SearchIIRUPForm(), "/forms/iirup/SearchIIRUPForm.do");
		addServlet(new SearchItemList(), "/forms/iirup/SearchIIRUPItemList.do");
		addServlet(new SupplierServlet(), "/supplier");
		addServlet(new UpdateAccount(), "/accounts/viewing/update_account.do");
		addServlet(new ViewAccount(), "/accounts/viewing/ViewAccount.do");
		addServlet(new ViewBuildings(), "/entities/building/ViewBuildings.do");
		addServlet(new ViewDisposals(), "/stocks/stocks/ViewDisposals.do");
		addServlet(new ViewDivisionAndOffices(), "/entities/division/ViewDivisionAndOffices.do");
		addServlet(new ViewEmployee(), "/entities/employees/ViewEmployee.do");
		addServlet(new ViewItemCategories(), "/stocks/stocks/ViewItemCategories.do");
		addServlet(new ViewItemConditions(), "/stocks/stocks/ViewItemConditions.do");
		addServlet(new ViewItemStatuses(), "/stocks/stocks/ViewItemStatuses.do");
		addServlet(new ViewItemUnits(), "/stocks/stocks/ViewItemUnits.do");
		addServlet(new ViewModesOfProcurement(), "/stocks/stocks/ViewModesOfProcurement.do");
		addServlet(new ViewWorkInformation(), "/accounts/viewing/ViewWorkInformation");

		server.setHandler(context);
		server.start();
		server.join();
	}

	private static void addServlet(Servlet servlet, String path) {
		context.addServlet(new ServletHolder(servlet), path);
	}
}
