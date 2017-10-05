package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.OrderStatus;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryOrderStatus extends JpaRepository<OrderStatus, Long> {

	public OrderStatus findByOid( Long oid );
	public OrderStatus findByName( String name );

}
