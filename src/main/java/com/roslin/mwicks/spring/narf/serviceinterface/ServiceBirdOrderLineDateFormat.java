package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineDateFormat;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceBirdOrderLineDateFormat {
	
	public <T extends BirdOrderLineDateFormat> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public BirdOrderLineDateFormat findByOid( Long oid );
    public BirdOrderLineDateFormat findByName( String name );

    public List<BirdOrderLineDateFormat> findAll(); 

}
