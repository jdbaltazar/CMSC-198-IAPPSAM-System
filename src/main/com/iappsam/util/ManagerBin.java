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

public class ManagerBin {
	public static PersonManager pManager = new PersonManagerSession();
	public static AccountManager aManager = new AccountManagerSession();
	public static ContactManager cManager = new ContactManagerSession();
	public static SupplierManager sManager = new SupplierManagerSession();
	public static DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
	public static ItemManager iManager = new ItemManagerSession();

	// Forms
	public static APPManager appManager = new APPManagerSession();
	public static PRManager prManager = new PRManagerSession();
	public static POManager poManager = new POManagerSession();
	public static RISManager risManager = new RISManagerSession();
	public static IIRUPManager iirupManager = new IIRUPManagerSession();
	public static WMRManager wmrManager = new WMRManagerSession();

	public final static ManagerBin INSTANCE = new ManagerBin();
	
	public ManagerBin() {
	}

	public static ManagerBin getInstance() {
		return INSTANCE;
	}

}
