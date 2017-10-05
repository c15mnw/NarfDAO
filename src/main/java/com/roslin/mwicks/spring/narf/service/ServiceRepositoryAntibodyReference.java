package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionAntibodyReferenceNotFound;
import com.roslin.mwicks.spring.narf.model.AntibodyReference;

import com.roslin.mwicks.spring.narf.repository.RepositoryAntibodyReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceAntibodyReference;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the AntibodyReferenceService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryAntibodyReference implements ServiceAntibodyReference {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryAntibodyReference repositoryantibodyreference;

    
    @Transactional(readOnly = true)
    public AntibodyReference findByOid(Long oid) {
    	
        return repositoryantibodyreference.findOne(oid);
    }
    
    
    @Transactional
    public <T extends AntibodyReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionAntibodyReferenceNotFound.class)
    public AntibodyReference update(AntibodyReference updated) throws ExceptionAntibodyReferenceNotFound {
    	
        AntibodyReference antibodyreference = repositoryantibodyreference.findOne( updated.getOid() );
        
        if (antibodyreference == null) {
        	
            throw new ExceptionAntibodyReferenceNotFound("No antibodyreference found with id: " + updated.getOid());
        }
        
        antibodyreference.update(
            	updated.getOid(),
            	updated.getReference(),
            	updated.getUrl()
        		);

		repositoryantibodyreference.save(antibodyreference);

        return antibodyreference;
    }
    
    

     
    @Transactional(readOnly = true)
	public AntibodyReference findByReference(String reference) {

        AntibodyReference antibodyreference = repositoryantibodyreference.findByReference( reference );

        return antibodyreference;
	}


    @Transactional()
	public void save(AntibodyReference antibodyreference) {
        
		repositoryantibodyreference.save(antibodyreference);
	}


    @Transactional(rollbackFor = ExceptionAntibodyReferenceNotFound.class)
	public void deleteByOid(Long oid) {

		repositoryantibodyreference.deleteByOid(oid);
	}


    @Transactional(rollbackFor = ExceptionAntibodyReferenceNotFound.class)
	public void deleteByReference(String reference) {

		repositoryantibodyreference.deleteByReference(reference);
	}


	@Transactional(readOnly = true)
	public List<AntibodyReference> findAll() {

		return repositoryantibodyreference.findAll();
	}
	

	@Transactional(readOnly = true)
	public List<AntibodyReference> findAllByUrl( String url ) {

		return repositoryantibodyreference.findAllByUrl( url );
	}


	public boolean isAntibodyReferenceReferenceUnique(Long oid, String reference) {

		AntibodyReference antibodyreference = findByReference(reference);
	    
		return ( antibodyreference == null || ( ( oid != null ) && ( antibodyreference.getOid() == oid ) ) );
	}




	/**
     * This setter method should be used only by unit tests.
     * @param repositoryAntibodyReference
     */
    protected void setRepositoryAntibodyReference(RepositoryAntibodyReference repositoryantibodyreference) {
    	
        this.repositoryantibodyreference = repositoryantibodyreference;
    }

}
