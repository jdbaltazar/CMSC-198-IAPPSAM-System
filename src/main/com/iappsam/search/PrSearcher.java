package com.iappsam.search;

import com.iappsam.forms.PR;

public class PrSearcher extends AbstractSearcher<PR> {

	public PrSearcher() {
		super(PR.class, "requestedBy.person.name", "approvedBy.person.name");
	}
}
