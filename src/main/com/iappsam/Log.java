package com.iappsam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Log_ID")
	private int id;
	
	@Column(name = "Date")
	@Temporal(TemporalType.TIMESTAMP)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date date;
	
	@Column(name = "Description")
	private String description;

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Log(String description) {
		super();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
