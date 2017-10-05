package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionBirdOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.BirdOrderLine;

import com.roslin.mwicks.spring.narf.repository.RepositoryBirdOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLine;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the BirdOrderLineService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryBirdOrderLine implements ServiceBirdOrderLine {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryBirdOrderLine repositorybirdorderline;

    
    @Transactional(readOnly = true)
    public BirdOrderLine findByOid(Long oid) {
    	
        BirdOrderLine birdorderline = repositorybirdorderline.findOne(oid);
		
        return birdorderline;
    }
    
    
    @Transactional
    public <T extends BirdOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionBirdOrderLineNotFound.class)
    public BirdOrderLine update(BirdOrderLine updated) throws ExceptionBirdOrderLineNotFound {
    	
        BirdOrderLine birdorderline = repositorybirdorderline.findOne( updated.getOid() );

    	if (birdorderline== null) {
        	
            throw new ExceptionBirdOrderLineNotFound("No birdorderlinefound with id: " + updated.getOid());
        }
        
    	birdorderline.update(
            	updated.getOid(),
            	updated.getRequired(),
            	updated.getSupplied(),
            	updated.getAge(),
            	updated.getBirdOrderLineSex(),
            	updated.getBirdOrderLineDateFormat(),
            	updated.getOrganism()
        		);

		repositorybirdorderline.save(birdorderline);

		return birdorderline;
    }
    
    

     
    @Transactional()
	public BirdOrderLine create(BirdOrderLine birdorderline) {
        
		return repositorybirdorderline.save(birdorderline);
	}


    @Transactional()
	public void save(BirdOrderLine birdorderline) {
        
		repositorybirdorderline.save(birdorderline);
	}


    @Transactional(rollbackFor = ExceptionBirdOrderLineNotFound.class)
	public void delete(BirdOrderLine birdorderline) {
        
		repositorybirdorderline.delete(birdorderline);
	}


    @Transactional(rollbackFor = ExceptionBirdOrderLineNotFound.class)
	public void deleteByOid(Long oid) {

		repositorybirdorderline.deleteByOid(oid);
	}


	@Transactional(readOnly = true)
	public List<BirdOrderLine> findAll() {

		List<BirdOrderLine> birdorderlines = repositorybirdorderline.findAll();
		
		return birdorderlines;
	}
	



	/**
     * This setter method should be used only by unit tests.
     * @param repositoryBirdOrderLine
     */
    protected void setRepositoryBirdOrderLine(RepositoryBirdOrderLine repositorybirdorderline) {
    	
        this.repositorybirdorderline = repositorybirdorderline;
    }


}
