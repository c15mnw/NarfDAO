package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.EggOrderLine;

/**
 * Specifies methods used to obtain and modify EggOrderLine related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryEggOrderLine extends JpaRepository<EggOrderLine, Long> {

	public EggOrderLine findByOid( Long oid );

	public void deleteByOid( Long oid );

}
