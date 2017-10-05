package com.roslin.mwicks.spring.narf.dto.online;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineDateFormat;
import com.roslin.mwicks.spring.narf.model.BirdOrderLineSex;
import com.roslin.mwicks.spring.narf.model.EggOrderLineFertilised;
import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;
import com.roslin.mwicks.spring.narf.model.OrderCollection;
import com.roslin.mwicks.spring.narf.model.OrderStatus;
import com.roslin.mwicks.spring.narf.model.OrderType;
import com.roslin.mwicks.spring.narf.model.Organism;

import com.roslin.mwicks.utility.ObjectConverter;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOOrder {
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    private Long oid;

    private Date createdDate;
    private Date requiredDate;
    private Date suppliedDate;
    private String study;
    private String code;
    private String customerComment;
    private String supplierComment;
    private Long customer;
    private Long editor;
    private Long supplier;
    private String customerEmail;
    private String editorEmail;
    private String supplierEmail;
    private String customerOrganisation;
    
    private OrderStatus orderStatus;
    private OrderCollection orderCollection;
    private OrderType orderType;

    private int birdRequired;
    private int birdSupplied;
    private BirdOrderLineSex birdOrderLineSex;
    private int birdAge;
    private BirdOrderLineDateFormat birdOrderLineDateFormat;
    private Organism birdOrganism;

    private int eggRequired;
    private int eggSupplied;
    private EggOrderLineFertilised eggOrderLineFertilised;
    private Organism eggOrganism;
    
    private int embryoRequired;
    private int embryoSupplied;
    private EmbryoOrderLineIncubation embryoOrderLineIncubation;
    private Organism embryoOrganism;

    

    // Constructor --------------------------------------------------------------------------------
    public DTOOrder() {

    	this.oid = (long) 0;

    	Date now = new Date();
    	this.createdDate = now;
    	this.requiredDate = now;
    	this.suppliedDate = null;
    	
    	this.study = "";
    	this.code = "";
    	this.customerComment = "";
    	this.supplierComment = "";
    	
    	this.customer = (long) 0;
    	this.editor = (long) 0;
    	this.supplier = (long) 0;
    	this.customerEmail = "";
    	this.editorEmail = "";
    	this.supplierEmail = "";
    	this.customerOrganisation = "";
    	
    	this.orderStatus = null;
    	this.orderCollection = null;
    	this.orderType = null;

    	this.birdRequired = 0;
    	this.birdSupplied = 0;
    	this.birdOrderLineSex = null;
    	this.birdAge = 0;
    	this.birdOrderLineDateFormat = null;
    	this.birdOrganism = null;

    	this.eggRequired = 0;
    	this.eggSupplied = 0;
    	this.eggOrderLineFertilised = null;
    	this.eggOrganism = null;

    	this.embryoRequired = 0;
    	this.embryoSupplied = 0;
    	this.embryoOrderLineIncubation = null;
    	this.embryoOrganism = null;

    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public Date getCreatedDate() {
    	return this.createdDate;
    }
    public Date getRequiredDate() {
    	return this.requiredDate;
    }
    public Date getSuppliedDate() {
    	return this.suppliedDate;
    }
    public String getStudy() {
    	return this.study;
    }
    public String getCode() {
    	return this.code;
    }
    public String getCustomerComment() {
    	return this.customerComment;
    }
    public String getSupplierComment() {
    	return this.supplierComment;
    }

    public Long getCustomer() {
    	return this.customer;
    }
    public Long getEditor() {
    	return this.editor;
    }
    public Long getSupplier() {
    	return this.supplier;
    }
    public String getCustomerEmail() {
    	return this.customerEmail;
    }
    public String getEditorEmail() {
    	return this.editorEmail;
    }
    public String getSupplierEmail() {
    	return this.supplierEmail;
    }
    public String getCustomerOrganisation() {
    	return this.customerOrganisation;
    }

    public OrderStatus getOrderStatus() {
    	return this.orderStatus;
    }
    public OrderCollection getOrderCollection() {
    	return this.orderCollection;
    }
    public OrderType getOrderType() {
    	return this.orderType;
    }

    public int getBirdRequired() {
    	return this.birdRequired;
    }
    public int getBirdSupplied() {
    	return this.birdSupplied;
    }
    public int getBirdAge() {
    	return this.birdAge;
    }
    public BirdOrderLineSex getBirdOrderLineSex() {
    	return this.birdOrderLineSex;
    }
    public BirdOrderLineDateFormat getBirdOrderLineDateFormat() {
    	return this.birdOrderLineDateFormat;
    }
    public Organism getBirdOrganism() {
    	return this.birdOrganism;
    }

    public int getEggRequired() {
    	return this.eggRequired;
    }
    public int getEggSupplied() {
    	return this.eggSupplied;
    }
    public EggOrderLineFertilised getEggOrderLineFertilised() {
    	return this.eggOrderLineFertilised;
    }
    public Organism getEggOrganism() {
    	return this.eggOrganism;
    }
    
    public int getEmbryoRequired() {
    	return this.embryoRequired;
    }
    public int getEmbryoSupplied() {
    	return this.embryoSupplied;
    }
    public EmbryoOrderLineIncubation getEmbryoOrderLineIncubation() {
    	return this.embryoOrderLineIncubation;
    }
    public Organism getEmbryoOrganism() {
    	return this.embryoOrganism;
    }


    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setCreatedDate(Date createdDate) {
    	this.createdDate = createdDate;
    }
    public void setRequiredDate(Date requiredDate) {
    	this.requiredDate = requiredDate;
    }
    public void setSuppliedDate(Date suppliedDate) {
    	this.suppliedDate = suppliedDate;
    }

    public void setStudy(String study) {
    	this.study = study;
    }
    public void setCode(String code) {
    	this.code = code;
    }
    public void setCustomerComment(String customerComment) {
    	this.customerComment = customerComment;
    }
    public void setSupplierComment(String supplierComment) {
    	this.supplierComment = supplierComment;
    }

    public void setCustomer(Long customer) {
    	this.customer = customer;
    }
    public void setEditor(Long editor) {
    	this.editor = editor;
    }
    public void setSupplier(Long supplier) {
    	this.supplier = supplier;
    }
    public void setCustomerEmail(String customerEmail) {
    	this.customerEmail = customerEmail;
    }
    public void setEditorEmail(String editorEmail) {
    	this.editorEmail = editorEmail;
    }
    public void setSupplierEmail(String supplierEmail) {
    	this.supplierEmail = supplierEmail;
    }
    public void setCustomerOrganisation(String customerOrganisation) {
    	this.customerOrganisation = customerOrganisation;
    }

    public void setOrderStatus(OrderStatus OrderStatus) {
    	this.orderStatus = OrderStatus;
    }
    public void setOrderCollection(OrderCollection OrderCollection) {
    	this.orderCollection = OrderCollection;
    }
    public void setOrderType(OrderType OrderType) {
    	this.orderType = OrderType;
    }

    public void setBirdRequired(int birdRequired) {
    	this.birdRequired = birdRequired;
    }
    public void setBirdSupplied(int birdSupplied) {
    	this.birdSupplied = birdSupplied;
    }
    public void setBirdAge(int birdAge) {
    	this.birdAge = birdAge;
    }
    public void setBirdOrderLineSex(BirdOrderLineSex birdOrderLineSex) {
    	this.birdOrderLineSex = birdOrderLineSex;
    }
    public void setBirdOrderLineDateFormat(BirdOrderLineDateFormat birdOrderLineDateFormat) {
    	this.birdOrderLineDateFormat = birdOrderLineDateFormat;
    }
    public void setBirdOrganism(Organism birdOrganism) {
    	this.birdOrganism = birdOrganism;
    }

    public void setEggRequired(int eggRequired) {
    	this.eggRequired = eggRequired;
    }
    public void setEggSupplied(int eggSupplied) {
    	this.eggSupplied = eggSupplied;
    }
    public void setEggOrderLineFertilised(EggOrderLineFertilised eggOrderLineFertilised) {
    	this.eggOrderLineFertilised = eggOrderLineFertilised;
    }
    public void setEggOrganism(Organism eggOrganism) {
    	this.eggOrganism = eggOrganism;
    }
    
    public void setEmbryoRequired(int embryoRequired) {
    	this.embryoRequired = embryoRequired;
    }
    public void setEmbryoSupplied(int embryoSupplied) {
    	this.embryoSupplied = embryoSupplied;
    }
    public void setEmbryoOrderLineIncubation(EmbryoOrderLineIncubation embryoOrderLineIncubation) {
    	this.embryoOrderLineIncubation = embryoOrderLineIncubation;
    }
    public void setEmbryoOrganism(Organism embryoOrganism) {
    	this.embryoOrganism = embryoOrganism;
    }


    // Getters As Strings -------------------------------------------------------------------------
    public String getOidAsString() {
    	return ObjectConverter.convert(this.oid, String.class);
    }
    
    // Setters From Strings -----------------------------------------------------------------------
    
    // Helpers ------------------------------------------------------------------------------------
    
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(DTOOrder dtoorder){

        if (
        		this.getOid().equals(dtoorder.getOid()) && 
        		
        		this.getCreatedDate().equals(dtoorder.getCreatedDate()) && 
        		this.getRequiredDate().equals(dtoorder.getRequiredDate()) && 
        		this.getSuppliedDate().equals(dtoorder.getSuppliedDate()) && 

        		this.getStudy().equals(dtoorder.getStudy()) && 
        		this.getCode().equals(dtoorder.getCode()) && 
        		
        		this.getCustomerComment().equals(dtoorder.getCustomerComment()) &&
        		this.getSupplierComment().equals(dtoorder.getSupplierComment()) &&

        		this.getCustomer() == dtoorder.getCustomer() &&
        		this.getEditor() == dtoorder.getEditor() &&
        		this.getSupplier() == dtoorder.getSupplier()  &&
        		this.getCustomerEmail().equals(dtoorder.getCustomerEmail()) &&
        		this.getEditorEmail().equals(dtoorder.getEditorEmail()) &&
        		this.getSupplierEmail().equals(dtoorder.getSupplierEmail()) &&
        		this.getCustomerOrganisation().equals(dtoorder.getCustomerOrganisation()) &&

                this.getOrderStatus() == dtoorder.getOrderStatus() && 
                this.getOrderCollection() == dtoorder.getOrderCollection() && 
                this.getOrderType() == dtoorder.getOrderType() && 
                        
                this.getBirdRequired() == dtoorder.getBirdRequired() &&
        	    this.getBirdSupplied() == dtoorder.getBirdSupplied() &&
        	    this.getBirdAge() == dtoorder.getBirdAge() &&
        	    this.getBirdOrderLineSex().equals(dtoorder.getBirdOrderLineSex()) &&
        	    this.getBirdOrderLineDateFormat().equals(dtoorder.getBirdOrderLineDateFormat()) &&
        	    this.getBirdOrganism().equals(dtoorder.getBirdOrganism()) &&
        	    
        	    this.getEggRequired() == dtoorder.getEggRequired() &&
                this.getEggSupplied() == dtoorder.getEggSupplied() &&
        	    this.getEggOrderLineFertilised().equals(dtoorder.getEggOrderLineFertilised()) &&
        	    this.getEggOrganism().equals(dtoorder.getEggOrganism()) &&
        	    
        	    this.getEmbryoRequired() == dtoorder.getEmbryoRequired() &&
                this.getEmbryoSupplied() == dtoorder.getEmbryoSupplied() &&
        	    this.getEmbryoOrderLineIncubation().equals(dtoorder.getEmbryoOrderLineIncubation()) &&
        	    this.getEmbryoOrganism().equals(dtoorder.getEmbryoOrganism())
        	    ) {

        	return true;
        }
        else {

        	return false;
        }
    }

    

    public void update(
    		long oid,

    		Date createdDate,
    		Date requiredDate,
    		Date suppliedDate,
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		long customer,
    		long editor,
    		long supplier,
    		String customerEmail,
    		String editorEmail,
    		String supplierEmail,
    		String customerOrganisation,
    		
    		OrderStatus OrderStatus,
    		OrderCollection OrderCollection,
    		OrderType OrderType,

    		int birdRequired,
        	int birdSupplied,
        	int birdAge,
        	BirdOrderLineSex birdOrderLineSex,
        	BirdOrderLineDateFormat birdOrderLineDateFormat,
        	Organism birdOrganism,

        	int eggRequired,
        	int eggSupplied,
        	EggOrderLineFertilised eggOrderLineFertilised,
        	Organism eggOrganism,

        	int embryoRequired,
        	int embryoSupplied,
        	EmbryoOrderLineIncubation embryoOrderLineIncubation,
        	Organism embryoOrganism
    		) {

    	this.oid = oid;

    	this.createdDate = createdDate;
    	this.requiredDate = requiredDate;
    	this.suppliedDate = suppliedDate;
    	this.study = study;
    	this.code = code;
    	this.customerComment = customerComment;
    	this.supplierComment = supplierComment;
    	this.customer = customer;
    	this.editor = editor;
    	this.supplier = supplier;
    	this.customerEmail = customerEmail;
    	this.editorEmail = editorEmail;
    	this.supplierEmail = supplierEmail;
    	this.customerOrganisation = customerOrganisation;

    	this.orderStatus = OrderStatus;
    	this.orderCollection = OrderCollection;
    	this.orderType = OrderType;

    	this.birdRequired = 0;
    	this.birdSupplied = 0;
    	this.birdAge = 0;
    	this.birdOrderLineSex = null;
    	this.birdOrderLineDateFormat = null;
    	this.birdOrganism = null;

    	this.eggRequired = 0;
    	this.eggSupplied = 0;
    	this.eggOrderLineFertilised = null;
    	this.eggOrganism = null;

    	this.embryoRequired = 0;
    	this.embryoSupplied = 0;
    	this.embryoOrderLineIncubation = null;
    	this.embryoOrganism = null;

    }
    
    @PreUpdate
    public void preUpdate() {
    	
    }
    
    @PrePersist
    public void prePersist() {
    	
    }

    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    // Order Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Order objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		Date createdDate,
    		Date requiredDate,
    		Date suppliedDate,
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		Long customer,
    		Long editor,
    		Long supplier,
    		String customerEmail,
    		String editorEmail,
    		String supplierEmail,
    		String customerOrganisation,
    		OrderStatus orderStatus,
    		OrderCollection orderCollection,
    		OrderType orderType,
        	
    		int birdRequired,
        	int birdSupplied,
        	int birdAge,
        	BirdOrderLineSex birdOrderLineSex,
        	BirdOrderLineDateFormat birdOrderLineDateFormat,
        	Organism birdOrganism,
        	
        	int eggRequired,
        	int eggSupplied,
        	EggOrderLineFertilised eggOrderLineFertilised,
        	Organism eggOrganism,
        	
        	int embryoRequired,
        	int embryoSupplied,
        	EmbryoOrderLineIncubation embryoOrderLineIncubation,
        	Organism embryoOrganism
    		) {
    	
        return new Builder(
        		oid,
        		createdDate,
            	requiredDate,
            	suppliedDate,
            	study,
            	code,
            	customerComment,
            	supplierComment,
            	customer,
        		editor,
        		supplier,
        		customerEmail,
        		editorEmail,
        		supplierEmail,
        		customerOrganisation,
        		orderStatus,
        		orderCollection,
        		orderType,
            	birdRequired,
            	birdSupplied,
            	birdAge,
            	birdOrderLineSex,
            	birdOrderLineDateFormat,
            	birdOrganism,
            	eggRequired,
            	eggSupplied,
            	eggOrderLineFertilised,
        		eggOrganism,
        		embryoRequired,
        		embryoSupplied,
        		embryoOrderLineIncubation,
        		embryoOrganism
        		);
    }
    
    /**
     * A Builder class used to create new Order objects.
     */
    public static class Builder {
    	
        DTOOrder built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		Date createdDate,
        		Date requiredDate,
        		Date suppliedDate,
        		String study,
        		String code,
        		String customerComment,
        		String supplierComment,
        		Long customer,
        		Long editor,
        		Long supplier,
        		String customerEmail,
        		String editorEmail,
        		String supplierEmail,
        		String customerOrganisation,
        		OrderStatus orderStatus,
        		OrderCollection orderCollection,
        		OrderType orderType,
        		
            	int birdRequired,
            	int birdSupplied,
            	int birdAge,
            	BirdOrderLineSex birdOrderLineSex,
            	BirdOrderLineDateFormat birdOrderLineDateFormat,
            	Organism birdOrganism,
            	
            	int eggRequired,
            	int eggSupplied,
            	EggOrderLineFertilised eggOrderLineFertilised,
            	Organism eggOrganism,
            	
            	int embryoRequired,
            	int embryoSupplied,
            	EmbryoOrderLineIncubation embryoOrderLineIncubation,
            	Organism embryoOrganism
        		) {
        	
            built = new DTOOrder();
            
        	built.oid = oid;
        	built.createdDate = createdDate;
        	built.requiredDate = requiredDate;
        	built.suppliedDate = suppliedDate;
        	built.study = study;
        	built.code = code;
        	built.customerComment = customerComment;
        	built.supplierComment = supplierComment;
        	built.customer = customer;
        	built.editor = editor;
        	built.supplier = supplier;
        	built.customerEmail = customerEmail;
        	built.editorEmail = editorEmail;
        	built.supplierEmail = supplierEmail;
        	built.customerOrganisation = customerOrganisation;

        	built.orderStatus = orderStatus;
        	built.orderCollection = orderCollection;
        	built.orderType = orderType;

        	built.birdRequired = birdRequired;
        	built.birdSupplied = birdSupplied;
        	built.birdAge = birdAge;
        	built.birdOrderLineSex = birdOrderLineSex;
        	built.birdOrderLineDateFormat = birdOrderLineDateFormat;
        	built.birdOrganism = birdOrganism;

        	built.eggRequired = eggRequired;
        	built.eggSupplied = eggSupplied;
        	built.eggOrderLineFertilised = eggOrderLineFertilised;
        	built.eggOrganism = eggOrganism;

        	built.embryoRequired = embryoRequired;
        	built.embryoSupplied = embryoSupplied;
        	built.embryoOrderLineIncubation = embryoOrderLineIncubation;
        	built.embryoOrganism = embryoOrganism;
        }

        /**
         * Builds the new Order object.
         * 
         * @return this. The created Order object.
         */
        public DTOOrder build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.customerComment == null ) ? 0 : this.customerComment.hashCode() );

    	return result;
    }
    

}
