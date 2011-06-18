package com.iappsam.util;

import com.iappsam.managers.APPManager;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.sessions.APPManagerSession;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.RISManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.managers.sessions.WMRManagerSession;
import com.iappsam.search.ItemSearcher;

public class ApplicationContext {
	private final PersonManager PERSON_MANAGER = new PersonManagerSession();
	private final AccountManager ACCOUNT_MANAGER = new AccountManagerSession();
	private final ContactManager COUNTACT_MANAGER = new ContactManagerSession();
	private final SupplierManager SUPPLIER_MANAGER = new SupplierManagerSession();
	private final DivisionOfficeManager DIVISION_OFFICE_MANAGER = new DivisionOfficeManagerSession();
	private ItemManager ITEM_MANAGER = new ItemManagerSession();

	// Forms
	private final APPManager APP_MANAGEAR = new APPManagerSession();
	private final PRManager PR_MANAGER = new PRManagerSession();
	private final POManager PO_MANAGER = new POManagerSession();
	private final RISManager RIS_MANAGER = new RISManagerSession();
	private final IIRUPManager IIRUP_MANAGER = new IIRUPManagerSession();
	private final WMRManager WMR_MANAGER = new WMRManagerSession();
	private ItemSearcher ITEM_SEARCHER;

	public static final ApplicationContext INSTANCE = new ApplicationContext();

	private ApplicationContext() {
	}

	public PRManager getPRManager() {
		return PR_MANAGER;
	}

	public PersonManager getPersonManager() {
		return PERSON_MANAGER;
	}

	public AccountManager getAccountManager() {
		return ACCOUNT_MANAGER;
	}

	public ContactManager getContactManager() {
		return COUNTACT_MANAGER;
	}

	public SupplierManager getSupplierManager() {
		return SUPPLIER_MANAGER;
	}

	public DivisionOfficeManager getDivisionOfficeManager() {
		return DIVISION_OFFICE_MANAGER;
	}

	public ItemManager getItemManager() {
		return ITEM_MANAGER;
	}

	public APPManager getAPPManager() {
		return APP_MANAGEAR;
	}

	public POManager getPOManager() {
		return PO_MANAGER;
	}

	public RISManager getRISManager() {
		return RIS_MANAGER;
	}

	public IIRUPManager getIIRUPManager() {
		return IIRUP_MANAGER;
	}

	public WMRManager getWMRManager() {
		return WMR_MANAGER;
	}

	public ItemSearcher getItemSearcher() {
		if (ITEM_SEARCHER == null)
			ITEM_SEARCHER = new ItemSearcher();

		return ITEM_SEARCHER;
	}
}
