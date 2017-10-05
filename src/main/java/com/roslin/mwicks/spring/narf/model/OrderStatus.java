package com.roslin.mwicks.spring.narf.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.enums.EnumOrderStatus;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;
 

@Entity
@Table(name="ncs_order_status")
public class OrderStatus implements Serializable {
 
	@Id
	@Column(name = "ncos_oid", nullable = false)
    private Long oid; 
 
    @Column(name = "ncos_status_name", length=100, unique=true, nullable=false)
    private String name = EnumOrderStatus.NEW.getEnumOrderStatus();


    public OrderStatus() {

    	this.oid = (long) 0;
    	this.name = "";
    }

    public OrderStatus(Long oid, String name) {

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

    
    public boolean isNew() {
    	
    	if ( this.name.equals(EnumOrderStatus.NEW.getEnumOrderStatus())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isPendingGreenwood() {
    	
    	if ( this.name.equals(EnumOrderStatus.PENDING_GREENWOOD.getEnumOrderStatus())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isPendingBumstead() {
    	
    	if ( this.name.equals(EnumOrderStatus.PENDING_BUMSTEAD.getEnumOrderStatus())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isClosed() {
    	
    	if ( this.name.equals(EnumOrderStatus.CLOSED.getEnumOrderStatus())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isCancelled() {
    	
    	if ( this.name.equals(EnumOrderStatus.CANCELLED.getEnumOrderStatus())) {
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof OrderStatus))
            return false;
        OrderStatus other = (OrderStatus) obj;
        if (oid == null) {
            if (other.oid != null)
                return false;
        } else if (!oid.equals(other.oid))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    
    public int compareTo(OrderStatus o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByNameAsc implements Comparator<OrderStatus> {

        public int compare(OrderStatus linemhc_o1, OrderStatus linemhc_o2) {

        	return linemhc_o1.name.compareTo(linemhc_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<OrderStatus> {

        public int compare(OrderStatus linemhc_o1, OrderStatus linemhc_o2) {

        	return linemhc_o2.name.compareTo(linemhc_o1.name);
        }
    }

    public static class OrderByOidAsc implements Comparator<OrderStatus> {

        public int compare(OrderStatus orderstatus_o1, OrderStatus orderstatus_o2) {

        	return orderstatus_o1.oid.compareTo(orderstatus_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<OrderStatus> {

        public int compare(OrderStatus orderstatus_o1, OrderStatus orderstatus_o2) {

        	return orderstatus_o2.oid.compareTo(orderstatus_o1.oid);
        }
    }


}
