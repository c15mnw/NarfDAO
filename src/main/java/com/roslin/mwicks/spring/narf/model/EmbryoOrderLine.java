package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Date;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single EmbryoOrderLine Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_embryo_order_organism")
public class EmbryoOrderLine implements Serializable, Comparable<EmbryoOrderLine>{
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    // nlo_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nmol_oid", nullable = true)
    private Long oid;
    
    // nmol_required
    @Column(name = "nmol_required", nullable = false)
    private int required;
    
    // nmol_supplied
    @Column(name = "nmol_supplied", nullable = false)
    private int supplied;
    
    // EmbryoOrderLineIncubation_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "EmbryoOrderLineIncubation_oid", referencedColumnName = "nmoli_oid") 
    private EmbryoOrderLineIncubation embryoOrderLineIncubation;
    
    // Organism_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Organism_oid", referencedColumnName = "noo_oid") 
    private Organism organism;
    
    // nmol_creation_time
    @Column(name = "nmol_creation_time", nullable = false)
    private Date creationTime;
    
    // nmol_modification_time
    @Column(name = "nmol_modification_time", nullable = true)
    private Date modificationTime;
    
    // nmol_version
    @Version
    @Column(name = "nmol_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public EmbryoOrderLine() {

    	this.oid = (long) 0;

    	this.required = 0;
    	this.supplied = 0;
    	
    	this.embryoOrderLineIncubation = null;
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
    public EmbryoOrderLineIncubation getEmbryoOrderLineIncubation() {
    	return this.embryoOrderLineIncubation;
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
    public void setEmbryoOrderLineIncubation(EmbryoOrderLineIncubation EmbryoOrderLineIncubation) {
    	this.embryoOrderLineIncubation = EmbryoOrderLineIncubation;
    }
    public void setOrganism(Organism Organism) {
    	this.organism = Organism;
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
     			this.getOrganism().getName() + " Embryos, Incubated for " + 
    			this.getEmbryoOrderLineIncubation().getName() + " Days"; 
    }

    public String toEmailString() {

        final StringBuilder builder = new StringBuilder();

        builder
            .append("\n------------")
            .append("\nEMBRYOS")
            .append("\n------------")
			.append("\nNumber Required  : ")
			.append(this.getRequired())
			.append("\nDays Incubated   : ")
			.append(this.getEmbryoOrderLineIncubation().getName())
			.append("\nBreed and Organism   : ")
			.append(this.getOrganism().getName());

        return builder.toString();
    }

    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(EmbryoOrderLine embryoorderorganism){

        if (this.getOid().equals(embryoorderorganism.getOid()) && 
        		this.getRequired() == embryoorderorganism.getRequired() && 
        		this.getSupplied() == getSupplied() && 
        	    this.getEmbryoOrderLineIncubation() == embryoorderorganism.getEmbryoOrderLineIncubation() && 
        	    this.getOrganism() == embryoorderorganism.getOrganism()
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
    	
        return (other instanceof EmbryoOrderLine) && (this.getOid() != null) ? this.getOid().equals(((EmbryoOrderLine) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		int required,
    		int supplied,
    		EmbryoOrderLineIncubation EmbryoOrderLineIncubation,
    		Organism Organism
    		) {

    	this.oid = oid;
    	this.required = required;
    	this.supplied = supplied;
    	this.embryoOrderLineIncubation = EmbryoOrderLineIncubation;
    	this.organism = Organism;
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

    // EmbryoOrderLine Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create EmbryoOrderLine objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		int required,
    		int supplied,
    		EmbryoOrderLineIncubation embryoOrderLineIncubation,
    		Organism organism
    		) {
    	
        return new Builder(
        		oid,
        		required,
        		supplied,
        		embryoOrderLineIncubation,
        		organism
        		);
    }
    
    /**
     * A Builder class used to create new EmbryoOrderLine objects.
     */
    public static class Builder {
    	
        EmbryoOrderLine built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		int required,
        		int supplied,
        		EmbryoOrderLineIncubation embryoOrderLineIncubation,
        		Organism organism
        		) {
        	
            built = new EmbryoOrderLine();
            
        	built.oid = oid;
        	built.required = required;
        	built.supplied = supplied;
        	built.embryoOrderLineIncubation = embryoOrderLineIncubation;
        	built.organism = organism;
        }

        /**
         * Builds the new EmbryoOrderLine object.
         * 
         * @return this. The created EmbryoOrderLine object.
         */
        public EmbryoOrderLine build() {
        	
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
    

    public int compareTo(EmbryoOrderLine o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }

	
}
