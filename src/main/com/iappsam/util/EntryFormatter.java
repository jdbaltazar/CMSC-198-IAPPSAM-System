package com.iappsam.util;

import java.util.ArrayList;

public class EntryFormatter {
	public EntryFormatter() {
		// TODO Auto-generated constructor stub
	}

	public boolean check(String entry) {
		System.out.println("Entry:" + entry);
		AlphaNumeric[] aN = AlphaNumeric.values();
		ArrayList<String> alpha = new ArrayList<String>();

		for (int i = 0; i < aN.length; i++) {
			alpha.add(aN[i].toString());
		}
		if (entry.length() < 1)
			return false;
		for (int i = 0; i < entry.length(); i++) {
			if (!alpha.contains("" + entry.charAt(i)) && (!("" + entry.charAt(i)).equalsIgnoreCase(" "))) {
				System.out.println("Error Occoured at letterNo:" + i + ":" + entry.charAt(i) + ":");
				return false;
			}
		}
		return true;
	}

	public String spaceTrimmer(String entry) {
		String value = entry;
		if (entry == null || entry.length() == 0) {
			return entry;
		}
		if (entry.charAt(0) == ' ') {
			for (int i = 0; i < entry.length(); i++) {
				if (entry.charAt(i) != ' ') {
					value = entry.substring(i);
					break;
				}
			}
		}

		if (value.length() > 0 && value.charAt(value.length() - 1) == ' ') {
			for (int i = value.length() - 1; i > 0; i--) {
				if (value.charAt(i) != ' ') {
					value = value.substring(0, i + 1);
					break;
				}
			}
		}
		String dummy2 = "";
		String dummy3 = value;
		if (value.length() > 0)
			for (int j = 0; j < dummy3.length(); j++) {
				if (dummy3.charAt(j) == ' ') {
					for (int k = j; k < dummy3.length(); k++) {
						if (dummy3.charAt(k) != ' ') {
							dummy2 = dummy3.substring(0, j) + dummy3.substring(k - 1, dummy3.length());
							break;
						}
					}
					dummy3 = dummy2;
				}
			}
		value = dummy3;
		return value;
	}
}
