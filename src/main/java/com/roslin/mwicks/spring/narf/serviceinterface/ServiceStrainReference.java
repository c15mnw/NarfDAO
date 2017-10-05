package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainReferenceNotFound;

import com.roslin.mwicks.spring.narf.model.StrainReference;


/**
 * Declares methods used to obtain and modify Strain information.
 * @author Mike Wicks
 */
public interface ServiceStrainReference {
	
    public List<StrainReference> findAll(); 

    public StrainReference findByOid(Long oid);
    public StrainReference findByReference(String reference);
	public List<StrainReference> findAllByUrl( String url );

    boolean isStrainReferenceReferenceUnique(Long oid, String reference);

    public void save(StrainReference linereference);
    
    public StrainReference update(StrainReference linereference) throws ExceptionStrainReferenceNotFound;
    
    public void delete(StrainReference linereference) throws ExceptionStrainReferenceNotFound;
    
    public void deleteByOid(Long oid) throws ExceptionStrainReferenceNotFound;
    public void deleteByReference(String reference) throws ExceptionStrainReferenceNotFound;
    
	public <T extends StrainReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
}
