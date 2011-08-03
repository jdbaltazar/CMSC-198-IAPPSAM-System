package com.iappsam.managers.exceptions;

@SuppressWarnings("serial")
public class DuplicateEntryException extends Exception {

	public DuplicateEntryException() {
		super();
	}

	public DuplicateEntryException(String msg) {
		super(msg);
	}

}