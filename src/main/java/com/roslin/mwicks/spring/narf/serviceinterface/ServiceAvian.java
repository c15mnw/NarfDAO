package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionAvianNotFound;

import com.roslin.mwicks.spring.narf.model.Avian;


/**
 * Declares methods used to obtain and modify Avian information.
 * @author Mike Wicks
 */
public interface ServiceAvian {

	public <T extends Avian> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public Avian findByOid(Long oid);
    public Avian findByName(String name);

    public List<Avian> findAll(); 

    public void save(Avian avian);

    public Avian update(Avian avian) throws ExceptionAvianNotFound;

    public void delete(Avian avian) throws ExceptionAvianNotFound;

    public void deleteByName(String naw) throws ExceptionAvianNotFound;
    
    boolean isAvianNameUnique(Long oid, String name);
}
