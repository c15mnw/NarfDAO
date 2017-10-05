package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.LineSusceptible;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceLineSusceptible {
	
	public <T extends LineSusceptible> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public LineSusceptible findByOid( Long oid );
    public LineSusceptible findByName( String name );

    public List<LineSusceptible> findAll(); 

}
