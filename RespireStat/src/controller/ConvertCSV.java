package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;

import com.opencsv.CSVReader;

import model.Etablissement;

public class ConvertCSV {

	public List<Etablissement> Run_CSV(String w_file) {
		List<Etablissement> eta_Collections = new ArrayList<Etablissement>();
		try { 
			CSVReader csvReader = new CSVReader(new FileReader(w_file));
			String[] index = csvReader.readNext(); // Index is first row in CSV File
			String[] row = csvReader.readNext();
			while(row != null) {
				Map<String, String> temp = new HashMap<String, String>();
				for(int i = 0; i < row.length; i++) {
					temp.put(index[i].toString(), row[i].toString());
				}
				eta_Collections.add(new Etablissement(temp));
				row = csvReader.readNext(); // Increment row in CSV File
			}
            csvReader.close();
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		return eta_Collections;
	}
}
