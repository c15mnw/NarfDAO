package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainNotFound;

import com.roslin.mwicks.spring.narf.model.Strain;
import com.roslin.mwicks.spring.narf.model.StrainReference;
import com.roslin.mwicks.spring.narf.model.StrainUse;


/**
 * Declares methods used to obtain and modify Strain information.
 * @author Mike Wicks
 */
public interface ServiceStrain {

	public List<Strain> findAllByStrainReference( StrainReference inStrainReference ); 
	public List<Strain> findAllByStrainUse( StrainUse inStrainUse ); 

	public List<Strain> findAllByStrainAndStrainUse( String strain, StrainUse inStrainUse ); 

	public List<Strain> findAllByStrain( String strain );

	public List<Strain> findAll(); 

    public Strain findByOid(Long oid);
    public Strain findByStrain(String strain);

    boolean isStrainNameUnique(Long oid, String name);

    public void save(Strain strain);

    public Strain update(Strain strain) throws ExceptionStrainNotFound;
    
    public void delete(Strain strain) throws ExceptionStrainNotFound;

    public void deleteByOid(Long oid) throws ExceptionStrainNotFound;
    public void deleteByStrain(String strain) throws ExceptionStrainNotFound;
    
	public <T extends Strain> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
}
