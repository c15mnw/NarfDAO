package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.OrderCollection;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceOrderCollection {
	
	public <T extends OrderCollection> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public OrderCollection findByOid( Long oid );
    public OrderCollection findByName( String name );

    public List<OrderCollection> findAll(); 

}
