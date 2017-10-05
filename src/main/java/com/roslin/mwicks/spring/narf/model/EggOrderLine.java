package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single EggOrderLine Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_egg_order_line")
public class EggOrderLine implements Serializable, Comparable<EggOrderLine>{
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    // neol_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "neol_oid", nullable = true)
    private Long oid;
    
    // neol_required
    @Column(name = "neol_required", nullable = false)
    private int required;
    
    // neol_supplied
    @Column(name = "neol_supplied", nullable = false)
    private int supplied;
    
    // EggOrderLineFertilised_oid 
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "EggOrderLineFertilised_oid", referencedColumnName = "neolf_oid") 
    private EggOrderLineFertilised eggOrderLineFertilised;
    
    // Organism_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Organism_oid", referencedColumnName = "noo_oid") 
    private Organism organism;
    
    // neol_creation_time 
    @Column(name = "neol_creation_time", nullable = false)
    private Date creationTime;
    
    // neol_modification_time 
    @Column(name = "neol_modification_time", nullable = true)
    private Date modificationTime;
    
    // neol_version 
    @Version
    @Column(name = "neol_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public EggOrderLine() {

    	this.oid = (long) 0;

    	this.required = 0;
    	this.supplied = 0;
    	
    	this.eggOrderLineFertilised = null;
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
    public EggOrderLineFertilised getEggOrderLineFertilised() {
    	return this.eggOrderLineFertilised;
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
    public void setOrderOid(Long oid) {
    	this.oid = oid;
    }
    public void setRequired(int required) {
    	this.required = required;
    }
    public void setSupplied(int supplied) {
    	this.supplied = supplied;
    }
    public void setEggOrderLineFertilised(EggOrderLineFertilised EggOrderLineFertilised) {
    	this.eggOrderLineFertilised = EggOrderLineFertilised;
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
    			this.getEggOrderLineFertilised().getName() + ", " + 
    			this.getOrganism().getName() + " Eggs";
    }

    public String toEmailString() {

        final StringBuilder builder = new StringBuilder();

        builder
        	.append("\n---------")
            .append("\nEGGS")
            .append("\n---------")
			.append("\nNumber Required  : ")
			.append(this.getRequired())
			.append("\nFertilised?      : ")
			.append(this.getEggOrderLineFertilised().getName())
			.append("\nBreed and Line   : ")
			.append(this.getOrganism().getName());

        return builder.toString();
    }

    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(EggOrderLine eggorderline){

        if (this.getOid().equals(eggorderline.getOid()) && 
        		this.getRequired() == eggorderline.getRequired() && 
        		this.getSupplied() == getSupplied() && 
        	    this.getEggOrderLineFertilised() == eggorderline.getEggOrderLineFertilised() && 
        	    this.getOrganism() == eggorderline.getOrganism()
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
    	
        return (other instanceof EggOrderLine) && (this.getOid() != null) ? this.getOid().equals(((EggOrderLine) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		int required,
    		int supplied,
    		EggOrderLineFertilised eggOrderLineFertilised,
    		Organism organism
    		) {

    	this.oid = oid;
    	this.required = required;
    	this.supplied = supplied;
    	this.eggOrderLineFertilised = eggOrderLineFertilised;
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

    // EggOrderLine Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create EggOrderLine objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		int required,
    		int supplied,
    		EggOrderLineFertilised eggOrderLineFertilised,
    		Organism organism
    		) {
    	
        return new Builder(
        		oid,
        		required,
        		supplied,
        		eggOrderLineFertilised,
        		organism
        		);
    }
    
    /**
     * A Builder class used to create new EggOrderLine objects.
     */
    public static class Builder {
    	
        EggOrderLine built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		int required,
        		int supplied,
        		EggOrderLineFertilised eggOrderLineFertilised,
        		Organism organism
        		) {
        	
            built = new EggOrderLine();
            
        	built.oid = oid;
        	built.required = required;
        	built.supplied = supplied;
        	built.eggOrderLineFertilised = eggOrderLineFertilised;
        	built.organism = organism;
        }

        /**
         * Builds the new EggOrderLine object.
         */
        public EggOrderLine build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	//result = prime * result + ( ( this.required == null ) ? 0 : this.required.hashCode() );    

    	return result;
    }
    

    public int compareTo(EggOrderLine o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }

	
}
