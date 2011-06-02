package com.iappsam.search;

import com.iappsam.entities.Unit;

public class UnitSearcher extends AbstractSearcher{

	public UnitSearcher() {
		super(Unit.class, "name");
	}
}
