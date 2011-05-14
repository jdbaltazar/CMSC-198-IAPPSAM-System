package com.iappsam.entities.forms;

public class RSMILine {
	private int rsmiLineID;
	private int rsmiID;
	private int risLineID;

	private String responsibilityCenter;

	private void init(int rsmiLineID, int rsmiID, int risLineID,
			String responsibilityCenter) {
		this.rsmiLineID = rsmiLineID;
		this.rsmiID = rsmiID;
		this.risLineID = risLineID;
		this.responsibilityCenter = responsibilityCenter;
	}

	public RSMILine(int rsmiLineID, int rsmiID, int risLineID) {
		init(rsmiLineID, rsmiID, risLineID, "");
	}

	public RSMILine(int rsmiLineID, int rsmiID, int risLineID,
			String responsibilityCenter) {
		init(rsmiLineID, rsmiID, risLineID, responsibilityCenter);
	}

	public String getResponsibilityCenter() {
		return responsibilityCenter;
	}

	public void setResponsibilityCenter(String responsibilityCenter) {
		this.responsibilityCenter = responsibilityCenter;
	}

	public int getRsmiLineID() {
		return rsmiLineID;
	}

	public int getRsmiID() {
		return rsmiID;
	}

	public int getRisLineID() {
		return risLineID;
	}
}
