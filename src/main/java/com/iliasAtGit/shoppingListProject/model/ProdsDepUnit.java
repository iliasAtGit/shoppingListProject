package com.iliasAtGit.shoppingListProject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prods_dep_unit")
public class ProdsDepUnit implements Serializable {
	private static final long serialVersionUID = -8640573970278122757L;

	@Column(name = "id", table = "prods_dep_unit", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    
    @OneToMany(targetEntity = ShoppingList.class, mappedBy = "prodDepUnit")
    private List<ShoppingList> shoppingListCollection;

    @ManyToOne(optional = false, targetEntity = Unit.class)
    @JoinColumn(name = "unit")
    private Unit unit;

    @ManyToOne(optional = false, targetEntity = ProdsDepart.class)
    @JoinColumn(name = "prod_dep_id")
    private ProdsDepart prodDepart;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public List<ShoppingList> getShoppingListCollection() {
		return shoppingListCollection;
	}

	public void setShoppingListCollection(List<ShoppingList> shoppingListCollection) {
		this.shoppingListCollection = shoppingListCollection;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public ProdsDepart getProdDepart() {
		return prodDepart;
	}

	public void setProdDepart(ProdsDepart prodDepart) {
		this.prodDepart = prodDepart;
	}

}
