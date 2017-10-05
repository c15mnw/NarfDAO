package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.LineMhc;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryLineMhc extends JpaRepository<LineMhc, Long> {

	public LineMhc findByOid( Long oid );
	public LineMhc findByName( String name );

}
