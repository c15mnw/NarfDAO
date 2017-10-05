package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.LineMhc;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceLineMhc {
	
	public <T extends LineMhc> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public LineMhc findByOid( Long oid );
    public LineMhc findByName( String name );

    public List<LineMhc> findAll(); 

}
