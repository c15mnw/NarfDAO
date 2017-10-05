package com.roslin.mwicks.spring.narf.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.enums.EnumIncubation;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;
 

@Entity
@Table(name="ncs_embryo_order_line_incubation")
public class EmbryoOrderLineIncubation implements Serializable {
 
	@Id
	@Column(name = "nmoli_oid", nullable = false)
    private Long oid; 
 
    @Column(name = "nmoli_name", length=10, unique=true, nullable=false)
    private String name = EnumIncubation.ZEROPOINTFIVE.getEnumIncubation();


    public EmbryoOrderLineIncubation() {

    	this.oid = (long) 0;
    	this.name = "";
    }

    public EmbryoOrderLineIncubation(Long oid, String name) {

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
        if (!(obj instanceof EmbryoOrderLineIncubation))
            return false;
        EmbryoOrderLineIncubation other = (EmbryoOrderLineIncubation) obj;
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

    
    public int compareTo(EmbryoOrderLineIncubation o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByNameAsc implements Comparator<EmbryoOrderLineIncubation> {

        public int compare(EmbryoOrderLineIncubation embryolineorderlineincubation_o1, EmbryoOrderLineIncubation embryolineorderlineincubation_o2) {

        	return embryolineorderlineincubation_o1.name.compareTo(embryolineorderlineincubation_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<EmbryoOrderLineIncubation> {

        public int compare(EmbryoOrderLineIncubation embryolineorderlineincubation_o1, EmbryoOrderLineIncubation embryolineorderlineincubation_o2) {

        	return embryolineorderlineincubation_o2.name.compareTo(embryolineorderlineincubation_o1.name);
        }
    }

    public static class OrderByOidAsc implements Comparator<EmbryoOrderLineIncubation> {

        public int compare(EmbryoOrderLineIncubation embryolineorderlineincubation_o1, EmbryoOrderLineIncubation embryolineorderlineincubation_o2) {

        	return embryolineorderlineincubation_o1.oid.compareTo(embryolineorderlineincubation_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<EmbryoOrderLineIncubation> {

        public int compare(EmbryoOrderLineIncubation embryolineorderlineincubation_o1, EmbryoOrderLineIncubation embryolineorderlineincubation_o2) {

        	return embryolineorderlineincubation_o2.oid.compareTo(embryolineorderlineincubation_o1.oid);
        }
    }



}
