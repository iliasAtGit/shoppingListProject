package com.iliasAtGit.shoppingListProject.dao.custom;

public class ProductForUser {
	private Short productId;
	private String productName;
	private Short shopDepId;
	private String shopDepName;
	private Short unitId;
	private String unitName;
	private Short prodDepartId;
	private Short prodDepartUnitId;

	public ProductForUser(){

	}
	public ProductForUser(Short productId,
						  String productName,
						  Short shopDepId,
						  String shopDepName,
						  Short unitId,
						  String unitName,
						  Short prodDepartId,
						  Short prodDepartUnitId){
		this.productId = productId;
		this.productName = productName;
		this.shopDepId = shopDepId;
		this.shopDepName = shopDepName;
		this.unitId = unitId;
		this.unitName = unitName;
		this.prodDepartId = prodDepartId;
		this.prodDepartUnitId = prodDepartUnitId;
	}

	public Short getProductId() {
		return productId;
	}

	public void setProductId(Short productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Short getShopDepId() {
		return shopDepId;
	}

	public void setShopDepId(Short shopDepId) {
		this.shopDepId = shopDepId;
	}

	public String getShopDepName() {
		return shopDepName;
	}

	public void setShopDepName(String shopDepName) {
		this.shopDepName = shopDepName;
	}

	public Short getUnitId() {
		return unitId;
	}

	public void setUnitId(Short unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Short getProdDepartId() {
		return prodDepartId;
	}

	public void setProdDepartId(Short prodDepartId) {
		this.prodDepartId = prodDepartId;
	}

	public Short getProdDepartUnitId() {
		return prodDepartUnitId;
	}

	public void setProdDepartUnitId(Short prodDepartUnitId) {
		this.prodDepartUnitId = prodDepartUnitId;
	}
}