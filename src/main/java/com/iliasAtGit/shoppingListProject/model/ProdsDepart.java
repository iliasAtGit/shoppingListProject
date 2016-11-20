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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "prods_departs", uniqueConstraints = @UniqueConstraint(columnNames = {"prod_id", "depart_id"}))
public class ProdsDepart implements Serializable {

	private static final long serialVersionUID = -1809891610934524683L;

    @Column(name = "id", table = "prods_departs", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @OneToMany(targetEntity = ProdsDepUnit.class, mappedBy = "prodDepart")
    private List<ProdsDepUnit> prodsDepUnitCollection;

    @ManyToOne(optional = false, targetEntity = ShopDepartment.class)
    @JoinColumn(name = "depart_id")
    private ShopDepartment shopDepartment;
    
    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "prod_id")
    private Product product;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public List<ProdsDepUnit> getProdsDepUnitCollection() {
		return prodsDepUnitCollection;
	}

	public void setProdsDepUnitCollection(List<ProdsDepUnit> prodsDepUnitCollection) {
		this.prodsDepUnitCollection = prodsDepUnitCollection;
	}

	public ShopDepartment getShopDepartment() {
		return shopDepartment;
	}

	public void setShopDepartment(ShopDepartment shopDepartment) {
		this.shopDepartment = shopDepartment;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}