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



@Entity
@NamedQueries({
	@NamedQuery(name = "findProdAllVisible4userDisplay",
			query = "SELECT NEW com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserProductList "
					+	"(p.id, p.name, sd.id, sd.name, u.id, u.name, pd.id, pdu.id) "
					+ "FROM "
					+	"Product p "
					+ "INNER JOIN "
					+ 	"ProdsDepart pd "
					+   "ON p.id = pd.product.id "
					+ "INNER JOIN "
					+ 	"ShopDepartment sd "
					+   "ON pd.shopDepartment.id = sd.id "
					+ "INNER JOIN "
					+ 	"ProdsDepUnit pdu "
					+   "ON pd.id = pdu.prodDepart.id "
					+ "INNER JOIN "
					+ 	"Unit u "
					+   "ON pdu.unit.id = u.id "
					+ "WHERE "
					+	"p.isVisible = 1 "
					+ "ORDER BY "
					+	"p.name ASC,"
					+   "sd.name ASC,"
					+   "u.name ASC")
})
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
	private short isVisible;

	@OneToMany(targetEntity = ProdsDepart.class, mappedBy = "product")
	private List<ProdsDepart> prodsDepartsCollection;

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

	public short getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(short isVisible) {
		this.isVisible = isVisible;
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