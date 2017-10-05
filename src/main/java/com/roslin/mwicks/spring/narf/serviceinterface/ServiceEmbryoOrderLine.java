package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionEmbryoOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLine;


/**
 * Declares methods used to obtain and modify EmbryoOrderLine information.
 * @author Mike Wicks
 */
public interface ServiceEmbryoOrderLine {

	public <T extends EmbryoOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public EmbryoOrderLine findByOid(Long oid);

    public List<EmbryoOrderLine> findAll(); 

    public void save(EmbryoOrderLine line);

    public EmbryoOrderLine create(EmbryoOrderLine line);

    public EmbryoOrderLine update(EmbryoOrderLine line) throws ExceptionEmbryoOrderLineNotFound;

    public void delete(EmbryoOrderLine line) throws ExceptionEmbryoOrderLineNotFound;

    public void deleteByOid(Long oid) throws ExceptionEmbryoOrderLineNotFound;
}
