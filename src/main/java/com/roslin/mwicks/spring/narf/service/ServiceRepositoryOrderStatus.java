package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.OrderStatus;

import com.roslin.mwicks.spring.narf.repository.RepositoryOrderStatus;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderStatus;

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
public class ServiceRepositoryOrderStatus implements ServiceOrderStatus {
  
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryOrderStatus repositoryorderstatus;


    @Transactional
    public <T extends OrderStatus> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends OrderStatus> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public OrderStatus findByOid(Long oid) {
    	
        OrderStatus orderstatus = repositoryorderstatus.findOne(oid);
		
        return orderstatus;
    }
    
     
    @Transactional(readOnly = true)
	public OrderStatus findByName(String name) {

    	OrderStatus orderstatus = repositoryorderstatus.findByName( name );
        
        return orderstatus;
	}


	@Transactional(readOnly = true)
	public List<OrderStatus> findAll() {

		List<OrderStatus> orderstatuss = repositoryorderstatus.findAll();
		
		return orderstatuss;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryOrderStatus repositoryorderstatus) {
    	
        this.repositoryorderstatus = repositoryorderstatus;
    }

}
