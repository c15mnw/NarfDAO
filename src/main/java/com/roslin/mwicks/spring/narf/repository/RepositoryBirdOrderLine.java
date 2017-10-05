package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.BirdOrderLine;

/**
 * Specifies methods used to obtain and modify BirdOrderLine related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryBirdOrderLine extends JpaRepository<BirdOrderLine, Long> {

	public BirdOrderLine findByOid( Long oid );

	public void deleteByOid( Long oid );

}
