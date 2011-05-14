package com.iappsam.entities.forms;

public class AnnualProcurementPlanLine {
	private int appLineID;
	private int appID;
	private int itemID;
	private int[] quantityQuarter;

	private void init(int appLineID, int appID, int itemID,
			int[] quantityQuarter) {
		this.appLineID = appLineID;
		this.appID = appID;
		this.itemID = itemID;
		this.quantityQuarter = quantityQuarter;
	}

	public int getAppLineID() {
		return appLineID;
	}

	public int getAppID() {
		return appID;
	}

	public int getItemID() {
		return itemID;
	}

	public int[] getQuantityQuarter() {
		return quantityQuarter;
	}

	public AnnualProcurementPlanLine(int appLineID, int appID, int itemID,
			int[] quantityQuarter) {
		init(appLineID, appID, itemID, quantityQuarter);

	}
}
