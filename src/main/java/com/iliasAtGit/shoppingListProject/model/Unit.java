package com.iliasAtGit.shoppingListProject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "unit", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Unit implements Serializable {
	private static final long serialVersionUID = -6578289457306367796L;

	@Column(name = "id", table = "unit", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    
    @Column(name = "name", table = "unit", nullable = false)
    @Basic
    private String name;

    @OneToMany(targetEntity = ProdsDepUnit.class, mappedBy = "unit")
    private List<ProdsDepUnit> prodsDepUnitCollection;

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

	public List<ProdsDepUnit> getProdsDepUnitCollection() {
		return prodsDepUnitCollection;
	}

	public void setProdsDepUnitCollection(List<ProdsDepUnit> prodsDepUnitCollection) {
		this.prodsDepUnitCollection = prodsDepUnitCollection;
	}
}