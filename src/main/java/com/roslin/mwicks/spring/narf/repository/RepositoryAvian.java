package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.Avian;

/**
 * Specifies methods used to obtain and modify Avian related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryAvian extends JpaRepository<Avian, Long> {

	public Avian findByOid( Long oid );
	public Avian findByName(String name);

	public void deleteByOid( Long oid );
	public void deleteByName( String name );
	
}
