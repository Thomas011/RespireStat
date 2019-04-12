package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;

import com.opencsv.CSVReader;

public class ConvertCSV {

	public List<Map<String, String>> Run_CSV(String w_file) {
		List<Map<String, String>> csv_Result = new ArrayList<Map<String, String>>();
		try { 
			CSVReader csvReader = new CSVReader(new FileReader(w_file));
			String[] index = csvReader.readNext(); // Index is first row in CSV File
			String[] row = csvReader.readNext();
			while(row != null) {
				Map<String, String> temp = new HashMap<String, String>();
				for(int i = 0; i < row.length; i++) {
					temp.put(index[i].toString(), row[i].toString());
				}
				csv_Result.add(temp);
				row = csvReader.readNext(); // Increment row in CSV File
			}
            csvReader.close();
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		return csv_Result;
	}
}
