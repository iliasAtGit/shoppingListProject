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

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class User implements Serializable {
	private static final long serialVersionUID = -8207710488844159192L;

	public User (){

	}
	public User (Short id){
		this.id = id;
	}
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

	@Column(name = "password", nullable = false)
    @Basic
    private String password;

    @Column(name = "name", nullable = false)
    @Basic
    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "createdBy")
    private List<Product> productCollection;

    @OneToMany(targetEntity = ShoppingList.class, mappedBy = "createdBy")
    private List<ShoppingList> shoppingListCollection;
   
    @OneToMany(targetEntity = ShoppingNote.class, mappedBy = "createdBy")
    private List<ShoppingNote> shoppingNoteCollection;

    @OneToMany(targetEntity = ShopDepartment.class, mappedBy = "createdBy")
    private List<ShopDepartment> shopDepartmentCollection;  
   
    @ManyToOne(optional = false, targetEntity = UserRole.class)
    @JoinColumn(name = "role")
    private UserRole role;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductCollection() {
		return productCollection;
	}

	public void setProductCollection(List<Product> productCollection) {
		this.productCollection = productCollection;
	}

	public List<ShoppingList> getShoppingListCollection() {
		return shoppingListCollection;
	}

	public void setShoppingListCollection(List<ShoppingList> shoppingListCollection) {
		this.shoppingListCollection = shoppingListCollection;
	}

	public List<ShoppingNote> getShoppingNoteCollection() {
		return shoppingNoteCollection;
	}

	public void setShoppingNoteCollection(List<ShoppingNote> shoppingNoteCollection) {
		this.shoppingNoteCollection = shoppingNoteCollection;
	}

	public List<ShopDepartment> getShopDepartmentCollection() {
		return shopDepartmentCollection;
	}

	public void setShopDepartmentCollection(List<ShopDepartment> shopDepartmentCollection) {
		this.shopDepartmentCollection = shopDepartmentCollection;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
