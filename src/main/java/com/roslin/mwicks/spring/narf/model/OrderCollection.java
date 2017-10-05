package com.roslin.mwicks.spring.narf.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.enums.EnumOrderCollection;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;
 

@Entity
@Table(name="ncs_order_collection")
public class OrderCollection implements Serializable {
 
	@Id
	@Column(name = "ncoc_oid", nullable = false)
    private Long oid; 
 
    @Column(name = "ncoc_collection_name", length=100, unique=true, nullable=false)
    private String name = EnumOrderCollection.UNKNOWN.getEnumOrderCollection();


    public OrderCollection() {

    	this.oid = (long) 0;
    	this.name = "";
    }

    public OrderCollection(Long oid, String name) {

    	this.oid = oid;
    	this.name = name;
    }

    
    public Long getOid() {
    	return oid;
    }
    public String getName() {
        return name;
    }


    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public boolean isCollectionUnknown() {
    	
    	if ( this.name.equals(EnumOrderCollection.UNKNOWN.getEnumOrderCollection())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isCollectionCourierNarf() {
    	
    	if ( this.name.equals(EnumOrderCollection.COURIER_NARF.getEnumOrderCollection())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isCollectionPickupInPerson() {
    	
    	if ( this.name.equals(EnumOrderCollection.PICKUP_IN_PERSON.getEnumOrderCollection())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isCollectionCourierCustomer() {
    	
    	if ( this.name.equals(EnumOrderCollection.COURIER_CUSTOMER.getEnumOrderCollection())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oid == null) ? 0 : oid.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
    	
        if (this == obj) {
        	
            return true;
        }
        
        if (obj == null) {
        	
            return false;
        }
        
        if (!(obj instanceof OrderCollection)) {
        	
            return false;
        }
        
        OrderCollection other = (OrderCollection) obj;
        
        if (oid == null) {

        	if (other.oid != null) {
            	
                return false;
            }
        } 
        else if (!oid.equals(other.oid)) {
        	
            return false;
        }
        
        if (name == null) {

        	if (other.name != null) {
            	
                return false;
            }
        } 
        else if (!name.equals(other.name)) {
        	
            return false;
        }
        
        return true;
    }
 
    @Override
    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    
    public int compareTo(OrderCollection o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByNameAsc implements Comparator<OrderCollection> {

        public int compare(OrderCollection linemhc_o1, OrderCollection linemhc_o2) {

        	return linemhc_o1.name.compareTo(linemhc_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<OrderCollection> {

        public int compare(OrderCollection linemhc_o1, OrderCollection linemhc_o2) {

        	return linemhc_o2.name.compareTo(linemhc_o1.name);
        }
    }

    public static class OrderByOidAsc implements Comparator<OrderCollection> {

        public int compare(OrderCollection orderstatus_o1, OrderCollection orderstatus_o2) {

        	return orderstatus_o1.oid.compareTo(orderstatus_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<OrderCollection> {

        public int compare(OrderCollection orderstatus_o1, OrderCollection orderstatus_o2) {

        	return orderstatus_o2.oid.compareTo(orderstatus_o1.oid);
        }
    }


}
