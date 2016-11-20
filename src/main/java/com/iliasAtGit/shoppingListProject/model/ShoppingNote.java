package com.iliasAtGit.shoppingListProject.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
/*@NamedQueries({
		@NamedQuery(name = "findActiveShoppingNote4UserDisplay",
				    query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.ShoppingNoteUserDisplay "
							+	"(p.id, p.name, p.dateStart, p.dateEnd, p.isActive) "
							+"FROM "
							+	"ShoppingNote p "
							+"WHERE "
							+	"p.isActive = :isActive "
							+"ORDER BY "
							+	"p.dateStart DESC"),
		@NamedQuery(name = "findAllShoppingNote4UserDisplay",
				    query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.ShoppingNoteUserDisplay "
							+	"(p.id, p.name, p.dateStart, p.dateEnd, p.isActive) "
							+"FROM "
							+	"ShoppingNote p "
							+"ORDER BY "
							+	"p.dateStart DESC")
})*/
@Table(name = "shopping_note", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class ShoppingNote implements Serializable {
	private static final long serialVersionUID = -8050532031960277591L;

	@Column(name = "id", table = "shopping_note", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Column(name = "name", table = "shopping_note")
	@Basic
	private String name;

	@Column(name = "date_start", table = "shopping_note")
	@Temporal(TemporalType.DATE)
	@Basic
	private Date dateStart;

	@Column(name = "date_end", table = "shopping_note")
	@Temporal(TemporalType.DATE)
	@Basic
	private Date dateEnd;

	@Column(name = "is_active", table = "shopping_note")
	@Basic
	private Short isActive;

	@Column(name = "created_on", table = "shopping_note", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	private Date createdOn;

	@Column(name = "modify_on", table = "shopping_note")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	private Date modifyOn;

	@OneToMany(targetEntity = ShoppingList.class, mappedBy = "shoppingNote")
	private List<ShoppingList> shoppingListCollection;

	@ManyToOne(optional = false, targetEntity = User.class)
	@JoinColumn(name = "created_by")
	private User createdBy;
	//TODO = new User(Short.parseShort("1"))

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifyOn() {
		return modifyOn;
	}

	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}

	public List<ShoppingList> getShoppingListCollection() {
		return shoppingListCollection;
	}

	public void setShoppingListCollection(List<ShoppingList> shoppingListCollection) {
		this.shoppingListCollection = shoppingListCollection;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}
