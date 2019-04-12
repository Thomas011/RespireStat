package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etablissement {
	private String identifiant;
	private String nom_etablissement;
	private Type type_etablissement;
	
	public Etablissement(Map<String, String> data_etablissement) {
		super();
		this.identifiant = data_etablissement.get("ID");
		this.nom_etablissement = data_etablissement.get("nom");
		
		if(data_etablissement.get("type").equals("primaire")) {
			this.type_etablissement = Type.PRIMAIRE;
		}
		else {
			this.type_etablissement = Type.SECONDAIRE;
		}
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
