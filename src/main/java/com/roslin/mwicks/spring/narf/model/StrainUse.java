package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single StrainUse Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_strain_use")
public class StrainUse implements Comparable<StrainUse>, Serializable {
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // ncl_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ncsu_oid", nullable = true)
    private Long oid;
    
    // ncl_use varchar(255)
    @Column(name = "ncsu_use", nullable = false)
    private String use;
    
    // ncl_protocol varchar(255)
    @Column(name = "ncsu_protocol", nullable = false)
    private String protocol;
    
    @Column(name = "ncsu_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "ncsu_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "ncsu_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public StrainUse() {

    	this.oid = null;
    	this.use = "";
    	this.protocol = "";
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getUse() {
    	return this.use;
    }
    public String getProtocol() {
    	return this.protocol;
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
    public void setUse(String use) {
    	this.use = use;
    }
    public void setProtocol(String protocol) {
    	this.protocol = protocol;
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
    public boolean isSameAs(StrainUse strainuse){

        if (this.getOid().equals(strainuse.getOid()) && 
        		this.getUse().equals(strainuse.getUse()) && 
        		this.getProtocol() == strainuse.getProtocol() 
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
    	
        return (other instanceof StrainUse) && (this.getOid() != null) ? this.getOid().equals(((StrainUse) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String use,
    		String protocol
    		) {

    	this.oid = oid;
    	this.use = use;
    	this.protocol = protocol;
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

    // StrainUse Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create StrainUse objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String use,
    		String protocol
    		) {
    	
        return new Builder(
        		oid,
        		use,
        		protocol
        		);
    }
    
    /**
     * A Builder class used to create new StrainUse objects.
     */
    public static class Builder {
    	
        StrainUse built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String use,
        		String protocol
        		) {
        	
            built = new StrainUse();
            
        	built.oid = oid;
        	built.use = use;
        	built.protocol = protocol;
        }

        /**
         * Builds the new StrainUse object.
         */
        public StrainUse build() {
        	
            return built;
        }
    }

    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.use == null ) ? 0 : this.use.hashCode() );
    	result = prime * result + ( ( this.protocol == null ) ? 0 : this.protocol.hashCode() );

    	return result;
    }

    public int compareTo(StrainUse o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByUseAsc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o1.use.compareTo(strainuse_o2.use);
        }
    }
    public static class OrderByUseDesc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o2.use.compareTo(strainuse_o1.use);
        }
    }

    public static class OrderByProtocolAsc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o1.protocol.compareTo(strainuse_o2.protocol);
        }
    }
    public static class OrderByProtocolDesc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o2.protocol.compareTo(strainuse_o1.protocol);
        }
    }

    public static class OrderByOidAsc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o1.oid.compareTo(strainuse_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<StrainUse> {

        public int compare(StrainUse strainuse_o1, StrainUse strainuse_o2) {

        	return strainuse_o2.oid.compareTo(strainuse_o1.oid);
        }
    }
	

}
