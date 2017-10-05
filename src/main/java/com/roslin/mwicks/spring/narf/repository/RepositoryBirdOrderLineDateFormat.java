package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineDateFormat;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryBirdOrderLineDateFormat extends JpaRepository<BirdOrderLineDateFormat, Long> {

	public BirdOrderLineDateFormat findByOid( Long oid );
	public BirdOrderLineDateFormat findByName( String name );

}
