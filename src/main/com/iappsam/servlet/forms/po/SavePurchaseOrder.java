package com.iappsam.servlet.forms.po;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.Supplier;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;

@WebServlet("/forms/savePurchaseOrder")
public class SavePurchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SavePurchaseOrder() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonManager pManager = new PersonManagerSession();
		DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
		SupplierManager sManager = new SupplierManagerSession();
		POManager poManager = new POManagerSession();
		ItemManager iManager = new ItemManagerSession();

		// required
		String supplierName = "";
		String poNumber = "";
		Date dateAccomplished = new Date(0);
		String modeOfProcurementName = "";
		String divisionName = "", officeName = "";
		Date dateOfDelivery = new Date(0);
		String totalAmountInWords = "";
		String supplierContactName = "";
		String supplierContactDesignation = "";
		String deanName = "";
		String deanDesignation = "";
		String accountantName = "";
		String accountantDesignation = "";
		ArrayList<String> itemIDs = new ArrayList<String>();

		// not required
		String paymentTerm = "";
		String deliveryTerm = "";
		String orNumber = "";
		long amount = 0;

		try {

			// get methods can be used with ids
			Supplier supplier = sManager.getSupplier(supplierName);
			ModeOfProcurement mop = poManager.getModeOfProcurement(modeOfProcurementName);
			DivisionOffice dOffice = doManager.getDivisionOffice(divisionName, officeName);
			Employee supplierEmployee = pManager.getEmployee(supplierContactName, supplierContactDesignation);
			Employee dean = pManager.getEmployee(deanName, deanDesignation);
			Employee accountant = pManager.getEmployee(accountantName, accountantDesignation);

			Signatory supplierSignatory = new Signatory("Conforme", supplierEmployee);
			Signatory deanSignatory = new Signatory("Very truly yours", dean);
			Signatory accountantSignatory = new Signatory("Funds Available", accountant);

			pManager.addSignatory(supplierSignatory);
			pManager.addSignatory(deanSignatory);
			pManager.addSignatory(accountantSignatory);

			if (validInputs(supplierName, poNumber, dateAccomplished, mop.getId(), divisionName, officeName, dateOfDelivery, totalAmountInWords, supplierContactName, supplierContactDesignation,
					deanName, deanDesignation, accountantName, accountantDesignation, itemIDs, amount)) {

//				PurchaseOrder po = new PurchaseOrder(supplier.getId(), poNumber, dateAccomplished, mop.getId(), dOffice.getId(), dateOfDelivery, paymentTerm, deliveryTerm, totalAmountInWords,
//						orNumber, amount, supplierSignatory.getId(), deanSignatory.getId(), accountantSignatory.getId());
//				poManager.addPO(po);

				// poLines

				for (String itemID : itemIDs) {
					Item item = iManager.getItem(Integer.parseInt(itemID));
					if (item != null) {
//						PurchaseOrderLine poLine = new PurchaseOrderLine(item.getId(), po.getPoNumber());
						// poManager.addLine(poLine);
					}
				}
			}
		} catch (TransactionException e) {
			e.printStackTrace();
		}

	}

	ArrayList<String> itemIDs = new ArrayList<String>();

	private boolean validInputs(String supplierName, String poNumber, Date dateAccomplished, int modeOfProcurementID, String divisionName, String officeName, Date dateOfDelivery,
			String totalAmountInWords, String supplierContactName, String supplierContactDesignation, String deanName, String deanDesignation, String accountantName, String accountantDesignation,
			ArrayList<String> itemIDs, long amount) {
		if (!validInput(supplierName))
			return false;
		if (!validInput(poNumber))
			return false;
		if (!validDate(dateAccomplished))
			return false;
		if (modeOfProcurementID < 1)
			return false;
		if (!validInput(divisionName))
			return false;
		if (!validInput(officeName))
			return false;
		if (!validDate(dateOfDelivery))
			return false;
		if (!validInput(totalAmountInWords))
			return false;
		if (!validInput(supplierContactName))
			return false;
		if (!validInput(supplierContactDesignation))
			return false;
		if (!validInput(deanName))
			return false;
		if (!validInput(deanDesignation))
			return false;
		if (!validInput(accountantName))
			return false;
		if (!validInput(accountantDesignation))
			return false;
		for (String id : itemIDs) {
			try {
				if (!validInput(id))
					return false;
				Integer.parseInt(id);
			} catch (Exception e) {
				return false;
			}
		}
		if (amount < 0)
			return false;
		return true;
	}

	private boolean validInput(String s) {
		if (s == null)
			return false;
		if (s.equals(""))
			return false;
		return true;
	}

	private boolean validDate(Date date) {
		if (date != null)
			return true;
		return false;
	}

}
