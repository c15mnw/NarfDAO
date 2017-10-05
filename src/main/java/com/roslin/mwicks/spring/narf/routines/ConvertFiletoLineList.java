package com.roslin.mwicks.spring.narf.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.narf.dto.offline.DTOLine;

import com.roslin.mwicks.spring.narf.model.Line;

import com.roslin.mwicks.spring.narf.repository.RepositoryLineMhc;
import com.roslin.mwicks.spring.narf.repository.RepositoryLineResistant;
import com.roslin.mwicks.spring.narf.repository.RepositoryLineSusceptible;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineMhc;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineResistant;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineSusceptible;


public final class ConvertFiletoLineList {

    // Constants ----------------------------------------------------------------------------------

	/*
	 */

	// Routines -----------------------------------------------------------------------------------
	public static List<Line> run ( File file, 
			int startRecordCount, 
			String messagePriority, 
			String requestPriority, 
			ServiceLineMhc serviceLineMhc, 
			ServiceLineResistant serviceLineResistant, 
			ServiceLineSusceptible serviceLineSusceptible ) throws Exception {

        // Create List of Lines
        List<Line> outputlineList = new ArrayList<Line>();


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
	            
	            DTOLine dtoline = new DTOLine();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtoline.setLine(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoline.setBreed(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoline.setOrigin(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoline.setImported(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoline.setMhc(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoline.setSusceptible(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtoline.setResistant(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtoline.setHistocompatible(column.trim());
	        		}
	        		if ( i == 9 ) {
	        			dtoline.setType(column.trim());
	        		}
	        		
	        		i++;
	         	}
        	    
	         	if ( dtoline.isThisAValidLine( serviceLineMhc, serviceLineResistant, serviceLineSusceptible ) ) {
	         		
	         		Line line = dtoline.convertToLine( serviceLineMhc, serviceLineResistant, serviceLineSusceptible );
	         		
	         		outputlineList.add(line);
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtoline.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		
		return outputlineList;
	}
	
	
	public static List<Line> run ( File file, 
			int startRecordCount, 
			String messagePriority, 
			String requestPriority, 
			RepositoryLineMhc repositoryLineMhc, 
			RepositoryLineResistant repositoryLineResistant, 
			RepositoryLineSusceptible repositoryLineSusceptible ) throws Exception {

        // Create List of Lines
        List<Line> outputlineList = new ArrayList<Line>();


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
	            
	            DTOLine dtoline = new DTOLine();
	            
        	    recordCount++;
        	    
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        		if ( i == 1 ) {
	        			dtoline.setLine(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoline.setBreed(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoline.setOrigin(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoline.setImported(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoline.setMhc(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoline.setSusceptible(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtoline.setResistant(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtoline.setHistocompatible(column.trim());
	        		}
	        		if ( i == 9 ) {
	        			dtoline.setType(column.trim());
	        		}
	        		
	        		i++;
	         	}
        	    
	         	if ( dtoline.isThisAValidLine( repositoryLineMhc, repositoryLineResistant, repositoryLineSusceptible ) ) {
	         		
	         		Line line = dtoline.convertToLine( repositoryLineMhc, repositoryLineResistant, repositoryLineSusceptible );
	         		
	         		outputlineList.add(line);
	         	}
	         	else {
	         		
	         		error++;
	         		Wrapper.printMessage("Error No." + error + " : " + dtoline.toString(), messagePriority, requestPriority);
	    	        System.exit(99);
	         	}
	     	}
		
		return outputlineList;
	}

}
