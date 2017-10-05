package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.LineResistant;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceLineResistant {
	
	public <T extends LineResistant> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public LineResistant findByOid( Long oid );
    public LineResistant findByName( String name );

    public List<LineResistant> findAll(); 

}
