package com.iappsam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IappsamConfig {

	@Id
	private int id;

	@Column(name = "configured")
	private boolean configured;

	public IappsamConfig() {
	}

	public IappsamConfig(int id, boolean configured) {
		super();
		this.id = id;
		this.configured = configured;
	}

	public int getId() {
		return id;
	}

	public boolean isConfigured() {
		return configured;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setConfigured(boolean configured) {
		this.configured = configured;
	}

}
