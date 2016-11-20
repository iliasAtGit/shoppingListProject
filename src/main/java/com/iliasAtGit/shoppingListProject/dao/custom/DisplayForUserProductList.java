package com.iliasAtGit.shoppingListProject.dao.custom;

public class DisplayForUserProductList {
	private Short id;
	private String name;
	private Short shopDepId;
	private String shopDepName;
	private Short unitId;
	private String unitName;
	private Short prodDepartId;
	private Short prodDepartUnitId;

	public DisplayForUserProductList(Short id,
									 String name,
									 Short shopDepId,
									 String shopDepName,
									 Short unitId,
									 String unitName,
									 Short prodDepartId,
									 Short prodDepartUnitId) {
		this.id = id;
		this.name = name;
		this.shopDepId = shopDepId;
		this.shopDepName = shopDepName;
		this.unitId = unitId;
		this.unitName = unitName;
		this.prodDepartId = prodDepartId;
		this.prodDepartUnitId = prodDepartUnitId;
	}

	public Short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Short getShopDepId() {
		return shopDepId;
	}
	
	public String getShopDepName() {
		return shopDepName;
	}
	
	public Short getUnitId() {
		return unitId;
	}
	
	public String getUnitName() {
		return unitName;
	}

	public Short getProdDepartId() {
		return prodDepartId;
	}

	public Short getProdDepartUnitId() {
		return prodDepartUnitId;
	}
}