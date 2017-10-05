package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainNotFound;

import com.roslin.mwicks.spring.narf.model.Strain;
import com.roslin.mwicks.spring.narf.model.StrainReference;
import com.roslin.mwicks.spring.narf.model.StrainUse;

import com.roslin.mwicks.spring.narf.repository.RepositoryStrain;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrain;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the StrainService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryStrain implements ServiceStrain {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryStrain repositorystrain;

    
	@Transactional(readOnly = true)
	public List<Strain> findAll() {

		List<Strain> strains = repositorystrain.findAll();
		
		return strains;
	}

	
	@Transactional(readOnly = true)
    public Strain findByOid(Long oid) {
    	
        Strain strain = repositorystrain.findOne(oid);
		
        return repositorystrain.findOne(oid);
    }

	
	@Transactional(readOnly = true)
	public Strain findByStrain(String strainIn) {

        Strain strain = repositorystrain.findByStrain(strainIn);
        
        return strain;
	}

	
	@Transactional(readOnly = true)
	public List<Strain> findAllByStrain( String strain ) {

		List<Strain> strains = repositorystrain.findAllByStrain( strain );
		
		return strains;
	}

	
	@Transactional(readOnly = true)
	public List<Strain> findAllByStrainLong( String strainLong ) {

		List<Strain> strains = repositorystrain.findAllByStrainLong( strainLong );
		
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByProtein( String protein ) {

		List<Strain> strains = repositorystrain.findAllByProtein( protein );
        
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllBySpectra( String spectra ) {

		List<Strain> strains = repositorystrain.findAllBySpectra( spectra );
        
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByPattern( String pattern ) {

		List<Strain> strains = repositorystrain.findAllByPattern( pattern );
		
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByAvailability( String availability ) {

		List<Strain> strains = repositorystrain.findAllByAvailability( availability );
		
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByDescription( String description ) {

		List<Strain> strains = repositorystrain.findAllByDescription( description );
		
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByContact( String contact ) {

		List<Strain> strains = repositorystrain.findAllByContact( contact );
		
		return strains;
	}
	
	
	@Transactional(readOnly = true)
	public List<Strain> findAllByPrice( String price ) {

		List<Strain> strains = repositorystrain.findAllByPrice( price );
		
		return strains;
	}

	
	public boolean isStrainNameUnique(Long oid, String name) {

		Strain strain = findByStrain(name);
	    
		return ( strain == null || ( ( oid != null ) && ( strain.getOid() == oid ) ) );
	}

	
    @Transactional()
	public void save(Strain strain) {
        
		repositorystrain.save(strain);
	}
    
    
    @Transactional(rollbackFor = ExceptionStrainNotFound.class)
    public Strain update(Strain updated) throws ExceptionStrainNotFound {
    	
        Strain strain = repositorystrain.findOne( updated.getOid() );

    	if (strain == null) {
        	
            throw new ExceptionStrainNotFound("No strain found with id: " + updated.getOid());
        }
        
    	strain.update(
            	updated.getOid(),
            	updated.getStrain(),
            	updated.getStrainLong(),
            	updated.getProtein(),
            	updated.getSpectra(),
            	updated.getPattern(),
            	updated.getAvailability(),
            	updated.getDescription(),
        		updated.getContact(),
            	updated.getPrice(),
        		updated.getStrainReferences(),
        		updated.getStrainUses()
        		);

    	repositorystrain.save(strain);
    	
    	return strain;
    }
    
    
    @Transactional(rollbackFor = ExceptionStrainNotFound.class)
	public void delete(Strain strain) {

		repositorystrain.delete(strain);
	}
    
    
    @Transactional(rollbackFor = ExceptionStrainNotFound.class)
	public void deleteByOid(Long oid) {

		repositorystrain.deleteByOid(oid);
	}
    
    
    @Transactional(rollbackFor = ExceptionStrainNotFound.class)
	public void deleteByStrain(String strain) {

		repositorystrain.deleteByStrain(strain);
	}
    

    @Transactional
    public <T extends Strain> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
    	final List<T> savedEntities = new ArrayList<T>(entities.size());
    	int i = 0;

    	for (T t : entities) {
    	    
    		//savedEntities.add(persistOrMerge(t));
    		entityManager.persist(t);

    		i++;
    	    
    		if (i % intBatchSize == 0) {

    			// Flush a batch of inserts and release memory.
    			entityManager.flush();
    			entityManager.clear();
    		}
    	}
    	
    	return savedEntities;
    }


    @Transactional(readOnly = true)
	public List<Strain> findAllByStrainReference( StrainReference inStrainReference ) {

		List<Strain> strains = repositorystrain.findAllByStrainReference( inStrainReference );
		
		return strains;
	}

    
    @Transactional(readOnly = true)
	public List<Strain> findAllByStrainUse( StrainUse inStrainUse ) {

		List<Strain> strains = repositorystrain.findAllByStrainUse( inStrainUse );
		
		return strains;
	}

    
	@Transactional(readOnly = true)
	public List<Strain> findAllByStrainAndStrainUse(String strain, StrainUse inStrainUse) {

		List<Strain> strains = repositorystrain.findAllByStrainAndStrainUse( strain, inStrainUse );
		
		return strains;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryStrain
     */
    protected void setRepositoryStrain(RepositoryStrain repositorystrain) {
    	
        this.repositorystrain = repositorystrain;
    }

}
