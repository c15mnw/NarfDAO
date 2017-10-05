package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionLineReferenceNotFound;

import com.roslin.mwicks.spring.narf.model.LineReference;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceLineReference {
	
	public <T extends LineReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public LineReference findByOid(Long oid);
    public LineReference findByReference(String reference);

    public List<LineReference> findAll(); 

	public List<LineReference> findAllByUrl( String url );

    public void save(LineReference linereference);

    public LineReference update(LineReference linereference) throws ExceptionLineReferenceNotFound;
    
    public void delete(LineReference linereference) throws ExceptionLineReferenceNotFound;

    public void deleteByOid(Long oid) throws ExceptionLineReferenceNotFound;
    public void deleteByReference(String reference) throws ExceptionLineReferenceNotFound;
    
    boolean isLineReferenceReferenceUnique(Long oid, String reference);
}
