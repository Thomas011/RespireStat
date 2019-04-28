package model;

import java.util.Map;

public class CoordGPS {
	private double latitude;
	private double longitude;
	
	public CoordGPS(Map<String, String> data_etablissement) {
		String temp = data_etablissement.get("geometry");
	    String temp_ = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
	    String[] temp__ = temp_.split(", ");
	    
	    this.latitude = Double.parseDouble(temp__[0]);
	    this.longitude = Double.parseDouble(temp__[1]);
	}
	
	public double Get_La() {
		return this.latitude;
	}
	
	public double Get_Lo() {
		return this.longitude;
	}
}
