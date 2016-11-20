package com.iliasAtGit.shoppingListProject.dao;

public class ShoppingListUserDisplay {
	private Short id;
	private Float quantity;
	private String comment;
	private String productName;
	private String shopDepartment;

	public ShoppingListUserDisplay(Short id, 
								   Float quantity,
								   String comment,
								   String productName,
								   String shopDepartment) {
		this.id = id;
		this.quantity = quantity;
		this.comment = comment;
		this.productName = productName;
		this.shopDepartment = shopDepartment;
	}

	public Short getId() {
		return id;
	}
	
	public Float getQuantity() {
		return quantity;
	}

	public String getComment() {
		return comment;
	}
	
	public String getProductName() {
		return productName;
	}

	public String getShopDepartment() {
		return shopDepartment;
	}

}
