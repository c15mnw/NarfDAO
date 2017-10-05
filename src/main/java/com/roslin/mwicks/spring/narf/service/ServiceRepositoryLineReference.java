package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionLineReferenceNotFound;
import com.roslin.mwicks.spring.narf.model.LineReference;

import com.roslin.mwicks.spring.narf.repository.RepositoryLineReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineReference;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the LineReferenceService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryLineReference implements ServiceLineReference {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryLineReference repositorylinereference;

    
    @Transactional(readOnly = true)
    public LineReference findByOid(Long oid) {
    	
        return repositorylinereference.findOne(oid);
    }
    
    
    @Transactional
    public <T extends LineReference> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionLineReferenceNotFound.class)
    public LineReference update(LineReference updated) throws ExceptionLineReferenceNotFound {
    	
        LineReference linereference = repositorylinereference.findOne( updated.getOid() );
        
        if (linereference == null) {
        	
            throw new ExceptionLineReferenceNotFound("No linereference found with id: " + updated.getOid());
        }
        
        linereference.update(
            	updated.getOid(),
            	updated.getReference(),
            	updated.getUrl()
        		);

        repositorylinereference.save(linereference);
        
        return linereference;
    }
    
    

     
    @Transactional(readOnly = true)
	public LineReference findByReference(String reference) {

        LineReference linereference = repositorylinereference.findByReference( reference );

        return linereference;
	}


    @Transactional()
	public void save(LineReference linereference) {
        
		repositorylinereference.save(linereference);
	}


    @Transactional(rollbackFor = ExceptionLineReferenceNotFound.class)
	public void delete(LineReference linereference) {
        
		repositorylinereference.delete(linereference);
	}


    @Transactional(rollbackFor = ExceptionLineReferenceNotFound.class)
	public void deleteByOid(Long oid) {

		repositorylinereference.deleteByOid(oid);
	}


    @Transactional(rollbackFor = ExceptionLineReferenceNotFound.class)
	public void deleteByReference(String reference) {

		repositorylinereference.deleteByReference(reference);
	}


	@Transactional(readOnly = true)
	public List<LineReference> findAll() {

		return repositorylinereference.findAll();
	}
	

	@Transactional(readOnly = true)
	public List<LineReference> findAllByUrl( String url ) {

		return repositorylinereference.findAllByUrl( url );
	}


	public boolean isLineReferenceReferenceUnique(Long oid, String reference) {

		LineReference linereference = findByReference(reference);
	    
		return ( linereference == null || ( ( oid != null ) && ( linereference.getOid() == oid ) ) );
	}




	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLineReference
     */
    protected void setRepositoryLineReference(RepositoryLineReference repositorylinereference) {
    	
        this.repositorylinereference = repositorylinereference;
    }

}
