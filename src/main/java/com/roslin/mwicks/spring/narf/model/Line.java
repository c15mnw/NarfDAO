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
 * An entity class which contains the information of a single Line Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_line")
@Transactional
public class Line implements Serializable, Comparable<Line>{
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // ncl_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ncl_oid", nullable = true)
    private Long oid;
    
    // ncl_line varchar(255)
    @Column(name = "ncl_line", nullable = false)
    private String line;
    
    // ncl_breed varchar(255)
    @Column(name = "ncl_breed", nullable = false)
    private String breed;
    
    // ncl_origin varchar(255)
    @Column(name = "ncl_origin", nullable = true)
    private String origin;    
    
    // ncl_imported varchar(255)
    @Column(name = "ncl_imported", nullable = true)
    private String imported;
    
    // ncl_mhc varchar(255)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "LineMhc_oid", referencedColumnName = "nclm_oid") 
    private LineMhc lineMhc;
    
    // ncl_susceptible varchar(255)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "LineSusceptible_oid", referencedColumnName = "ncls_oid") 
    private LineSusceptible lineSusceptible;
    
    // ncl_resistant varchar(255)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "LineResistant_oid", referencedColumnName = "ncle_oid") 
    private LineResistant lineResistant;
    
    // ncl_histocompatible varchar(255)
    @Column(name = "ncl_histocompatible", nullable = true)
    private String histocompatible;
    
    // ncl_type varchar(255)
    @Column(name = "ncl_type", nullable = true)
    private String type;
    
    @Column(name = "ncl_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "ncl_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "ncl_version", nullable = false)
    private long version;
    
    // @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_line_line_reference", 
               joinColumns = { @JoinColumn(name = "ncl_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "nclr_oid") })
    private Set<LineReference> lineReferences = new HashSet<LineReference>();
    
    
    // Constructor --------------------------------------------------------------------------------
    public Line() {

    	this.line = "";
    	this.breed = "";
    	this.origin = "";    
    	this.imported = "";
    	this.lineMhc = null;
    	this.lineSusceptible = null;
    	this.lineResistant = null;
    	this.histocompatible = "";
    	this.type = "";
    	this.lineReferences = null;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getLine() {
    	return this.line;
    }
    public String getBreed() {
    	return this.breed;
    }
    public String getOrigin() {
    	return this.origin;    
    }
    public String getImported() {
    	return this.imported;
    }
    public LineMhc getLineMhc() {
    	return this.lineMhc;
    }
    public LineSusceptible getLineSusceptible() {
    	return this.lineSusceptible;
    }
    public LineResistant getLineResistant() {
    	return this.lineResistant;
    }
    public String getHistocompatible() {
    	return this.histocompatible;
    }
    public String getType() {
    	return this.type;
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
    public Set<LineReference> getLineReferences() {
        return lineReferences;
    }
 
    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setLine(String line) {
    	this.line = line;
    }
    public void setBreed(String breed) {
    	this.breed = breed;
    }
    public void setOrigin(String origin) {
    	this.origin = origin;    
    }
    public void setImported(String imported) {
    	this.imported = imported;
    }
    public void setLineMhc(LineMhc LineMhc) {
    	this.lineMhc = LineMhc;
    }
    public void setLineSusceptible(LineSusceptible LineSusceptible) {
    	this.lineSusceptible = LineSusceptible;
    }
    public void setLineResistant(LineResistant LineResistant) {
    	this.lineResistant = LineResistant;
    }
    public void setHistocompatible(String histocompatible) {
    	this.histocompatible = histocompatible;
    }
    public void setType(String type) {
    	this.type = type;
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
    public void setLineReferences(Set<LineReference> LineReferences) {
        this.lineReferences = LineReferences;
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
    public void addLineReference(LineReference LineReference) {
        this.lineReferences.add(LineReference);
    }

    public void removeLineReference(LineReference LineReference) {
        this.lineReferences.remove(LineReference);
    }
    
    public String getBreedAndLine() {
    	
    	String breedAndLine = "";
    	
    	if ( this.breed.equals("")) {

    		breedAndLine = this.line;
    	}
    	else {
    		
    		breedAndLine = this.breed + ", " + this.line;
    	}
    	
    	return breedAndLine;
    }
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Line line){

        if (this.getOid().equals(line.getOid()) && 
        		this.getLine().equals(line.getLine()) && 
        		this.getBreed() == line.getBreed() &&
        	    this.getOrigin().equals(line.getOrigin()) && 
        	    this.getImported().equals(line.getImported()) && 
        	    this.getLineMhc() == line.getLineMhc() && 
        	    this.getLineSusceptible() == line.getLineSusceptible() && 
        	    this.getLineResistant() == line.getLineResistant() && 
        	    this.getHistocompatible().equals(line.getHistocompatible()) && 
        	    this.getType().equals(line.getType()) &&
        	    this.getLineReferences() == line.getLineReferences() 
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
    	
        return (other instanceof Line) && (this.getOid() != null) ? this.getOid().equals(((Line) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String line,
    		String breed,
    		String origin,    
    		String imported,
    		LineMhc lineMhc,
    		LineSusceptible lineSusceptible,
    		LineResistant lineResistant,
    		String histocompatible,
    		String type,
    		Set<LineReference> lineReferences
    		) {

    	this.oid = oid;
    	this.line = line;
    	this.breed = breed;
    	this.origin = origin;    
    	this.imported = imported;
    	this.lineMhc = lineMhc;
    	this.lineSusceptible = lineSusceptible;
    	this.lineResistant = lineResistant;
    	this.histocompatible = histocompatible;
		this.type = type;
		this.lineReferences = lineReferences;
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

    // Line Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Line objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String line,
    		String breed,
    		String origin,    
    		String imported,
    		LineMhc lineMhc,
    		LineSusceptible lineSusceptible,
    		LineResistant lineResistant,
    		String histocompatible,
    		String type,
    		Set<LineReference> lineReferences
    		) {
    	
        return new Builder(
        		oid,
        		line,
        		breed,
        		origin,    
        		imported,
        		lineMhc,
        		lineSusceptible,
        		lineResistant,
        		histocompatible,
        		type,
        		lineReferences
        		);
    }
    
    /**
     * A Builder class used to create new Line objects.
     */
    public static class Builder {
    	
        Line built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String line,
        		String breed,
        		String origin,    
        		String imported,
        		LineMhc lineMhc,
        		LineSusceptible lineSusceptible,
        		LineResistant lineResistant,
        		String histocompatible,
        		String type,
        		Set<LineReference> lineReferences
        		) {
        	
            built = new Line();
            
        	built.oid = oid;
        	built.line = line;
        	built.breed = breed;
        	built.origin = origin;    
        	built.imported = imported;
        	built.lineMhc = lineMhc;
        	built.lineSusceptible = lineSusceptible;
        	built.lineResistant = lineResistant;
        	built.histocompatible = histocompatible;
    		built.type = type;
    		built.lineReferences = lineReferences;
        }

        /**
         * Builds the new Line object.
         * 
         * @return this. The created Line object.
         */
        public Line build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.line == null ) ? 0 : this.line.hashCode() );
    	result = prime * result + ( ( this.breed == null ) ? 0 : this.breed.hashCode() );
    	result = prime * result + ( ( this.origin == null ) ? 0 : this.origin.hashCode() );    
    	result = prime * result + ( ( this.imported == null ) ? 0 : this.imported.hashCode() );
    	result = prime * result + ( ( this.histocompatible == null ) ? 0 : this.histocompatible.hashCode() );
    	result = prime * result + ( ( this.type == null ) ? 0 : this.type.hashCode() );

    	return result;
    }
    

    public int compareTo(Line o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByLineAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.line.compareTo(line_o2.line);
        }
    }
    public static class OrderByLineDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.line.compareTo(line_o1.line);
        }
    }

    public static class OrderByBreedAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.breed.compareTo(line_o2.breed);
        }
    }
    public static class OrderByBreedDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.breed.compareTo(line_o1.breed);
        }
    }

    public static class OrderByOriginAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.origin.compareTo(line_o2.origin);
        }
    }
    public static class OrderByOriginDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.origin.compareTo(line_o1.origin);
        }
    }

    public static class OrderByImportedAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.imported.compareTo(line_o2.imported);
        }
    }
    public static class OrderByImportedDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.imported.compareTo(line_o1.imported);
        }
    }
    public static class OrderByHistocompatibleAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.histocompatible.compareTo(line_o2.histocompatible);
        }
    }
    public static class OrderByHistocompatibleDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.histocompatible.compareTo(line_o1.histocompatible);
        }
    }

    public static class OrderByTypeAsc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o1.type.compareTo(line_o2.type);
        }
    }
    public static class OrderByTypeDesc implements Comparator<Line> {

        public int compare(Line line_o1, Line line_o2) {

        	return line_o2.type.compareTo(line_o1.type);
        }
    }
	
}
