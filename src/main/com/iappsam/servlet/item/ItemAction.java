package com.iappsam.servlet.item;

public enum ItemAction {
	LIST_ITEMS("view=all"), NEW_ITEM("add=item"), VIEW_ITEM("view=item"), SEARCH_ITEM("q");

	public final String code;

	private ItemAction(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}
}
