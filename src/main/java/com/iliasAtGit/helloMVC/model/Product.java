package com.iliasAtGit.helloMVC.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Product implements Serializable {
	private static final long serialVersionUID = -5278709279396842609L;

	@Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    
    @Column(name = "name", nullable = false)
    @Basic
    private String name;
    
    @Column(name = "is_visible", nullable = false)
    @Basic
    private Short isVisible = 1;

    @ManyToOne(optional = false, targetEntity = ShopDepartment.class)
    @JoinColumn(name = "shop_department")
    private ShopDepartment shopDepartment;

    @ManyToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "created_by")
    private User createdBy = new User(Short.parseShort("1"));
    //TODO
    //REMOVE  = new User(Short.parseShort("1"))
    @OneToMany(targetEntity = ShoppingList.class, mappedBy = "product")
    private List<ShoppingList> shoppingListCollection;

    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getIsVisible() {
        return this.isVisible;
    }

    public void setIsVisible(Short isVisible) {
        this.isVisible = isVisible;
    }

    public ShopDepartment getShopDepartment() {
        return this.shopDepartment;
    }

    public void setShopDepartment(ShopDepartment shopDepartment) {
        this.shopDepartment = shopDepartment;
    }
    
    public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<ShoppingList> getShoppingListCollection() {
        return this.shoppingListCollection;
    }

    public void setShoppingListCollection(List<ShoppingList> shoppingListCollection) {
        this.shoppingListCollection = shoppingListCollection;
    }
}