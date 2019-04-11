package model;

public class CoordGPS extends Etablissement {
	private double latitude;
	private double longitude;
	
	public CoordGPS(double w_latitude, double w_longitude) {
		super();
		this.latitude = w_latitude;
		this.longitude = w_longitude;
	}
}
