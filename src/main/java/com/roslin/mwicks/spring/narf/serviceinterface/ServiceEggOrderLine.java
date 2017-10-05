package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionEggOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.EggOrderLine;


/**
 * Declares methods used to obtain and modify EggOrderLine information.
 * @author Mike Wicks
 */
public interface ServiceEggOrderLine {

	public <T extends EggOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public EggOrderLine findByOid(Long oid);

    public List<EggOrderLine> findAll(); 

    public void save(EggOrderLine line);

    public EggOrderLine create(EggOrderLine line);

    public EggOrderLine update(EggOrderLine line) throws ExceptionEggOrderLineNotFound;
    
    public void delete(EggOrderLine line) throws ExceptionEggOrderLineNotFound;

    public void deleteByOid(Long oid) throws ExceptionEggOrderLineNotFound;
}
