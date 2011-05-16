package com.iappsam.entities;

import java.sql.Date;


public class ItemManagerFactory {
	
	public static Item createItemByName(String name) {
		
		return new Item(name, "", "", 0.0f, new Date(0), "", "");
	}
}
