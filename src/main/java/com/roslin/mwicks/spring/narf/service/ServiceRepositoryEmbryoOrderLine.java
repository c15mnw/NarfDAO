package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionEmbryoOrderLineNotFound;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLine;

import com.roslin.mwicks.spring.narf.repository.RepositoryEmbryoOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEmbryoOrderLine;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the EmbryoOrderLineService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryEmbryoOrderLine implements ServiceEmbryoOrderLine {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryEmbryoOrderLine repositoryembryoorderline;

    
    @Transactional(readOnly = true)
    public EmbryoOrderLine findByOid(Long oid) {
    	
        EmbryoOrderLine embryoorderline = repositoryembryoorderline.findOne(oid);
		
        return embryoorderline;
    }
    
    
    @Transactional
    public <T extends EmbryoOrderLine> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionEmbryoOrderLineNotFound.class)
    public EmbryoOrderLine update(EmbryoOrderLine updated) throws ExceptionEmbryoOrderLineNotFound {
    	
        EmbryoOrderLine embryoorderline = repositoryembryoorderline.findOne( updated.getOid() );

    	if (embryoorderline== null) {
        	
            throw new ExceptionEmbryoOrderLineNotFound("No embryoorderlinefound with id: " + updated.getOid());
        }
        
    	embryoorderline.update(
            	updated.getOid(),
            	updated.getRequired(),
            	updated.getSupplied(),
            	updated.getEmbryoOrderLineIncubation(),
            	updated.getOrganism()
        		);

		repositoryembryoorderline.save(embryoorderline);

		return embryoorderline;
    }
    
    

     
    @Transactional()
	public void save(EmbryoOrderLine embryoorderline) {
        
		repositoryembryoorderline.save(embryoorderline);
	}


    @Transactional()
	public EmbryoOrderLine create(EmbryoOrderLine embryoorderline) {
        
		return repositoryembryoorderline.save(embryoorderline);
	}


    @Transactional(rollbackFor = ExceptionEmbryoOrderLineNotFound.class)
	public void delete(EmbryoOrderLine embryoorderline) {
        
		repositoryembryoorderline.delete(embryoorderline);
	}


    @Transactional(rollbackFor = ExceptionEmbryoOrderLineNotFound.class)
	public void deleteByOid(Long oid) {

		repositoryembryoorderline.deleteByOid(oid);
	}


	@Transactional(readOnly = true)
	public List<EmbryoOrderLine> findAll() {

		List<EmbryoOrderLine> embryoorderlines = repositoryembryoorderline.findAll();
		
		return embryoorderlines;
	}
	

	/**
     * This setter method should be used only by unit tests.
     * @param repositoryEmbryoOrderLine
     */
    protected void setRepositoryEmbryoOrderLine(RepositoryEmbryoOrderLine repositoryembryoorderline) {
    	
        this.repositoryembryoorderline = repositoryembryoorderline;
    }


}
