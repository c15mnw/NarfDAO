package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOOrganism;

import com.roslin.mwicks.spring.narf.model.Organism;



public final class ConvertFiletoOrganismList {

    // Constants ----------------------------------------------------------------------------------

	/*
	 */

	// Routines -----------------------------------------------------------------------------------
	public static List<Organism> run ( File file, 
			int startRecordCount, 
			String messagePriority, 
			String requestPriority ) throws Exception {

        // Create List of Organisms
        List<Organism> outputorganismList = new ArrayList<Organism>();


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
	            
	            DTOOrganism dtoorganism = new DTOOrganism();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtoorganism.setName(column.trim());
	        		}
	        		
	        		i++;
	         	}
        	    
	         	if ( dtoorganism.isThisAValidOrganism() ) {
	         		
	         		Organism organism = dtoorganism.convertToOrganism();
	         		
	         		outputorganismList.add(organism);
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtoorganism.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		
		return outputorganismList;
	}

}
