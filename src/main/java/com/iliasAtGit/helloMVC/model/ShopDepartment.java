package com.iliasAtGit.helloMVC.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@NamedQueries({
		@NamedQuery(name = "findById4userDisplay",
					query = "SELECT NEW com.iliasAtGit.helloMVC.dao.IdAndNameUserDisplay "
							+	"(p.id, p.name) "
							+"FROM "
							+	"ShopDepartment p "
							+"WHERE "
							+	"p.id = :sdId"),

		@NamedQuery(name = "findAll4userDisplay",
				    query = "SELECT NEW com.iliasAtGit.helloMVC.dao.IdAndNameUserDisplay "
							+	"(p.id, p.name) "
							+ "FROM "
							+	"ShopDepartment p "
							+ "ORDER BY "
							+	"p.name ASC")
})
@Table(name = "shop_department", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = {"name"}))
@DynamicUpdate(value=true)
public class ShopDepartment implements Serializable {
	private static final long serialVersionUID = -6108123833144772210L;

	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(name = "name", nullable = false)
	@Basic
	private String name;
	
	@OneToMany(targetEntity = Product.class, mappedBy = "shopDepartment", fetch=FetchType.LAZY)
	private List<Product> productCollection;
    
	@ManyToOne(optional = false, targetEntity = User.class, fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "created_by")
    private User createdBy = new User(Short.parseShort("1"));
    //TODO
    //REMOVE  = new User(Short.parseShort("1"))
	
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
	
	public List<Product> getProductCollection() {
	    return this.productCollection;
	}
	
	public void setProductCollection(List<Product> productCollection) {
	    this.productCollection = productCollection;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}