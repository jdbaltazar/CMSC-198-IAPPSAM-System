package com.iappsam.util;

import com.iappsam.managers.AccountManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;


public class ManagerBin {
	  private static PersonManager pManager = new PersonManagerSession();
	  private static AccountManager aManager = new AccountManagerSession();
	  
	  private ManagerBin(){}
	  private static ManagerBin INSTANCE = new ManagerBin();
	  public static ManagerBin getInstance(){
		  return INSTANCE;
	  }
	  
	
}
