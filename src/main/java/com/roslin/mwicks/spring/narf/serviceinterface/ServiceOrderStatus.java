package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.OrderStatus;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceOrderStatus {
	
	public <T extends OrderStatus> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public OrderStatus findByOid( Long oid );
    public OrderStatus findByName( String name );

    public List<OrderStatus> findAll(); 

}
