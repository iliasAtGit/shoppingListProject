package com.iliasAtGit.helloMVC.dao;

public class IdAndNameUserDisplay {
	private Short id;
	private String name;
	public IdAndNameUserDisplay() {
		
	}
	public IdAndNameUserDisplay(Short id, String name) {
		this.id = id;
		this.name = name;
	}

	public Short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}