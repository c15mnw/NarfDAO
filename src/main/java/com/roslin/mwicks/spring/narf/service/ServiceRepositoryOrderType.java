package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.OrderType;

import com.roslin.mwicks.spring.narf.repository.RepositoryOrderType;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderType;

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
public class ServiceRepositoryOrderType implements ServiceOrderType {
  
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryOrderType repositoryordertype;


    @Transactional
    public <T extends OrderType> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends OrderType> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public OrderType findByOid(Long oid) {
    	
        OrderType ordertype = repositoryordertype.findOne(oid);
		
        return ordertype;
    }
    
     
    @Transactional(readOnly = true)
	public OrderType findByName(String name) {

    	OrderType ordertype = repositoryordertype.findByName( name );
        
        return ordertype;
	}


	@Transactional(readOnly = true)
	public List<OrderType> findAll() {

		List<OrderType> ordertypes = repositoryordertype.findAll();
		
		return ordertypes;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryOrderType repositoryordertype) {
    	
        this.repositoryordertype = repositoryordertype;
    }

}
