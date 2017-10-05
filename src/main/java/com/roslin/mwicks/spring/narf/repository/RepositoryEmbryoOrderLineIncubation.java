package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryEmbryoOrderLineIncubation extends JpaRepository<EmbryoOrderLineIncubation, Long> {

	public EmbryoOrderLineIncubation findByOid( Long oid );
	public EmbryoOrderLineIncubation findByName( String name );

}
