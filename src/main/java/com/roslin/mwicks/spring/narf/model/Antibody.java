package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single Antibody Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_antibody")
@Transactional
public class Antibody implements Serializable, Comparable<Antibody>{
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // nca_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nca_oid", nullable = true)
    private Long oid;
    
    // antibody_name
    @Column(name = "nca_name", nullable = false)
    private String name;

    // antigen
    @Column(name = "nca_antigen", nullable = false)
    private String antigen;

    // antigen_search
    @Column(name = "nca_antigen_search", nullable = false)
    private String antigenSearch;

    // isotype
    @Column(name = "nca_isotype", nullable = false)
    private String isotype;

    // species
    @Column(name = "nca_species", nullable = false)
    private String species;

    // applications
    @Column(name = "nca_application", nullable = false)
    private String application;

    // supplier
    @Column(name = "nca_supplier", nullable = false)
    private String supplier;

    // product_code
    @Column(name = "nca_product_code", nullable = false)
    private String productCode;

    // website
    @Column(name = "nca_website", nullable = false)
    private String website;
    
    @Column(name = "nca_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "nca_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "nca_version", nullable = false)
    private long version;
    
    // @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_antibody_antibody_reference", 
               joinColumns = { @JoinColumn(name = "nca_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "nar_oid") })
    private Set<AntibodyReference> antibodyReferences = new HashSet<AntibodyReference>();
    
    
    // Constructor --------------------------------------------------------------------------------
    public Antibody() {

    	this.name = "";
    	this.antigen = "";
    	this.antigenSearch = "";    
    	this.isotype = "";
    	this.species = "";
    	this.application = "";
        this.supplier = "";
        this.productCode = "";
        this.website = "";
    	this.antibodyReferences = null;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getName() {
    	return this.name;
    }
    public String getAntigen() {
    	return this.antigen;
    }
    public String getAntigenSearch() {
    	return this.antigenSearch;    
    }
    public String getIsotype() {
    	return this.isotype;
    }
    public String getSpecies() {
    	return this.species;
    }
    public String getApplication() {
    	return this.application;
    }
    public String getSupplier() {
    	return this.supplier;
    }
    public String getProductCode() {
    	return this.productCode;
    }
    public String getWebsite() {
    	return this.website;
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
    public Set<AntibodyReference> getAntibodyReferences() {
        return antibodyReferences;
    }
 
    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void setAntigen(String antigen) {
    	this.antigen = antigen;
    }
    public void setAntigenSearch(String antigenSearch) {
    	this.antigenSearch = antigenSearch;    
    }
    public void setIsotype(String isotype) {
    	this.isotype = isotype;
    }
    public void setSpecies(String species) {
    	this.species = species;
    }
    public void setApplication(String application) {
    	this.application = application;
    }
    public void setSupplier(String supplier) {
    	this.supplier = supplier;
    }
    public void setProductCode(String productCode) {
    	this.productCode = productCode;
    }
    public void setWebsite(String website) {
    	this.website = website;
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
    public void setAntibodyReferences(Set<AntibodyReference> antibodyReferences) {
        this.antibodyReferences = antibodyReferences;
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
    public void addAntibodyReference(AntibodyReference NameReference) {
        this.antibodyReferences.add(NameReference);
    }

    public void removeAntibodyReference(AntibodyReference NameReference) {
        this.antibodyReferences.remove(NameReference);
    }
    
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Antibody antibody){

        if (this.getOid().equals(antibody.getOid()) && 
        		this.getName().equals(antibody.getName()) && 
        		this.getAntigen().equals(antibody.getAntigen()) &&
        	    this.getAntigenSearch().equals(antibody.getAntigenSearch()) && 
        	    this.getIsotype().equals(antibody.getIsotype()) && 
        	    this.getSupplier().equals(antibody.getSupplier()) && 
        	    this.getApplication().equals(antibody.getApplication()) && 
        	    this.getProductCode().equals(antibody.getProductCode()) && 
        	    this.getWebsite().equals(antibody.getWebsite()) && 
        	    this.getSpecies().equals(antibody.getSpecies()) && 
        	    this.getApplication().equals(antibody.getApplication()) &&
        	    this.getAntibodyReferences() == antibody.getAntibodyReferences() 
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
    	
        return (other instanceof Antibody) && (this.getOid() != null) ? this.getOid().equals(((Antibody) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String name,
    		String antigen,
    		String antigenSearch,    
    		String isotype,
    		String species,
    		String application,
    		String supplier,
    		String productCode,
    		String website,
    		Set<AntibodyReference> antibodyReferences
    		) {

    	
    	System.out.println("productCode : " + productCode);
    	
    	this.oid = oid;
    	this.name = name;
    	this.antigen = antigen;
    	this.antigenSearch = antigenSearch;    
    	this.isotype = isotype;
    	this.species = species;
		this.application = application;
    	this.supplier = supplier;
    	this.productCode = productCode;
    	this.website = website;
		this.antibodyReferences = antibodyReferences;
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

    // Antibody Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Antibody objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String name,
    		String antigen,
    		String antigenSearch,    
    		String isotype,
    		String species,
    		String application,
    		String supplier,
    		String productCode,
    		String website,
    		Set<AntibodyReference> antibodyReferences
    		) {
    	
        return new Builder(
        		oid,
        		name,
        		antigen,
        		antigenSearch,    
        		isotype,
        		species,
        		application,
        		supplier,
        		productCode,
        		website,
        		antibodyReferences
        		);
    }
    
    /**
     * A Builder class used to create new Antibody objects.
     */
    public static class Builder {
    	
        Antibody built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String name,
        		String antigen,
        		String antigenSearch,    
        		String isotype,
        		String species,
        		String application,
        		String supplier,
        		String productCode,
        		String website,
        		Set<AntibodyReference> antibodyReferences
        		) {
        	
            built = new Antibody();
            
        	built.oid = oid;
        	built.name = name;
        	built.antigen = antigen;
        	built.antigenSearch = antigenSearch;    
        	built.isotype = isotype;
        	built.supplier = supplier;
        	built.productCode = productCode;
        	built.website = website;
        	built.species = species;
    		built.application = application;
    		built.antibodyReferences = antibodyReferences;
        }

        /**
         * Builds the new Antibody object.
         */
        public Antibody build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.name == null ) ? 0 : this.name.hashCode() );
    	result = prime * result + ( ( this.antigen == null ) ? 0 : this.antigen.hashCode() );
    	result = prime * result + ( ( this.antigenSearch == null ) ? 0 : this.antigenSearch.hashCode() );    
    	result = prime * result + ( ( this.isotype == null ) ? 0 : this.isotype.hashCode() );
    	result = prime * result + ( ( this.species == null ) ? 0 : this.species.hashCode() );
    	result = prime * result + ( ( this.supplier == null ) ? 0 : this.supplier.hashCode() );
    	result = prime * result + ( ( this.productCode == null ) ? 0 : this.productCode.hashCode() );
    	result = prime * result + ( ( this.website == null ) ? 0 : this.website.hashCode() );
    	result = prime * result + ( ( this.application == null ) ? 0 : this.application.hashCode() );

    	return result;
    }
    

    public int compareTo(Antibody o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByOidAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.oid.compareTo(antibody_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.oid.compareTo(antibody_o1.oid);
        }
    }

    public static class OrderByNameAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.name.compareTo(antibody_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.name.compareTo(antibody_o1.name);
        }
    }

    public static class OrderByAntigenAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.antigen.compareTo(antibody_o2.antigen);
        }
    }
    public static class OrderByAntigenDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.antigen.compareTo(antibody_o1.antigen);
        }
    }

    public static class OrderByAntigenSearchAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.antigenSearch.compareTo(antibody_o2.antigenSearch);
        }
    }
    public static class OrderByAntigenSearchDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.antigenSearch.compareTo(antibody_o1.antigenSearch);
        }
    }

    public static class OrderByIsotypeAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.isotype.compareTo(antibody_o2.isotype);
        }
    }
    public static class OrderByIsotypeDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.isotype.compareTo(antibody_o1.isotype);
        }
    }
    
    public static class OrderBySpeciesAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.species.compareTo(antibody_o2.species);
        }
    }
    public static class OrderBySpeciesDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.species.compareTo(antibody_o1.species);
        }
    }

    public static class OrderByApplicationAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.application.compareTo(antibody_o2.application);
        }
    }
    public static class OrderByApplicationDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.application.compareTo(antibody_o1.application);
        }
    }
	
    public static class OrderBySupplierAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.supplier.compareTo(antibody_o2.supplier);
        }
    }
    public static class OrderBySupplierDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.supplier.compareTo(antibody_o1.supplier);
        }
    }

    public static class OrderByProductCodeAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.productCode.compareTo(antibody_o2.productCode);
        }
    }
    public static class OrderByProductCodeDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.productCode.compareTo(antibody_o1.productCode);
        }
    }

    public static class OrderByWebsiteAsc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o1.website.compareTo(antibody_o2.website);
        }
    }
    public static class OrderByWebsiteDesc implements Comparator<Antibody> {

        public int compare(Antibody antibody_o1, Antibody antibody_o2) {

        	return antibody_o2.website.compareTo(antibody_o1.website);
        }
    }

}
