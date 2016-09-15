package com.iliasAtGit.helloMVC.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
	@NamedQuery(name = "getShoppingListByNote",
			    query = "SELECT NEW com.iliasAtGit.helloMVC.dao.ShoppingListUserDisplay "
					    + "(l.quantity, p.name) "
						+"FROM "
						+ "ShoppingList l "
						+"JOIN "  
						+ "Product      p " 
						+"WHERE "
						+ "l.shoppingNote.id = :shoppingNote "
				),
	@NamedQuery(name = "getShoppingListByNote1",
			    query = "SELECT NEW com.iliasAtGit.helloMVC.dao.ShoppingListUserDisplay "
					    + "(l.quantity, p.name) "
						+"FROM "
						+ "ShoppingList l "
						+"JOIN "  
						+ "Product      p " 
	)
})
@Table(name = "shopping_list", uniqueConstraints = @UniqueConstraint(columnNames = {"product", "shopping_note"}))
public class ShoppingList implements Serializable {

	private static final long serialVersionUID = 3978317328464256693L;

	@Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date createdOn;
    
    @Column(name = "quantity", nullable = false)
    @Basic
    private Float quantity;

    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "product")
    private Product product;
    
    @ManyToOne(optional = false, targetEntity = ShoppingNote.class)
    @JoinColumn(name = "shopping_note")
    private ShoppingNote shoppingNote;

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

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public ShoppingNote getShoppingNote() {
        return this.shoppingNote;
    }

    public void setShoppingNote(ShoppingNote shoppingNote) {
        this.shoppingNote = shoppingNote;
    }
    
    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
