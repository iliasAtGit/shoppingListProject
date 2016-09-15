package com.iliasAtGit.helloMVC.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
		@NamedQuery(name = "findActiveShoppingNote4UserDisplay",
				    query = "SELECT NEW com.iliasAtGit.helloMVC.dao.ShoppingNoteUserDisplay "
							+	"(p.id, p.name, p.dateStart, p.dateEnd, p.isActive) "
							+"FROM "
							+	"ShoppingNote p "
							+"WHERE "
							+	"p.isActive = :isActive "
							+"ORDER BY "
							+	"p.dateStart DESC"),
		@NamedQuery(name = "findAllShoppingNote4UserDisplay",
				    query = "SELECT NEW com.iliasAtGit.helloMVC.dao.ShoppingNoteUserDisplay "
							+	"(p.id, p.name, p.dateStart, p.dateEnd, p.isActive) "
							+"FROM "
							+	"ShoppingNote p "
							+"ORDER BY "
							+	"p.dateStart DESC")
})
@Table(name = "shopping_note", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class ShoppingNote implements Serializable {

	private static final long serialVersionUID = -8050532031960277591L;

	@Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateStart;

    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateEnd;
    
    @Column(name = "is_active")
    @Basic
    private Short isActive = 1;   

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date createdOn;
    
    @Column(name = "modify_on")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date modifyOn;

    @OneToMany(targetEntity = ShoppingList.class, mappedBy = "shoppingNote")
    private List<ShoppingList> shoppingListCollection;

    @ManyToOne(optional = false, targetEntity = User.class)
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
    
    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Short getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifyOn() {
        return this.modifyOn;
    }

    public void setModifyOn(Date modifyOn) {
        this.modifyOn = modifyOn;
    }

    public List<ShoppingList> getShoppingListCollection() {
        return this.shoppingListCollection;
    }

    public void setShoppingListCollection(List<ShoppingList> shoppingListCollection) {
        this.shoppingListCollection = shoppingListCollection;
    }

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		//TODO
		//this.createdBy = createdBy;
		this.createdBy.setId(Short.parseShort("1"));
	}
}
