package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.Organism;

/**
 * Specifies methods used to obtain and modify Organism related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryOrganism extends JpaRepository<Organism, Long> {

	public Organism findByOid( Long oid );
	public Organism findByName(String name);

	public void deleteByOid( Long oid );
	public void deleteByName( String name );
	
}
