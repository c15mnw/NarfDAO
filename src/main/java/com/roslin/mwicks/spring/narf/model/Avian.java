package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Comparator;

import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single Avian Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_avian")
public class Avian implements Serializable, Comparable<Avian>{
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // ncl_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nav_oid", nullable = true)
    private Long oid;
    
    // ncl_name varchar(255)
    @Column(name = "nav_name", nullable = false)
    private String name;

    
    @Column(name = "nav_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "nav_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "nav_version", nullable = false)
    private long version;
    
    
    
    // Constructor --------------------------------------------------------------------------------
    public Avian() {

    	this.name = "";
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getName() {
    	return this.name;
    }

    public Date getCreationTime() {
    	return this.creationTime;
    }
    public Date getModificationTime() {
    	return this.modificationTime;
    }
    public long getVersion() {
        return this.version;
    }
 
    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setName(String name) {
    	this.name = name;
    }

    public void setCreationTime(Date creationTime) {
    	this.creationTime = creationTime;
    }
    public void setModificationTime(Date modificationTime) {
    	this.modificationTime = modificationTime;
    }
    public void setVersion(long version) {
    	this.version = version;
    }


    // Getters As Strings -------------------------------------------------------------------------
    public String getOidAsString() {
    	return ObjectConverter.convert(this.oid, String.class);
    }
    public String getCreationTimeAsString() {
    	return ObjectConverter.convert(this.creationTime, String.class);
    }
    public String getModificationTimeAsString() {
    	return ObjectConverter.convert(this.modificationTime, String.class);
    }
    public String getVersionAsString() {
    	return ObjectConverter.convert(this.version, String.class);
    }
    
    
    // Setters From Strings -----------------------------------------------------------------------
    public void setCreationTimeFromString(String creationTime) {
    	this.creationTime = ObjectConverter.convert(creationTime, Date.class);
    }
    public void setModificationTimeFromString(String modificationTime) {
    	this.modificationTime = ObjectConverter.convert(modificationTime, Date.class);
    }

    
    // Helpers ------------------------------------------------------------------------------------
    

    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Avian name){

        if (this.getOid().equals(name.getOid()) && 
        		this.getName().equals(name.getName()) 
        	    ) {

        	return true;
        }
        else {

        	return false;
        }
    }

    /*
     * The OID is unique for each Component.
     *  So this should compare Component by OID only.
     */
    @Override
    public boolean equals(Object other) {
    	
        return (other instanceof Avian) && (this.getOid() != null) ? this.getOid().equals(((Avian) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String name
    		) {

    	this.oid = oid;
    	this.name = name;
    }
    
    @PreUpdate
    public void preUpdate() {
    	
    	this.modificationTime = new Date();
    }
    
    @PrePersist
    public void prePersist() {
    	
        Date now = new Date();
        
        this.creationTime = now;
        this.modificationTime = now;
    }

    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    // Avian Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Avian objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String name
    		) {
    	
        return new Builder(
        		oid,
        		name
        		);
    }
    
    /**
     * A Builder class used to create new Avian objects.
     */
    public static class Builder {
    	
        Avian built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String name
        		) {
        	
            built = new Avian();
            
        	built.oid = oid;
        	built.name = name;
        }

        /**
         * Builds the new Avian object.
         * 
         * @return this. The created Avian object.
         */
        public Avian build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.name == null ) ? 0 : this.name.hashCode() );

    	return result;
    }
    

    public int compareTo(Avian o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByNameAsc implements Comparator<Avian> {

        public int compare(Avian name_o1, Avian name_o2) {

        	return name_o1.name.compareTo(name_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<Avian> {

        public int compare(Avian name_o1, Avian name_o2) {

        	return name_o2.name.compareTo(name_o1.name);
        }
    }

}
