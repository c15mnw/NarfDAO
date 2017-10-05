package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOAntibody;

import com.roslin.mwicks.spring.narf.model.Antibody;


public final class ConvertFiletoAntibodyList {

    // Constants ----------------------------------------------------------------------------------

	/*
	 */

	// Routines -----------------------------------------------------------------------------------
	public static List<Antibody> run ( File file, 
			int startRecordCount, 
			String messagePriority, 
			String requestPriority) throws Exception {

        // Create List of Antibodys
        List<Antibody> outputantibodyList = new ArrayList<Antibody>();


	     	int error = 0;

	     	long recordCount = startRecordCount + 1;

	        // Format InputStream for CSV.
	        InputStream csvInput = FileUtil.readStream(file);
	        
	        // Create CSV List
	        List<List<String>> csvList = CsvUtil.parseCsv(csvInput, '\t');

	        // Create CSV List

	        Iterator<List<String>> iteratorRow = csvList.iterator();
	        
	     	while (iteratorRow.hasNext()) {
	    		
	    		List<String> row = iteratorRow.next();

	            Iterator<String> iteratorColumn = row.iterator();
	            
	            int i = 1;
	            
	            DTOAntibody dtoantibody = new DTOAntibody();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtoantibody.setName(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoantibody.setAntigen(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoantibody.setAntigenSearch(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoantibody.setIsotype(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoantibody.setSpecies(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoantibody.setApplication(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtoantibody.setSupplier(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtoantibody.setProductCode(column.trim());
	        		}
	        		if ( i == 9 ) {
	        			dtoantibody.setWebsite(column.trim());
	        		}
	        		
	        		i++;
	         	}
        	    
	         	if ( dtoantibody.isThisAValidAntibody() ) {
	         		
	         		Antibody antibody = dtoantibody.convertToAntibody();
	         		
	         		outputantibodyList.add(antibody);
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtoantibody.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		
		return outputantibodyList;
	}
}
