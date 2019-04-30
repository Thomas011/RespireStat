package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Etablissement;

public class Stat_Etablissements {
	List<Etablissement> List_Etablissement;
	
	public Stat_Etablissements(List<Etablissement> List_Etablissement_Eta) {
		this.List_Etablissement = List_Etablissement_Eta;
	}
	
	public String[][] Get_FO1_Data() {
		Map<String, Etablissement> Pollution = new HashMap<String, Etablissement>();
		Pollution.put("NO2", null);
		Pollution.put("PM10", null);
		Pollution.put("PM25", null);
		
		for(Etablissement data : this.List_Etablissement) {
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
		
		/*System.out.println(Pollution.get("NO2").Get_NO2().get(2017));
		System.out.println(Pollution.get("NO2").Get_Name());
		System.out.println(Pollution.get("PM10").Get_PM10().get(2017));
		System.out.println(Pollution.get("PM10").Get_Name());
		System.out.println(Pollution.get("PM25").Get_PM25().get(2017));
		System.out.println(Pollution.get("PM25").Get_Name());*/
		
		
		String[][] Data = new String[1][3];
		int z = 0;
		for(Map.Entry<String, Etablissement> data : Pollution.entrySet()) {
        	Data[0][z] = "<html>" + data.getValue().Get_Name() + "<br>" + data.getValue().Get_Ville() + "<br>Distance : " + Math.round(data.getValue().Get_Latitude()) + "Km" + "</html>";
        	z++;
		}
		
		return Data;
	}
	
	public String[][] Get_FO2_Data() {
		Map<String, Double> NO2 = new TreeMap<String, Double>();
		Map<String, Double> PM10 = new TreeMap<String, Double>();
		Map<String, Double> PM25 = new TreeMap<String, Double>();
		
		for(Etablissement data : this.List_Etablissement) {
			if(!NO2.containsKey(data.Get_Ville())) {
				NO2.put(data.Get_Ville(), data.Get_NO2().get(2017));
	        }
			else {
				NO2.put(data.Get_Ville(), NO2.get(data.Get_Ville()) + data.Get_NO2().get(2017) / List_Etablissement.size());
			}
			
			if(!PM10.containsKey(data.Get_Ville())) {
				PM10.put(data.Get_Ville(), data.Get_PM10().get(2017));
	        }
			else {
				PM10.put(data.Get_Ville(), PM10.get(data.Get_Ville()) + data.Get_PM10().get(2017) / List_Etablissement.size());
			}
			
			if(!PM25.containsKey(data.Get_Ville())) {
				PM25.put(data.Get_Ville(), data.Get_PM25().get(2017));
	        }
			else {
				PM25.put(data.Get_Ville(), PM25.get(data.Get_Ville()) + data.Get_PM25().get(2017) / List_Etablissement.size());
			}
		}
		
		NO2 = sortByValue(NO2);
		PM10 = sortByValue(PM10);
		PM25 = sortByValue(PM25);
		
		String[][] Data = new String[NO2.size()][3];
		int z = 0;
		for(Map.Entry<String, Double> data : NO2.entrySet()) {
			Data[z][0] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM10.entrySet()) {
			Data[z][1] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM25.entrySet()) {
			Data[z][2] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}

		return Data;
	}
	
	public String[][] Get_FO3_Data() {
		Map<String, Double> NO2 = new TreeMap<String, Double>();
		Map<String, Double> PM10 = new TreeMap<String, Double>();
		Map<String, Double> PM25 = new TreeMap<String, Double>();
		
		for(Etablissement data : this.List_Etablissement) {
			if(!NO2.containsKey(data.Get_Departement())) {
				NO2.put(data.Get_Departement(), data.Get_NO2().get(2017));
	        }
			else {
				NO2.put(data.Get_Departement(), NO2.get(data.Get_Departement()) + data.Get_NO2().get(2017) / List_Etablissement.size());
			}
			
			if(!PM10.containsKey(data.Get_Departement())) {
				PM10.put(data.Get_Departement(), data.Get_PM10().get(2017));
	        }
			else {
				PM10.put(data.Get_Departement(), PM10.get(data.Get_Departement()) + data.Get_PM10().get(2017) / List_Etablissement.size());
			}
			
			if(!PM25.containsKey(data.Get_Departement())) {
				PM25.put(data.Get_Departement(), data.Get_PM25().get(2017));
	        }
			else {
				PM25.put(data.Get_Departement(), PM25.get(data.Get_Departement()) + data.Get_PM25().get(2017) / List_Etablissement.size());
			}
		}
		
		NO2 = sortByValue(NO2);
		PM10 = sortByValue(PM10);
		PM25 = sortByValue(PM25);
		
		String[][] Data = new String[NO2.size()][3];
		int z = 0;
		for(Map.Entry<String, Double> data : NO2.entrySet()) {
			Data[z][0] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM10.entrySet()) {
			Data[z][1] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM25.entrySet()) {
			Data[z][2] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}

		return Data;
	}
	
	public String[][] Get_FO4_Data() {
		Map<String, Double> NO2 = new TreeMap<String, Double>();
		Map<String, Double> PM10 = new TreeMap<String, Double>();
		Map<String, Double> PM25 = new TreeMap<String, Double>();
		
		Integer Year = 2012;
		for(int i = 0; i < 6;i++) {
			for(Etablissement data : this.List_Etablissement) {
				
			}
			Year++;
		}
		
		NO2 = sortByValue(NO2);
		PM10 = sortByValue(PM10);
		PM25 = sortByValue(PM25);
		
		String[][] Data = new String[NO2.size()][3];
		int z = 0;
		for(Map.Entry<String, Double> data : NO2.entrySet()) {
			Data[z][0] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM10.entrySet()) {
			Data[z][1] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}
		z = 0;
		for(Map.Entry<String, Double> data : PM25.entrySet()) {
			Data[z][2] = "<html>" + data.getKey() + "<br>" + data.getValue() + "</html>";
        	z++;
		}

		return Data;
	}
	
	public static Map<String, Double> sortByValue(Map<String, Double> nO2) { 
        List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(nO2.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() { 
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        });  
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>(); 
        for (Map.Entry<String, Double> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }
}
