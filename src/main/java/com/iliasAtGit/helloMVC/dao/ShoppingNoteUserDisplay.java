package com.iliasAtGit.helloMVC.dao;

import java.util.Date;

public class ShoppingNoteUserDisplay {
	private Short id;
	private String name;
	private Date dateStart;
	private Date dateEnd;
	private Short isActive;

	public ShoppingNoteUserDisplay(Short id, String name, Date dateStart, Date dateEnd, Short isActive) {
		this.id = id;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.isActive = isActive;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	
}
