package com.misfat.qrqc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.misfat.qrqc.model.PersonnelAppRoles;

@Repository
public interface PersonnelAppRolesRepository  extends JpaRepository<PersonnelAppRoles, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM PersonnelAppRoles PR WHERE PR.personnel.id = :id")
	void deletebyPersonnelId(@Param("id") Integer id);
}
