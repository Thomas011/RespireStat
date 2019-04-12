package model;

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
	}
}
