package com.iappsam.servlet.form;

import com.iappsam.util.ApplicationContext;

public abstract class AbstractFormUtility implements FormUtility {

	protected ApplicationContext appContext;
	protected FormParser parser;
	private String formName;

	public AbstractFormUtility(String name, ApplicationContext appContext, FormParser parser) {
		super();
		this.formName = name;
		this.appContext = appContext;
		this.parser = parser;
	}

	@Override
	public String getFormName() {
		return formName;
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