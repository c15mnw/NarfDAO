package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineSex;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceBirdOrderLineSex {
	
	public <T extends BirdOrderLineSex> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public BirdOrderLineSex findByOid( Long oid );
    public BirdOrderLineSex findByName( String name );

    public List<BirdOrderLineSex> findAll(); 

}
