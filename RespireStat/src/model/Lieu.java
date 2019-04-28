package model;

import java.util.Map;

public class Lieu {

	private String code_postal;
	private String departement;
	private String ville;
	
	public Lieu (Map<String, String> data_etablissement) {
		this.code_postal = data_etablissement.get("CP");;
		this.departement = data_etablissement.get("departement");;
		this.ville = data_etablissement.get("ville");;
	}
	
	public String Get_CP() {
		return this.code_postal;
	}
	
	public String Get_Department() {
		return this.departement;
	}
	
	public String Get_Town() {
		return this.ville;
	}
}
