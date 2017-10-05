package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOLineReference;

import com.roslin.mwicks.spring.narf.model.LineReference;


public final class ConvertFiletoLineReferenceList {

    // Constants ----------------------------------------------------------------------------------


	// Routines -----------------------------------------------------------------------------------
	public static List<LineReference> run ( File file, int startRecordCount, String messagePriority, String requestPriority ) throws Exception {

        // Create List of LineReferences
        List<LineReference> outputlinereferenceList = new ArrayList<LineReference>();

		try {

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
	            
	            DTOLineReference dtolinereference = new DTOLineReference();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtolinereference.setReference(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtolinereference.setUrl(column.trim());
	        		}
	        		
	        		i++;
	         	}

	         	if ( dtolinereference.isThisAValidLineReference() ) {
	         		
	         		outputlinereferenceList.add(dtolinereference.convertToLineReference());
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtolinereference.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		}
		catch (Exception e) {
			
	        Wrapper.printMessage("Exception : " + e.toString(), messagePriority, requestPriority);
	        
	        System.exit(99);
		}
		
		return outputlinereferenceList;
	}
}
