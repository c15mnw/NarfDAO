package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionEggOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.EggOrderLine;

import com.roslin.mwicks.spring.narf.repository.RepositoryEggOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEggOrderLine;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the EggOrderLineService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryEggOrderLine implements ServiceEggOrderLine {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryEggOrderLine repositoryeggorderline;

    
    @Transactional(readOnly = true)
    public EggOrderLine findByOid(Long oid) {
    	
        EggOrderLine eggorderline = repositoryeggorderline.findOne(oid);
		
        return eggorderline;
    }
    
    
    @Transactional
    public <T extends EggOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionEggOrderLineNotFound.class)
    public EggOrderLine update(EggOrderLine updated) throws ExceptionEggOrderLineNotFound {
    	
        EggOrderLine eggorderline = repositoryeggorderline.findOne( updated.getOid() );

    	if (eggorderline== null) {
        	
            throw new ExceptionEggOrderLineNotFound("No eggorderlinefound with id: " + updated.getOid());
        }
        
    	eggorderline.update(
            	updated.getOid(),
            	updated.getRequired(),
            	updated.getSupplied(),
            	updated.getEggOrderLineFertilised(),
            	updated.getOrganism()
        		);

		repositoryeggorderline.save(eggorderline);

		return eggorderline;
    }

     
    @Transactional()
	public void save(EggOrderLine eggorderline) {
        
		repositoryeggorderline.save(eggorderline);
	}


    @Transactional()
	public EggOrderLine create(EggOrderLine eggorderline) {
        
		return repositoryeggorderline.save(eggorderline);
	}

    
    @Transactional(rollbackFor = ExceptionEggOrderLineNotFound.class)
	public void delete(EggOrderLine eggorderline) {
        
		repositoryeggorderline.delete(eggorderline);
	}


    @Transactional(rollbackFor = ExceptionEggOrderLineNotFound.class)
	public void deleteByOid(Long oid) {

		repositoryeggorderline.deleteByOid(oid);
	}


	@Transactional(readOnly = true)
	public List<EggOrderLine> findAll() {

		List<EggOrderLine> eggorderlines = repositoryeggorderline.findAll();
		
		return eggorderlines;
	}


	/**
     * This setter method should be used only by unit tests.
     * @param repositoryEggOrderLine
     */
    protected void setRepositoryEggOrderLine(RepositoryEggOrderLine repositoryeggorderline) {
    	
        this.repositoryeggorderline = repositoryeggorderline;
    }


}
