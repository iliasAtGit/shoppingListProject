package com.iliasAtGit.shoppingListProject.dao.custom;

public class DisplayForUserIdAndName {
	private Short id;
	private String name;
	public DisplayForUserIdAndName() {
		
	}
	public DisplayForUserIdAndName(Short id, String name) {
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