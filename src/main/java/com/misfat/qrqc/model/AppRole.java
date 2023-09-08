package com.misfat.qrqc.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class AppRole.
 */
@Entity

public class AppRole {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The role name. */
	private String roleName;

	/** The personnels. */
	@JsonIgnoreProperties({ "role" })
	@OneToMany(mappedBy = "role")
	private Collection<PersonnelAppRoles> personnels;

	/**
	 * Instantiates a new app role.
	 */
	public AppRole() {
		super();
	}

	/**
	 * Instantiates a new app role.
	 *
	 * @param id the id
	 * @param roleName the role name
	 */
	public AppRole(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
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

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the personnels.
	 *
	 * @return the personnels
	 */
	public Collection<PersonnelAppRoles> getPersonnels() {
		return personnels;
	}

	/**
	 * Sets the personnels.
	 *
	 * @param personnels the new personnels
	 */
	public void setPersonnels(Collection<PersonnelAppRoles> personnels) {
		this.personnels = personnels;
	}
	
	

}
