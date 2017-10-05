package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roslin.mwicks.spring.narf.model.Order;
import com.roslin.mwicks.spring.narf.model.OrderStatus;

/**
 * Specifies methods used to obtain and modify Order related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryOrder extends JpaRepository<Order, Long> {

	public Order findByOid( Long oid );

	public void deleteByOid( Long oid );
	
	@Query("Select p from Order p where customer = :inCustomer " )
	public List<Order> findAllByCustomer(@Param("inCustomer") long inCustomer ); 

	@Query("Select p from Order p where customer = :inCustomer and orderStatus = :inStatus " )
	public List<Order> findAllByCustomerAndStatus(@Param("inCustomer") long inCustomer, @Param("inStatus") OrderStatus orderstatus ); 

}
