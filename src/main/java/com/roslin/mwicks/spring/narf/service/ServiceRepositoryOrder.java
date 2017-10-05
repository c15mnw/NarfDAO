package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionOrderNotFound;

import com.roslin.mwicks.spring.narf.model.Order;
import com.roslin.mwicks.spring.narf.model.OrderStatus;

import com.roslin.mwicks.spring.narf.repository.RepositoryOrder;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrder;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * This implementation of the OrderService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryOrder implements ServiceOrder {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryOrder repositoryorder;

    
    @Transactional(readOnly = true)
    public Order findByOid(Long oid) {
    	
        Order order = repositoryorder.findOne(oid);
		
		return order;
    }
    
    
    @Transactional
    public <T extends Order> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionOrderNotFound.class)
    public Order update(Order updated) throws ExceptionOrderNotFound {
    	
        Order order = repositoryorder.findOne( updated.getOid() );

    	if (order == null) {
        	
            throw new ExceptionOrderNotFound("No order found with id: " + updated.getOid());
        }
        
    	order.update(
            	updated.getOid(),
            	updated.getRequiredDate(),
            	updated.getSuppliedDate(),
            	updated.getStudy(),
            	updated.getCode(),
            	updated.getCustomerComment(),
            	updated.getSupplierComment(),
        		updated.getBirdOrderLines(),
        		updated.getEggOrderLines(),
        		updated.getEmbryoOrderLines(),
        		updated.getOrderStatus(),
            	updated.getOrderCollection(),
        		updated.getOrderType(),
            	updated.getCustomer(),
            	updated.getEditor(),
            	updated.getSupplier()
        		);
    	
    	repositoryorder.save(order);

    	return order;
    }
     

    @Transactional()
	public void save(Order order) {
        
		repositoryorder.save(order);
	}


    @Transactional()
	public Order create(Order order) {
        
		return repositoryorder.save(order);
	}


    @Transactional(rollbackFor = ExceptionOrderNotFound.class)
	public void delete(Order order) {
        
		repositoryorder.delete(order);
	}


    @Transactional(rollbackFor = ExceptionOrderNotFound.class)
	public void deleteByOid(Long oid) {

		repositoryorder.deleteByOid(oid);
	}


	@Transactional(readOnly = true)
	public List<Order> findAll() {

		List<Order> orders = repositoryorder.findAll();
		
		return orders;
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAllStatus( OrderStatus orderstatus ) {

		List<Order> orders = repositoryorder.findAll();
		List<Order> ordersout = new ArrayList<Order>();

    	Iterator<Order> iteratorOrder = orders.iterator();
        
     	while (iteratorOrder.hasNext()) {
    		
     		Order Order = iteratorOrder.next();
     		
     		if ( Order.getOrderStatus().equals( orderstatus ) ) {
     			
     			ordersout.add( Order ) ;
     		}

     	}
		
		return ordersout;
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAllByCustomer(Long customer) {

		List<Order> orders = repositoryorder.findAllByCustomer(customer);
		
		return orders;
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAllByCustomerAndStatus( Long customer, OrderStatus orderstatus ) {

		List<Order> orders = repositoryorder.findAllByCustomerAndStatus( customer, orderstatus );
		
		return orders;
	}
	
	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryOrder
     */
    protected void setRepositoryOrder(RepositoryOrder repositoryorder) {
    	
        this.repositoryorder = repositoryorder;
    }

}
