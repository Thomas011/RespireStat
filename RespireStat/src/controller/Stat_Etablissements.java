package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Etablissement;

public class Stat_Etablissements {
	List<Etablissement> Collections;
	
	public Stat_Etablissements(List<Etablissement> Collections_Eta) {
		this.Collections = Collections_Eta;
	}
	
	public List<Etablissement> Get_FO1() {
		Double NO2 = 0.0;
		Double PM10 = 0.0;
		Double PM25 = 0.0;
		
		Etablissement Eta_NO2 = null;
		Etablissement Eta_PM10 = null;
		Etablissement Eta_PM25 = null;
		
		for(Etablissement data : this.Collections) {
			if(data.Get_NO2().get(2017) > NO2) {
				NO2 = data.Get_NO2().get(2017);
				Eta_NO2 = data;
			}
			if(data.Get_PM10().get(2017) > PM10) {
				PM10 = data.Get_PM10().get(2017);
				Eta_PM10 = data;
			}
			if(data.Get_PM25().get(2017) > PM25) {
				PM25 = data.Get_PM25().get(2017);
				Eta_PM25 = data;
			}
		}
		
		List<Etablissement> result = new ArrayList<Etablissement>();
		result.add(Eta_NO2);
		result.add(Eta_PM10);
		result.add(Eta_PM25);
		
		return result;
	}
	
	public Map<String, Double> Get_FO2() {
		Map<String, Double> result = new HashMap<String, Double>();
		
		for(Etablissement data : this.Collections) {
			if(!result.containsKey(data.Get_Ville())) {
				double moyenne = 0.0;
				for(Etablissement temp : Get_All_Etablissement_In_Town(data.Get_Ville())) {
					
				}
	        }
		}
		
		return null;
	}
	
	public List<Etablissement> Get_All_Etablissement_In_Town(String Town) {
		List<Etablissement> result = new ArrayList<Etablissement>();
		
		for(Etablissement data : this.Collections) {
			if(data.Get_Ville().equals(Town)) {
				result.add(data);
			}
		}
		
		return result;
	}
}
