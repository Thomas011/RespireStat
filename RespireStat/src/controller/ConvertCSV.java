package controller;

import java.awt.List;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class ConvertCSV {

	public void Run_CSV() {
		try { 
	        FileReader filereader = new FileReader("./src/ecoles-creches-idf.csv"); 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String cell : nextRecord) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
}
