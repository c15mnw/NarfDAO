package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionAntibodyReferenceNotFound;

import com.roslin.mwicks.spring.narf.model.AntibodyReference;


/**
 * Declares methods used to obtain and modify Antibody information.
 * @author Mike Wicks
 */
public interface ServiceAntibodyReference {
	
	public <T extends AntibodyReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public AntibodyReference findByOid(Long oid);
    public AntibodyReference findByReference(String reference);

    public List<AntibodyReference> findAll(); 

	public List<AntibodyReference> findAllByUrl( String url );

    public void save(AntibodyReference antibodyreference);

    public AntibodyReference update(AntibodyReference antibodyreference) throws ExceptionAntibodyReferenceNotFound;
    
    public void deleteByOid(Long oid) throws ExceptionAntibodyReferenceNotFound;
    public void deleteByReference(String reference) throws ExceptionAntibodyReferenceNotFound;
    
    boolean isAntibodyReferenceReferenceUnique(Long oid, String reference);
}
