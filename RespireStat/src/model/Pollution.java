package model;

import java.util.HashMap;
import java.util.Map;

public class Pollution {
	Map<Integer, Double> NO2 = new HashMap<Integer, Double>();
	Map<Integer, Double> PM10 = new HashMap<Integer, Double>();
	Map<Integer, Double> PM25 = new HashMap<Integer, Double>();
	
	public Pollution(Map<Integer, Double> w_NO2, Map<Integer, Double> w_PM10, Map<Integer, Double> w_PM25) {
		this.NO2 = w_NO2;
		this.PM10 = w_PM10;
		this.PM25 = w_PM25;
	}
}
