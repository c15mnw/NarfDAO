package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.OrderCollection;

import com.roslin.mwicks.spring.narf.repository.RepositoryOrderCollection;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderCollection;

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
public class ServiceRepositoryOrderCollection implements ServiceOrderCollection {
  
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryOrderCollection repositoryordercollection;


    @Transactional
    public <T extends OrderCollection> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends OrderCollection> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public OrderCollection findByOid(Long oid) {
    	
        OrderCollection linemhc = repositoryordercollection.findOne(oid);
		
        return linemhc;
    }
    
     
    @Transactional(readOnly = true)
	public OrderCollection findByName(String name) {

    	OrderCollection linemhc = repositoryordercollection.findByName( name );
        
        return linemhc;
	}


	@Transactional(readOnly = true)
	public List<OrderCollection> findAll() {

		List<OrderCollection> linemhcs = repositoryordercollection.findAll();
		
		return linemhcs;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryOrderCollection repositoryordercollection) {
    	
        this.repositoryordercollection = repositoryordercollection;
    }

}
