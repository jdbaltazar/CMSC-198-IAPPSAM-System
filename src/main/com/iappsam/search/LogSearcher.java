package com.iappsam.search;

import com.iappsam.Log;

public class LogSearcher extends AbstractSearcher<Log> {

	public LogSearcher() {
		super(Log.class, "date", "description");
	}
	
}
