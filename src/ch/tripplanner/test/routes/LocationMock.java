package ch.tripplanner.test.routes;

import android.location.Location;
import android.location.LocationManager;

public class LocationMock extends Location {

	private double latitude;
	private double longitude;
	
	public LocationMock(double latitude, double longitude) {
		super(LocationManager.GPS_PROVIDER);
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public double getLatitude() {
		return this.latitude;
	}
	
	@Override
	public double getLongitude() {
		return this.longitude;
	}
	
	

	
}
