package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionBirdOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.BirdOrderLine;


/**
 * Declares methods used to obtain and modify BirdOrderLine information.
 * @author Mike Wicks
 */
public interface ServiceBirdOrderLine {

	public <T extends BirdOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public BirdOrderLine findByOid(Long oid);

    public List<BirdOrderLine> findAll(); 

    public void save(BirdOrderLine line);

    public BirdOrderLine create(BirdOrderLine line);

    public BirdOrderLine update(BirdOrderLine line) throws ExceptionBirdOrderLineNotFound;
    
    public void delete(BirdOrderLine line) throws ExceptionBirdOrderLineNotFound;

    public void deleteByOid(Long oid) throws ExceptionBirdOrderLineNotFound;
}
