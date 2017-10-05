package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOStrain;

import com.roslin.mwicks.spring.narf.model.Strain;


public final class ConvertFiletoStrainList {

    // Constants ----------------------------------------------------------------------------------

	/*
	 */

	// Routines -----------------------------------------------------------------------------------
	public static List<Strain> run ( File file, 
			int startRecordCount, 
			String messagePriority, 
			String requestPriority ) throws Exception {

        // Create List of Strains
        List<Strain> outputstrainList = new ArrayList<Strain>();


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
	            
	            DTOStrain dtostrain = new DTOStrain();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtostrain.setStrain(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtostrain.setStrainLong(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtostrain.setProtein(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtostrain.setSpectra(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtostrain.setPattern(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtostrain.setAvailability(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtostrain.setDescription(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtostrain.setContact(column.trim());
	        		}
	        		if ( i == 9 ) {
	        			dtostrain.setPrice(column.trim());
	        		}
	        		
	        		i++;
	         	}
        	    
	         	if ( dtostrain.isThisAValidStrain() ) {
	         		
	         		Strain strain = dtostrain.convertToStrain();
	         		
	         		outputstrainList.add(strain);
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtostrain.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		
		return outputstrainList;
	}
}
