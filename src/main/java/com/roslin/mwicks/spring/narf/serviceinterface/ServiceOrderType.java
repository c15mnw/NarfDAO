package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.OrderType;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceOrderType {
	
	public <T extends OrderType> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public OrderType findByOid( Long oid );
    public OrderType findByName( String name );

    public List<OrderType> findAll(); 

}
