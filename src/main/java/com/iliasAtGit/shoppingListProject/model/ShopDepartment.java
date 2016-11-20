package com.iliasAtGit.shoppingListProject.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@NamedQueries({
	@NamedQuery(name = "findSDById4userDisplay",
			query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserIdAndName "
					+	"(sd.id, sd.name) "
					+"FROM "
					+	"ShopDepartment sd "
					+"WHERE "
					+	"sd.id = :sdId"),

	@NamedQuery(name = "findSDAll4userDisplay",
	query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserIdAndName "
			+	"(sd.id, sd.name) "
			+ "FROM "
			+	"ShopDepartment sd "
			+ "ORDER BY "
			+	"sd.name ASC")
})
@Table(name = "shop_department", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@DynamicUpdate(value=true)
public class ShopDepartment implements Serializable {
	private static final long serialVersionUID = -6108123833144772210L;

	@Column(name = "id", table = "shop_department", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Column(name = "name", table = "shop_department", nullable = false)
	@Basic
	private String name;

	@OneToMany(targetEntity = ProdsDepart.class, mappedBy = "shopDepartment")
	private List<ProdsDepart> prodsDepartsCollection;

	@ManyToOne(optional = false, targetEntity = User.class)
	@JoinColumn(name = "created_by")
	private User createdBy;
	//TODO= new User(Short.parseShort("1"))

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

	public List<ProdsDepart> getProdsDepartsCollection() {
		return prodsDepartsCollection;
	}

	public void setProdsDepartsCollection(List<ProdsDepart> prodsDepartsCollection) {
		this.prodsDepartsCollection = prodsDepartsCollection;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}