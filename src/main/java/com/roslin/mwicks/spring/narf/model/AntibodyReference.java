package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Comparator;

import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single AntibodyReference Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_antibody_reference")
public class AntibodyReference implements Comparable<AntibodyReference>, Serializable {
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // ncl_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nar_oid", nullable = true)
    private Long oid;
    
    // ncl_reference varchar(255)
    @Column(name = "nar_reference", nullable = false)
    private String reference;
    
    // ncl_url varchar(255)
    @Column(name = "nar_url", nullable = false)
    private String url;
    
    @Column(name = "nar_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "nar_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "nar_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public AntibodyReference() {

    	this.oid = null;
    	this.reference = "";
    	this.url = "";
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getReference() {
    	return this.reference;
    }
    public String getUrl() {
    	return this.url;
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

    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setReference(String reference) {
    	this.reference = reference;
    }
    public void setUrl(String url) {
    	this.url = url;
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
    public boolean isSameAs(AntibodyReference antibodyreference){

        if (this.getOid().equals(antibodyreference.getOid()) && 
        		this.getReference().equals(antibodyreference.getReference()) && 
        		this.getUrl() == antibodyreference.getUrl() 
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
    	
        return (other instanceof AntibodyReference) && (this.getOid() != null) ? this.getOid().equals(((AntibodyReference) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String reference,
    		String url
    		) {

    	this.oid = oid;
    	this.reference = reference;
    	this.url = url;
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

    // AntibodyReference Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create AntibodyReference objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String reference,
    		String url
    		) {
    	
        return new Builder(
        		oid,
        		reference,
        		url
        		);
    }
    
    /**
     * A Builder class used to create new AntibodyReference objects.
     */
    public static class Builder {
    	
        AntibodyReference built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String reference,
        		String url
        		) {
        	
            built = new AntibodyReference();
            
        	built.oid = oid;
        	built.reference = reference;
        	built.url = url;
        }

        /**
         * Builds the new AntibodyReference object.
         */
        public AntibodyReference build() {
        	
            return built;
        }
    }

    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.reference == null ) ? 0 : this.reference.hashCode() );
    	result = prime * result + ( ( this.url == null ) ? 0 : this.url.hashCode() );

    	return result;
    }

    public int compareTo(AntibodyReference o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByReferenceAsc implements Comparator<AntibodyReference> {

        public int compare(AntibodyReference antibodyreference_o1, AntibodyReference antibodyreference_o2) {

        	return antibodyreference_o1.reference.compareTo(antibodyreference_o2.reference);
        }
    }
    public static class OrderByReferenceDesc implements Comparator<AntibodyReference> {

        public int compare(AntibodyReference antibodyreference_o1, AntibodyReference antibodyreference_o2) {

        	return antibodyreference_o2.reference.compareTo(antibodyreference_o1.reference);
        }
    }

    public static class OrderByUrlAsc implements Comparator<AntibodyReference> {

        public int compare(AntibodyReference antibodyreference_o1, AntibodyReference antibodyreference_o2) {

        	return antibodyreference_o1.url.compareTo(antibodyreference_o2.url);
        }
    }
    public static class OrderByUrlDesc implements Comparator<AntibodyReference> {

        public int compare(AntibodyReference antibodyreference_o1, AntibodyReference antibodyreference_o2) {

        	return antibodyreference_o2.url.compareTo(antibodyreference_o1.url);
        }
    }
	
}
