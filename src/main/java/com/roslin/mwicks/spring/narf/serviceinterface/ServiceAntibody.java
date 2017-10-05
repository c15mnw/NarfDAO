package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionAntibodyNotFound;

import com.roslin.mwicks.spring.narf.model.Antibody;
import com.roslin.mwicks.spring.narf.model.AntibodyReference;


/**
 * Declares methods used to obtain and modify Antibody information.
 * @author Mike Wicks
 */
public interface ServiceAntibody {

	public <T extends Antibody> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
	public List<Antibody> findAllByAntibodyReference( AntibodyReference inAntibodyReference );

    public Antibody findByOid(Long oid);
    public Antibody findByName(String name);

    public List<Antibody> findAll(); 

	public List<Antibody> findAllByAntigen(String antigen);
	public List<Antibody> findAllByAntigenSearch(String antigenSearch);
	public List<Antibody> findAllByIsotype(String isotype);
	public List<Antibody> findAllBySpecies(String species);
	public List<Antibody> findAllByApplication(String application);
	public List<Antibody> findAllBySupplier(String supplier);
	public List<Antibody> findAllByProductCode(String productCode);
	public List<Antibody> findAllByWebsite(String website);

    public void save(Antibody antibody);

    public Antibody update(Antibody antibody) throws ExceptionAntibodyNotFound;

    public void delete(Antibody antibody) throws ExceptionAntibodyNotFound;

    public void deleteByName(String naw) throws ExceptionAntibodyNotFound;
    
    boolean isAntibodyNameUnique(Long oid, String name);
}
