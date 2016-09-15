package com.iliasAtGit.helloMVC.dao;

public class ShoppingListUserDisplay {
	private Float quantity;
	private String productName;

	public ShoppingListUserDisplay(Float quantity, String productName) {
		this.quantity = quantity;
		this.productName = productName;
	}

	public Float getQuantity() {
		return quantity;
	}

	public String geProductName() {
		return productName;
	}

}
