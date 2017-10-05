package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single BirdOrderLine Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_bird_order_line")
public class BirdOrderLine implements Serializable, Comparable<BirdOrderLine>{
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    // nlo_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nbol_oid", nullable = true)
    private Long oid;
    
    // nbol_required
    @Column(name = "nbol_required", nullable = false)
    private int required;
    
    // nbol_supplied
    @Column(name = "nbol_supplied", nullable = false)
    private int supplied;
    
    // nlo_age 
    @Column(name = "nbol_age", nullable = true)
    private int age;
    
    // BirdOrderLineSex_oid 
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "BirdOrderLineSex_oid", referencedColumnName = "nbols_oid") 
    private BirdOrderLineSex birdOrderLineSex;
    
    // BirdOrderLineDateFormat_oid 
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "BirdOrderLineDateFormat_oid", referencedColumnName = "nbold_oid") 
    private BirdOrderLineDateFormat birdOrderLineDateFormat;
    
    // Organism_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Organism_oid", referencedColumnName = "noo_oid") 
    private Organism organism;
    
    // nbol_creation_time
    @Column(name = "nbol_creation_time", nullable = false)
    private Date creationTime;
    
    // nbol_modification_time
    @Column(name = "nbol_modification_time", nullable = true)
    private Date modificationTime;
    
    // nbol_version
    @Version
    @Column(name = "nbol_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public BirdOrderLine() {

    	this.oid = (long) 0;
    	
    	this.required = 0;
    	this.supplied = 0;

    	this.age = 0;

    	this.birdOrderLineSex = null;
    	this.birdOrderLineDateFormat = null;
    	this.organism = null;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public int getRequired() {
    	return this.required;
    }
    public int getSupplied() {
    	return this.supplied;
    }
    public int getAge() {
    	return this.age;
    }
    public BirdOrderLineSex getBirdOrderLineSex() {
    	return this.birdOrderLineSex;
    }
    public BirdOrderLineDateFormat getBirdOrderLineDateFormat() {
    	return this.birdOrderLineDateFormat;
    }
    public Organism getOrganism() {
    	return this.organism;
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
    public void setRequired(int required) {
    	this.required = required;
    }
    public void setSupplied(int supplied) {
    	this.supplied = supplied;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public void setBirdOrderLineSex(BirdOrderLineSex BirdOrderLineSex) {
    	this.birdOrderLineSex = BirdOrderLineSex;
    }
    public void setBirdOrderLineDateFormat(BirdOrderLineDateFormat BirdOrderLineDateFormat) {
    	this.birdOrderLineDateFormat = BirdOrderLineDateFormat;
    }
    public void setOrganism(Organism organism) {
    	this.organism = organism;
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
    public String getAsString() {
    	
    	return this.getRequired() + " " + 
         		this.getBirdOrderLineSex().getName() + ", " +
    			this.getOrganism().getName() + 
    			this.getAge() + " " + 
    			this.getBirdOrderLineDateFormat().getName() + " Birds";
    }

    public String toEmailString() {

        final StringBuilder builder = new StringBuilder();

        builder
            .append("\n----------")
            .append("\nBIRDS")
            .append("\n----------")
			.append("\nNumber Required  : ")
			.append(this.getRequired())
			.append("\nSex              : ")
			.append(this.getBirdOrderLineSex().getName())
			.append("\nBreed and Line   : ")
			.append(this.getOrganism().getName())
			.append("\nAge              : ")
			.append(this.getAge())
			.append("\nAge Type         : ")
			.append(this.getBirdOrderLineDateFormat().getName());

        return builder.toString();
    }

    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(BirdOrderLine birdorderline){

        if (this.getOid().equals(birdorderline.getOid()) && 
        		this.getRequired() == birdorderline.getRequired() && 
        		this.getSupplied() == getSupplied() && 
        		this.getAge() == birdorderline.getAge() && 
        	    this.getBirdOrderLineSex() == birdorderline.getBirdOrderLineSex() && 
                this.getBirdOrderLineDateFormat() == birdorderline.getBirdOrderLineDateFormat() && 
        	    this.getOrganism() == birdorderline.getOrganism()
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
    	
        return (other instanceof BirdOrderLine) && (this.getOid() != null) ? this.getOid().equals(((BirdOrderLine) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		int required,
    		int supplied,
    		int age,
    		BirdOrderLineSex birdOrderLineSex,
    		BirdOrderLineDateFormat birdOrderLineDateFormat,
    		Organism organism
    		) {

    	this.oid = oid;
    	this.required = required;
    	this.supplied = supplied;
    	this.age = age;
    	this.birdOrderLineSex = birdOrderLineSex;
    	this.birdOrderLineDateFormat = birdOrderLineDateFormat;
    	this.organism = organism;
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

    // BirdOrderLine Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create BirdOrderLine objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		int required,
    		int supplied,
    		int age,
    		BirdOrderLineSex birdOrderLineSex,
    		BirdOrderLineDateFormat birdOrderLineDateFormat,
    		Organism organism
    		) {
    	
        return new Builder(
        		oid,
        		required,
        		supplied,
        		age,
        		birdOrderLineSex,
        		birdOrderLineDateFormat,
        		organism
        		);
    }
    
    /**
     * A Builder class used to create new BirdOrderLine objects.
     */
    public static class Builder {
    	
        BirdOrderLine built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		int required,
        		int supplied,
        		int age,
        		BirdOrderLineSex birdOrderLineSex,
        		BirdOrderLineDateFormat birdOrderLineDateFormat,
        		Organism organism
        		) {
        	
            built = new BirdOrderLine();
            
        	built.oid = oid;
        	built.required = required;
        	built.supplied = supplied;
        	built.age = age;
        	built.birdOrderLineSex = birdOrderLineSex;
        	built.birdOrderLineDateFormat = birdOrderLineDateFormat;
        	built.organism = organism;
        }

        /**
         * Builds the new BirdOrderLine object.
         */
        public BirdOrderLine build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	//result = prime * result + ( ( this.age == null ) ? 0 : this.age.hashCode() );
    	//result = prime * result + ( ( this.day == null ) ? 0 : this.day.hashCode() );    

    	return result;
    }
    

    public int compareTo(BirdOrderLine o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }

	
}
