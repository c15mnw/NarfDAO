package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionOrderNotFound;

import com.roslin.mwicks.spring.narf.model.Order;
import com.roslin.mwicks.spring.narf.model.OrderStatus;


/**
 * Declares methods used to obtain and modify Order information.
 * @author Mike Wicks
 */
public interface ServiceOrder {


	public <T extends Order> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public Order findByOid(Long oid);

    public List<Order> findAll(); 

    public List<Order> findAllStatus( OrderStatus orderstatus ); 

    public List<Order> findAllByCustomer( Long customer ); 

    public List<Order> findAllByCustomerAndStatus( Long customer, OrderStatus orderstatus ) ; 

    public Order create(Order order);

    public void save(Order order);

    public void delete(Order order) throws ExceptionOrderNotFound;

    public Order update(Order order) throws ExceptionOrderNotFound;
    
    public void deleteByOid(Long oid) throws ExceptionOrderNotFound;
}
