package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineSex;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryBirdOrderLineSex extends JpaRepository<BirdOrderLineSex, Long> {

	public BirdOrderLineSex findByOid( Long oid );
	public BirdOrderLineSex findByName( String name );

}
