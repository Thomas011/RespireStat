package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Etablissement;

public class Stat_Etablissements {
	List<Etablissement> Collections;
	
	public Stat_Etablissements(List<Etablissement> Collections_Eta) {
		this.Collections = Collections_Eta;
	}
	
	public String[] Get_FO1_Header() {
		String[] temp = new String[]{"NO2", "PM10", "PM25"};
		return temp;
	}
	
	public String[][] Get_FO1_Data() {
		Map<String, Etablissement> Pollution = new HashMap<String, Etablissement>();
		Pollution.put("NO2", null);
		Pollution.put("PM10", null);
		Pollution.put("PM25", null);
		
		for(Etablissement data : this.Collections) {
			if(Pollution.get("NO2") != null) {
				if(data.Get_NO2().get(2017) > Pollution.get("NO2").Get_NO2().get(2017)) {
					Pollution.put("NO2", data);
				}
	        }
			else {
				Pollution.put("NO2", data);
			}
			if(Pollution.get("PM10") != null) {
				if(data.Get_PM10().get(2017) > Pollution.get("PM10").Get_PM10().get(2017)) {
					Pollution.put("PM10", data);
				}
	        }
			else {
				Pollution.put("PM10", data);
			}
			if(Pollution.get("PM25") != null) {
				if(data.Get_PM25().get(2017) > Pollution.get("PM25").Get_PM25().get(2017)) {
					Pollution.put("PM25", data);
				}
	        }
			else {
				Pollution.put("PM25", data);
			}
		}

		String[][] Data = new String[3][3];
        for(Map.Entry<String, Etablissement> data : Pollution.entrySet()) {
        	for(int i = 0; i < 3; i++) {
        		Data[0][i] = data.getValue().Get_Name();
        		Data[1][i] = data.getValue().Get_Ville();
        		Data[2][i] = "Distance : " + Math.round(data.getValue().Get_Latitude()) + "km";
			}
		}
        
		return Data;
	}
	
	public String[] Get_FO2_Header() {
		String[] temp = new String[]{"NO2", "PM10", "PM25"};
		return temp;
	}
	
	public String[][] Get_FO2_Data() {
		Map<String, Double> NO2 = new HashMap<String, Double>();
		Map<String, Double> PM10 = new HashMap<String, Double>();
		Map<String, Double> PM25 = new HashMap<String, Double>();
		
		for(Etablissement data : this.Collections) {
			if(!NO2.containsKey(data.Get_Ville())) {
				NO2.put(data.Get_Ville(), data.Get_NO2().get(2017));
	        }
			else {
				NO2.put(data.Get_Ville(), NO2.get(data.Get_Ville()) + data.Get_NO2().get(2017) / Collections.size());
			}
			
			if(!PM10.containsKey(data.Get_Ville())) {
				PM10.put(data.Get_Ville(), data.Get_PM10().get(2017));
	        }
			else {
				PM10.put(data.Get_Ville(), PM10.get(data.Get_Ville()) + data.Get_PM10().get(2017) / Collections.size());
			}
			
			if(!PM25.containsKey(data.Get_Ville())) {
				PM25.put(data.Get_Ville(), data.Get_PM25().get(2017));
	        }
			else {
				PM25.put(data.Get_Ville(), PM25.get(data.Get_Ville()) + data.Get_PM25().get(2017) / Collections.size());
			}
		}
		
		String[][] Data = new String[NO2.size() + PM10.size()][3];
		int index = 0;
		for(Map.Entry<String, Double> data : NO2.entrySet()) {
        	Data[index][0] = data.getKey();
        	index++;
        	Data[index][0] = data.getValue().toString();
        	index++;
		}
		index = 0;
		for(Map.Entry<String, Double> data : PM10.entrySet()) {
			Data[index][1] = data.getKey();
        	index++;
        	Data[index][1] = data.getValue().toString();
        	index++;
		}
		index = 0;
		for(Map.Entry<String, Double> data : PM25.entrySet()) {
			Data[index][2] = data.getKey();
        	index++;
        	Data[index][2] = data.getValue().toString();
        	index++;
		}

		return Data;
	}
	
	public String[] Get_FO3_Header() {
		String[] temp = new String[]{"NO2", "PM10", "PM25"};
		return temp;
	}
	
	public String[][] Get_FO3_Data() {
		Map<String, Double> NO2 = new HashMap<String, Double>();
		Map<String, Double> PM10 = new HashMap<String, Double>();
		Map<String, Double> PM25 = new HashMap<String, Double>();
		
		for(Etablissement data : this.Collections) {
			if(!NO2.containsKey(data.Get_Departement())) {
				NO2.put(data.Get_Departement(), data.Get_NO2().get(2017));
				System.out.println(data.Get_Name());
	        }
			else {
				NO2.put(data.Get_Departement(), NO2.get(data.Get_Departement()) + data.Get_NO2().get(2017) / Collections.size());
			}
			
			if(!PM10.containsKey(data.Get_Departement())) {
				PM10.put(data.Get_Departement(), data.Get_PM10().get(2017));
	        }
			else {
				PM10.put(data.Get_Departement(), PM10.get(data.Get_Departement()) + data.Get_PM10().get(2017) / Collections.size());
			}
			
			if(!PM25.containsKey(data.Get_Departement())) {
				PM25.put(data.Get_Departement(), data.Get_PM25().get(2017));
	        }
			else {
				PM25.put(data.Get_Departement(), PM25.get(data.Get_Departement()) + data.Get_PM25().get(2017) / Collections.size());
			}
		}
		
		String[][] Data = new String[NO2.size() + PM10.size()][3];
		int index = 0;
		for(Map.Entry<String, Double> data : NO2.entrySet()) {
        	Data[index][0] = data.getKey();
        	index++;
        	Data[index][0] = data.getValue().toString();
        	index++;
		}
		index = 0;
		for(Map.Entry<String, Double> data : PM10.entrySet()) {
			Data[index][1] = data.getKey();
        	index++;
        	Data[index][1] = data.getValue().toString();
        	index++;
		}
		index = 0;
		for(Map.Entry<String, Double> data : PM25.entrySet()) {
			Data[index][2] = data.getKey();
        	index++;
        	Data[index][2] = data.getValue().toString();
        	index++;
		}

		return Data;
	}
	
	public List<Map<String, Double>> Get_FO4() {
		return null;
	}
}
