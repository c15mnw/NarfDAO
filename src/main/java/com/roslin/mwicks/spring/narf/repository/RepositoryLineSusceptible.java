package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.LineSusceptible;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryLineSusceptible extends JpaRepository<LineSusceptible, Long> {

	public LineSusceptible findByOid( Long oid );
	public LineSusceptible findByName( String name );

}
