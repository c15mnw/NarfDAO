package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionStrainUseNotFound;
import com.roslin.mwicks.spring.narf.model.StrainUse;

import com.roslin.mwicks.spring.narf.repository.RepositoryStrainUse;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrainUse;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the StrainUseService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryStrainUse implements ServiceStrainUse {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryStrainUse repositorystrainuse;

    
	@Transactional(readOnly = true)
	public List<StrainUse> findAll() {

		return repositorystrainuse.findAll();
	}
	
    @Transactional(readOnly = true)
    public StrainUse findByOid(Long oid) {
    	
        return repositorystrainuse.findOne(oid);
    }
    @Transactional(readOnly = true)
	public StrainUse findByUse(String use) {

        StrainUse strainuse = repositorystrainuse.findByUse( use );

        return strainuse;
	}
    @Transactional(readOnly = true)
    public StrainUse findByProtocol(String protocol) {

    	StrainUse strainuse = repositorystrainuse.findByProtocol( protocol );

        return strainuse;
	}

	public boolean isStrainUseUseUnique(Long oid, String use) {

		StrainUse strainuse = findByUse(use);
	    
		return ( strainuse == null || ( ( oid != null ) && ( strainuse.getOid() == oid ) ) );
	}


    @Transactional()
	public void save(StrainUse strainuse) {
        
		repositorystrainuse.save(strainuse);
	}
    @Transactional(rollbackFor = ExceptionStrainUseNotFound.class)
    public StrainUse update(StrainUse updated) throws ExceptionStrainUseNotFound {
    	
        StrainUse strainuse = repositorystrainuse.findOne( updated.getOid() );
        
        if (strainuse == null) {
        	
            throw new ExceptionStrainUseNotFound("No strainuse found with id: " + updated.getOid());
        }
        
        strainuse.update(
            	updated.getOid(),
            	updated.getUse(),
            	updated.getProtocol()
        		);

        repositorystrainuse.save(strainuse);
        
        return strainuse;
    }
    
    @Transactional(rollbackFor = ExceptionStrainUseNotFound.class)
	public void delete(StrainUse strainuse) {

		repositorystrainuse.delete(strainuse);
	}
    
    @Transactional(rollbackFor = ExceptionStrainUseNotFound.class)
	public void deleteByOid(Long oid) {

		repositorystrainuse.deleteByOid(oid);
	}
    
    @Transactional(rollbackFor = ExceptionStrainUseNotFound.class)
	public void deleteByUse(String use) {

		repositorystrainuse.deleteByUse(use);
	}
	
    public void deleteByProtocol(String protocol) throws ExceptionStrainUseNotFound {

		repositorystrainuse.deleteByProtocol(protocol);
	}
	
    @Transactional
    public <T extends StrainUse> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
     * @param repositoryStrainUse
     */
    protected void setRepositoryStrainUse(RepositoryStrainUse repositorystrainuse) {
    	
        this.repositorystrainuse = repositorystrainuse;
    }

}
