package com.misfat.qrqc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonnelAppRoles.
 */
@Entity
@Table(name = "personnel_app_roles")
public class PersonnelAppRoles {
	
	
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The personnel. */
	@JsonIgnoreProperties({ "appRoles" })
	@ManyToOne
	private Personnel personnel;
	
	/** The role. */
	@JsonIgnoreProperties({ "personnels" })
	@ManyToOne
	private AppRole role;

	/**
	 * Gets the personnel.
	 *
	 * @return the personnel
	 */
	public Personnel getPersonnel() {
		return personnel;
	}

	/**
	 * Sets the personnel.
	 *
	 * @param personnel the new personnel
	 */
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public AppRole getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(AppRole role) {
		this.role = role;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	

}
