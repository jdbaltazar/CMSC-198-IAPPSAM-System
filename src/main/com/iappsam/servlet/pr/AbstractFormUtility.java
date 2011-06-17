package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.FormParser;
import com.iappsam.servlet.form.FormUtility;
import com.iappsam.util.ApplicationContext;

public abstract class AbstractFormUtility implements FormUtility {

	protected ApplicationContext appContext;
	protected FormParser parser;

	public AbstractFormUtility(ApplicationContext appContext, FormParser parser) {
		super();
		this.appContext = appContext;
		this.parser = parser;
	}

	@Override
	public FormParser getParser() {
		return parser;
	}

	@Override
	public ApplicationContext getApplicationContext() {
		return appContext;
	}

}