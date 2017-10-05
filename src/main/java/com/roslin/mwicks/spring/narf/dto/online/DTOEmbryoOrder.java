package com.roslin.mwicks.spring.narf.dto.online;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;
import com.roslin.mwicks.spring.narf.model.Line;
import com.roslin.mwicks.spring.narf.model.OrderCollection;
import com.roslin.mwicks.spring.narf.model.OrderStatus;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOEmbryoOrder {
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    private Long oid;
    
    private String study;
    private String code;
    
    private String customerComment;
    private String supplierComment;

    private int required;
    private Date requiredDate;
    private int supplied;
    private Date suppliedDate;

    private EmbryoOrderLineIncubation orderLineIncubation;
    private Line line;
    private OrderStatus orderStatus;
    private OrderCollection orderCollection;
    
    private Long customer;
    private Long editor;
    private Long supplier;


    // Constructor --------------------------------------------------------------------------------
    public DTOEmbryoOrder() {

    	this.oid = (long) 0;
    	
    	Date now = new Date();

    	this.required = 0;
    	this.requiredDate = now;
    	this.supplied = 0;
    	this.suppliedDate = now;

    	this.study = "";
    	this.code = "";
    	this.customerComment = "";
    	this.supplierComment = "";

    	this.orderLineIncubation = null;
    	this.line = null;
    	this.orderStatus = null;
    	this.orderCollection = null;

    	this.customer = (long) 0;
    	this.editor = (long) 0;
    	this.supplier = (long) 0;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public int getRequired() {
    	return this.required;
    }
    public Date getRequiredDate() {
    	return this.requiredDate;
    }
    public int getSupplied() {
    	return this.supplied;
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

    public EmbryoOrderLineIncubation getOrderLineIncubation() {
    	return this.orderLineIncubation;
    }
    public Line getLine() {
    	return this.line;
    }
    public OrderStatus getOrderStatus() {
    	return this.orderStatus;
    }
    public OrderCollection getOrderCollection() {
    	return this.orderCollection;
    }


    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setRequired(int required) {
    	this.required = required;
    }
    public void setRequiredDate(Date requiredDate) {
    	this.requiredDate = requiredDate;
    }
    public void setSupplied(int supplied) {
    	this.supplied = supplied;
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

    public void setOrderLineIncubation(EmbryoOrderLineIncubation orderLineIncubation) {
    	this.orderLineIncubation = orderLineIncubation;
    }
    public void setLine(Line line) {
    	this.line = line;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
    	this.orderStatus = orderStatus;
    }
    public void setOrderCollection(OrderCollection orderCollection) {
    	this.orderCollection = orderCollection;
    }

    // Getters As Strings -------------------------------------------------------------------------
    
    // Setters From Strings -----------------------------------------------------------------------
    
    // Helpers ------------------------------------------------------------------------------------
    
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(DTOEmbryoOrder dtoorder){

        if (
        		this.getRequired() == dtoorder.getRequired() &&
        		this.getRequiredDate().equals(dtoorder.getRequiredDate()) && 
        		this.getSupplied() == dtoorder.getSupplied() && 
        		this.getSuppliedDate().equals(dtoorder.getSuppliedDate()) &&
        		this.getStudy().equals(dtoorder.getStudy()) &&
        		this.getCode().equals(dtoorder.getCode()) &&
        		this.getCustomerComment().equals(dtoorder.getCustomerComment()) &&
        		this.getSupplierComment().equals(dtoorder.getSupplierComment()) &&
        		this.getCustomer() == dtoorder.getCustomer() &&
        		this.getEditor() == dtoorder.getEditor() &&
        		this.getSupplier() == dtoorder.getSupplier() &&
        		this.getOrderLineIncubation().equals(dtoorder.getOrderLineIncubation()) &&
        		this.getLine().equals(dtoorder.getLine()) &&
        		this.getOrderStatus().equals(dtoorder.getOrderStatus()) &&
        		this.getOrderCollection().equals(dtoorder.getOrderCollection())
        	    ) {

        	return true;
        }
        else {

        	return false;
        }
    }

    

    public void update(
    		Long oid,
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		int required,
    		Date requiredDate,
    		int supplied,
    		Date suppliedDate,
    		EmbryoOrderLineIncubation orderLineIncubation,
    		Line line,
    		OrderStatus orderStatus,
    		OrderCollection orderCollection,
    		Long customer,
    		Long editor,
    		Long supplier
    		) {

    	this.oid = oid;
    	this.study = study;
    	this.code = code;
    	this.customerComment = customerComment;
    	this.supplierComment = supplierComment;

    	this.required = required;
    	this.requiredDate = requiredDate;
    	this.supplied = supplied;
    	this.suppliedDate = suppliedDate;
    	
    	this.orderLineIncubation = orderLineIncubation;
    	this.line = line;
    	this.orderStatus = orderStatus;
    	this.orderCollection = orderCollection;
    	
    	this.customer = customer;
    	this.editor = editor;
    	this.supplier = supplier;
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
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		int required,
    		Date requiredDate,
    		int supplied,
    		Date suppliedDate,
    		EmbryoOrderLineIncubation orderLineIncubation,
    		Line line,
    		OrderStatus orderStatus,
    		OrderCollection orderCollection,
    		Long customer,
    		Long editor,
    		Long supplier
    		) {
    	
        return new Builder(
        		oid,
        		study,
        		code,
        		customerComment,
        		supplierComment,
        		required,
        		requiredDate,
        		supplied,
        		suppliedDate,
        		orderLineIncubation,
        		line,
        		orderStatus,
        		orderCollection,
        		customer,
        		editor,
        		supplier
        		);
    }
    
    /**
     * A Builder class used to create new Order objects.
     */
    public static class Builder {
    	
        DTOEmbryoOrder built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String study,
        		String code,
        		String customerComment,
        		String supplierComment,
        		int required,
        		Date requiredDate,
        		int supplied,
        		Date suppliedDate,
        		EmbryoOrderLineIncubation orderLineIncubation,
        		Line line,
        		OrderStatus orderStatus,
        		OrderCollection orderCollection,
        		Long customer,
        		Long editor,
        		Long supplier
        		) {
        	
            built = new DTOEmbryoOrder();
            
        	built.oid = oid;
        	built.study = study;
        	built.code = code;
        	built.customerComment = customerComment;
        	built.supplierComment = supplierComment;

        	built.required = required;
        	built.requiredDate = requiredDate;
        	built.supplied = supplied;
        	built.suppliedDate = suppliedDate;
        	
        	built.orderLineIncubation = orderLineIncubation;
        	built.line = line;
        	built.orderStatus = orderStatus;
        	built.orderCollection = orderCollection;
        	
        	built.customer = customer;
        	built.editor = editor;
        	built.supplier = supplier;
        }

        /**
         * Builds the new Order object.
         * 
         * @return this. The created Order object.
         */
        public DTOEmbryoOrder build() {
        	
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
