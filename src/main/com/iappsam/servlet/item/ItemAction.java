package com.iappsam.servlet.item;

public enum ItemAction {
	VIEW_ITEMS("view=all"), ADD_ITEM("add=item");

	public final String code;

	private ItemAction(String code) {
		this.code = code;
	}

	public String toString() {
		return code;
	}
}
