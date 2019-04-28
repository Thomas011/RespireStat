package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etablissement {
	private String identifiant;
	private String nom_etablissement;
	
	private CoordGPS Coordonnes_Etablissement;
	private Lieu Lieu_Etablissement;
	private Pollution Pollution_Etablissement;
	private Type Type_Etablissement;
	
	
	public Etablissement(Map<String, String> data_etablissement) {
		this.identifiant = data_etablissement.get("ID");
		this.nom_etablissement = data_etablissement.get("nom");
		
		this.Coordonnes_Etablissement = new CoordGPS(data_etablissement);
		this.Lieu_Etablissement = new Lieu(data_etablissement);
		this.Pollution_Etablissement = new Pollution(data_etablissement);
		
		if(data_etablissement.get("type").equals("primaire")) {
			this.Type_Etablissement = Type.PRIMAIRE;
		}
		else {
			this.Type_Etablissement = Type.SECONDAIRE;
		}
	}
	
	public String Get_ID() {
		return this.identifiant;
	}
	
	public String Get_Name() {
		return this.nom_etablissement;
	}
	
	public double Get_Latitude() {
		return this.Coordonnes_Etablissement.Get_La();
	}
	
	public double Get_Longitude() {
		return this.Coordonnes_Etablissement.Get_Lo();
	}
	
	public String Get_Code_Postal() {
		return this.Lieu_Etablissement.Get_CP();
	}
	
	public String Get_Departement() {
		return this.Lieu_Etablissement.Get_Department();
	}
	
	public String Get_Ville() {
		return this.Lieu_Etablissement.Get_Town();
	}
	
	public Map<Integer, Double> Get_NO2() {
		return this.Pollution_Etablissement.Get_NO2();
	}
	
	public Map<Integer, Double> Get_PM10() {
		return this.Pollution_Etablissement.Get_PM10();
	}

	public Map<Integer, Double> Get_PM25() {
		return this.Pollution_Etablissement.Get_PM25();
	}
	
	public Type Get_Type() {
		return this.Type_Etablissement;
	}
}
