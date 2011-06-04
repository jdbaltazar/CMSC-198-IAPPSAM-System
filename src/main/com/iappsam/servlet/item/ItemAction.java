package com.iappsam.servlet.item;

public enum ItemAction {
	VIEW_ITEMS("view=all");

	public final String code;

	private ItemAction(String code) {
		this.code = code;
	}

	public String toString() {
		return code;
	}
}
