package com.iappsam.entities;

public class DisposalDetail {
	private String disposalType;
	private String disposalDetail;

	public DisposalDetail(String disposalType, String disposalDetail) {
		this.disposalDetail = disposalDetail;
		this.disposalType = disposalType;
	}

	public DisposalDetail(String disposalType) {
		this.disposalType = disposalType;
	}

	public String getDisposalDetail() {
		return disposalDetail;
	}

	public void setDisposalDetail(String disposalDetail) {
		this.disposalDetail = disposalDetail;
	}

	public String getDisposalType() {
		return disposalType;
	}
}
