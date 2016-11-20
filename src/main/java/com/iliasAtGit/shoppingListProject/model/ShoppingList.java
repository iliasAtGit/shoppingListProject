package com.iliasAtGit.shoppingListProject.model;

/**
 * The persistent class for the t_shopping_list database table.
 *
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
/*@NamedQueries({
	@NamedQuery(name = "getShoppingListByNote",
			    query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.ShoppingListUserDisplay "
					    + "(l.id, l.quantity, l.comment, p.name, d.name) "
						+"FROM "
						+ "ShoppingList  l "
						+"JOIN "
						+ "Product       p "
						+ "ON l.product.id = p.id "
						+"JOIN "
						+ "ShopDepartment d "
						+ "ON l.product.shopDepartment.id = d.id "
						+"WHERE "
						+ "l.shoppingNote.id = :shoppingNote "
				)
})*/
@Table(name = "shopping_list", uniqueConstraints = @UniqueConstraint(columnNames = {"prod_dep_unit", "shopping_note"}))
public class ShoppingList implements Serializable {
	private static final long serialVersionUID = 3978317328464256693L;

	@Column(name = "id", table = "shopping_list", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Column(name = "quantity", table = "shopping_list", nullable = false)
	@Basic
	private float quantity;

	@Column(name = "comment", table = "shopping_list")
	@Basic
	private String comment;

	@Column(name = "created_on", table = "shopping_list", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	private Date createdOn;

	@ManyToOne(optional = false, targetEntity = ProdsDepUnit.class)
	@JoinColumn(name = "prod_dep_unit")
	private ProdsDepUnit prodDepUnit;

	@ManyToOne(optional = false, targetEntity = User.class)
	@JoinColumn(name = "created_by")
	private User createdBy;
	//TODO = new User(Short.parseShort("1"))

	@ManyToOne(optional = false, targetEntity = ShoppingNote.class)
	@JoinColumn(name = "shopping_note")
	private ShoppingNote shoppingNote;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public ProdsDepUnit getProdDepUnit() {
		return prodDepUnit;
	}

	public void setProdDepUnit(ProdsDepUnit prodDepUnit) {
		this.prodDepUnit = prodDepUnit;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public ShoppingNote getShoppingNote() {
		return shoppingNote;
	}

	public void setShoppingNote(ShoppingNote shoppingNote) {
		this.shoppingNote = shoppingNote;
	}


}
