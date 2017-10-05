package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.OrderCollection;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryOrderCollection extends JpaRepository<OrderCollection, Long> {

	public OrderCollection findByOid( Long oid );
	public OrderCollection findByName( String name );

}
