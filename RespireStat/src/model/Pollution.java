package model;

import java.util.HashMap;
import java.util.Map;

public class Pollution {
	Map<Integer, Double> NO2 = new HashMap<Integer, Double>();
	Map<Integer, Double> PM10 = new HashMap<Integer, Double>();
	Map<Integer, Double> PM25 = new HashMap<Integer, Double>();
	
	public Pollution(Map<String, String> data_etablissement) {
		for(Map.Entry<String, String> data : data_etablissement.entrySet()) {
			String key = data.getKey();
			String value = data.getValue();
		    if(key.contains("NO2")) {
		    	this.NO2.put(Integer.parseInt(key.substring(4)), Double.parseDouble(value));
		    }
		    else if(key.contains("PM10")) {
		    	this.PM10.put(Integer.parseInt(key.substring(5)), Double.parseDouble(value));
		    }
		    else if(key.contains("PM25")) {
		    	this.PM25.put(Integer.parseInt(key.substring(5)), Double.parseDouble(value));
		    }
		}
	}
	
	public Map<Integer, Double> Get_NO2() {
		return this.NO2;
	}
	
	public Map<Integer, Double> Get_PM10() {
		return this.PM10;
	}
	
	public Map<Integer, Double> Get_PM25() {
		return this.PM25;
	}
}
