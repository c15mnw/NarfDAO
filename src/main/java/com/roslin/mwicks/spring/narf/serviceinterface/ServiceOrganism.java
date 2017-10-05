package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionOrganismNotFound;

import com.roslin.mwicks.spring.narf.model.Organism;


/**
 * Declares methods used to obtain and modify Organism information.
 * @author Mike Wicks
 */
public interface ServiceOrganism {

	public <T extends Organism> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public Organism findByOid(Long oid);
    public Organism findByName(String name);

    public List<Organism> findAll(); 

    public void save(Organism antibody);

    public Organism update(Organism antibody) throws ExceptionOrganismNotFound;

    public void delete(Organism antibody) throws ExceptionOrganismNotFound;

    public void deleteByName(String naw) throws ExceptionOrganismNotFound;
    
    boolean isOrganismNameUnique(Long oid, String name);
}
