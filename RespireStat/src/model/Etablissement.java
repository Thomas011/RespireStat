package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etablissement {
	private String identifiant;
	private String nom_etablissement;
	private Type type_etablissement;
	
	public Etablissement(Map<String, String> data_etablissement) {
		this.identifiant = data_etablissement.get("ID");
		this.nom_etablissement = data_etablissement.get("nom");
		
		Lieu lieu = new Lieu(data_etablissement.get("CP"), data_etablissement.get("departement"), data_etablissement.get("ville"));
		
		String temp = data_etablissement.get("geometry");
	    String temp_ = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
	    String[] temp__ = temp_.split(", ");
	    
		CoordGPS coordGPS = new CoordGPS(Double.parseDouble(temp__[0]), Double.parseDouble(temp__[1]));
		
		if(data_etablissement.get("type").equals("primaire")) {
			this.type_etablissement = Type.PRIMAIRE;
		}
		else {
			this.type_etablissement = Type.SECONDAIRE;
		}
		
		Map<Integer, Double> NO2 = new HashMap<Integer, Double>();
		Map<Integer, Double> PM10 = new HashMap<Integer, Double>();
		Map<Integer, Double> PM25 = new HashMap<Integer, Double>();
		
		for(Map.Entry<String, String> data : data_etablissement.entrySet()) {
			String key = data.getKey();
			String value = data.getValue();
		    if(key.contains("NO2")) {
		    	NO2.put(Integer.parseInt(key.substring(4)), Double.parseDouble(value));
		    }
		    else if(key.contains("PM10")) {
		    	PM10.put(Integer.parseInt(key.substring(5)), Double.parseDouble(value));
		    }
		    else if(key.contains("PM25")) {
		    	PM25.put(Integer.parseInt(key.substring(5)), Double.parseDouble(value));
		    }
		}
		
		Pollution pollution = new Pollution(NO2, PM10, PM25);
	}
	
	public String Get_ID() {
		return this.identifiant;
	}
	
	public String Get_Name() {
		return this.nom_etablissement;
	}
	
	public Type Get_Type() {
		return this.type_etablissement;
	}
}
