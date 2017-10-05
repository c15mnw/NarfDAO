package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceEmbryoOrderLineIncubation {
	
	public <T extends EmbryoOrderLineIncubation> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public EmbryoOrderLineIncubation findByOid( Long oid );
    public EmbryoOrderLineIncubation findByName( String name );

    public List<EmbryoOrderLineIncubation> findAll(); 

}
