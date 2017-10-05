package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainReferenceNotFound;
import com.roslin.mwicks.spring.narf.model.StrainReference;

import com.roslin.mwicks.spring.narf.repository.RepositoryStrainReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrainReference;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the StrainReferenceService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryStrainReference implements ServiceStrainReference {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryStrainReference repositorystrainreference;


	@Transactional(readOnly = true)
	public List<StrainReference> findAll() {

		return repositorystrainreference.findAll();
	}

	@Transactional(readOnly = true)
	public List<StrainReference> findAllByUrl( String url ) {

		return repositorystrainreference.findAllByUrl( url );
	}
    @Transactional(readOnly = true)
    public StrainReference findByOid(Long oid) {
    	
        return repositorystrainreference.findOne(oid);
    }
    @Transactional(readOnly = true)
	public StrainReference findByReference(String reference) {

        StrainReference strainreference = repositorystrainreference.findByReference( reference );

        return strainreference;
	}
	public boolean isStrainReferenceReferenceUnique(Long oid, String reference) {

		StrainReference strainreference = findByReference(reference);
	    
		return ( strainreference == null || ( ( oid != null ) && ( strainreference.getOid() == oid ) ) );
	}

    @Transactional()
	public void save(StrainReference strainreference) {
        
		repositorystrainreference.save(strainreference);
	}
    
    @Transactional(rollbackFor = ExceptionStrainReferenceNotFound.class)
	public void delete(StrainReference strainreference) {
        
		repositorystrainreference.delete(strainreference);
	}
    
    @Transactional(rollbackFor = ExceptionStrainReferenceNotFound.class)
    public StrainReference update(StrainReference updated) throws ExceptionStrainReferenceNotFound {
    	
        StrainReference strainreference = repositorystrainreference.findOne( updated.getOid() );
        
        if (strainreference == null) {
        	
            throw new ExceptionStrainReferenceNotFound("No strainreference found with id: " + updated.getOid());
        }
        
        strainreference.update(
            	updated.getOid(),
            	updated.getReference(),
            	updated.getUrl()
        		);
        
        repositorystrainreference.save(strainreference);

        return strainreference;
    }
    @Transactional(rollbackFor = ExceptionStrainReferenceNotFound.class)
	public void deleteByOid(Long oid) {

		repositorystrainreference.deleteByOid(oid);
	}
    @Transactional(rollbackFor = ExceptionStrainReferenceNotFound.class)
	public void deleteByReference(String reference) {

		repositorystrainreference.deleteByReference(reference);
	}

    @Transactional
    public <T extends StrainReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    /**
     * This setter method should be used only by unit tests.
     * @param repositoryStrainReference
     */
    protected void setRepositoryStrainReference(RepositoryStrainReference repositorystrainreference) {
    	
        this.repositorystrainreference = repositorystrainreference;
    }

}
