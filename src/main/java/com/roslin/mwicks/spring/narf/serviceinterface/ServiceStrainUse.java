package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainUseNotFound;

import com.roslin.mwicks.spring.narf.model.StrainUse;


/**
 * Declares methods used to obtain and modify Strain information.
 * @author Mike Wicks
 */
public interface ServiceStrainUse {
	
    public List<StrainUse> findAll(); 

    public StrainUse findByOid(Long oid);
    public StrainUse findByUse(String use);
    public StrainUse findByProtocol(String protocol);

    boolean isStrainUseUseUnique(Long oid, String use);

    public void save(StrainUse strainuse);
    
    public StrainUse update(StrainUse strainuse) throws ExceptionStrainUseNotFound;
    
    public void delete(StrainUse strainuse) throws ExceptionStrainUseNotFound;
    
    public void deleteByOid(Long oid) throws ExceptionStrainUseNotFound;
    public void deleteByUse(String use) throws ExceptionStrainUseNotFound;
    public void deleteByProtocol(String protocol) throws ExceptionStrainUseNotFound;

    public <T extends StrainUse> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
}
