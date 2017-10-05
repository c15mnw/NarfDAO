package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;

import com.roslin.mwicks.spring.narf.repository.RepositoryEmbryoOrderLineIncubation;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEmbryoOrderLineIncubation;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the LineService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryEmbryoOrderLineIncubation implements ServiceEmbryoOrderLineIncubation {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryEmbryoOrderLineIncubation repositoryembryoorderlineincubation;


    @Transactional
    public <T extends EmbryoOrderLineIncubation> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
    	final List<T> savedEntities = new ArrayList<T>(entities.size());
    	int i = 0;

    	for (T t : entities) {
    	    
    		savedEntities.add(persistOrMerge(t));
    		//entityManager.persist(t);

    		i++;
    	    
    		if (i % intBatchSize == 0) {

    			// Flush a batch of inserts and release memory.
    			entityManager.flush();
    			entityManager.clear();
    		}
    	}
    	
    	return savedEntities;
    }
    
    private <T extends EmbryoOrderLineIncubation> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public EmbryoOrderLineIncubation findByOid(Long oid) {
    	
        EmbryoOrderLineIncubation embryoorderlineincubation = repositoryembryoorderlineincubation.findOne(oid);
		
        return embryoorderlineincubation;
    }
    
     
    @Transactional(readOnly = true)
	public EmbryoOrderLineIncubation findByName(String name) {

    	EmbryoOrderLineIncubation embryoorderlineincubation = repositoryembryoorderlineincubation.findByName( name );
        
        return embryoorderlineincubation;
	}


	@Transactional(readOnly = true)
	public List<EmbryoOrderLineIncubation> findAll() {

		List<EmbryoOrderLineIncubation> embryoorderlineincubations = repositoryembryoorderlineincubation.findAll();
		
		return embryoorderlineincubations;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryEmbryoOrderLineIncubation repositoryembryoorderlineincubation) {
    	
        this.repositoryembryoorderlineincubation = repositoryembryoorderlineincubation;
    }

}
