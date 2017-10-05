package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOStrainUse;

import com.roslin.mwicks.spring.narf.model.StrainUse;


public final class ConvertFiletoStrainUseList {

    // Constants ----------------------------------------------------------------------------------


	// Routines -----------------------------------------------------------------------------------
	public static List<StrainUse> run ( File file, int startRecordCount, String messagePriority, String requestPriority ) throws Exception {

        // Create List of StrainUses
        List<StrainUse> outputstrainuseList = new ArrayList<StrainUse>();

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
	            
	            DTOStrainUse dtostrainuse = new DTOStrainUse();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtostrainuse.setUse(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtostrainuse.setProtocol(column.trim());
	        		}
	        		
	        		i++;
	         	}

	         	if ( dtostrainuse.isThisAValidStrainUse() ) {
	         		
	         		outputstrainuseList.add(dtostrainuse.convertToStrainUse());
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtostrainuse.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		}
		catch (Exception e) {
			
	        Wrapper.printMessage("Exception : " + e.toString(), messagePriority, requestPriority);
	        
	        System.exit(99);
		}
		
		return outputstrainuseList;
	}
}
