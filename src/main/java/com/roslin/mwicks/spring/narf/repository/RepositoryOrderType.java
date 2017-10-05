package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.OrderType;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryOrderType extends JpaRepository<OrderType, Long> {

	public OrderType findByOid( Long oid );
	public OrderType findByName( String name );

}
