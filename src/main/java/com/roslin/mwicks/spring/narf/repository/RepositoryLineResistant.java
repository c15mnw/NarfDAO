package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.LineResistant;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryLineResistant extends JpaRepository<LineResistant, Long> {

	public LineResistant findByOid( Long oid );
	public LineResistant findByName( String name );

}
