package ch.tripplanner.test.routes;

import junit.framework.TestCase;
import android.location.Location;
import android.location.LocationManager;
import ch.tripplanner.routes.Route;
import ch.tripplanner.routes.RouteType;

public class RouteTest extends TestCase {

	public void test_intialize_type(){
		//Arrange
		RouteType type = RouteType.CAR;
		
		//Act
		Route route = new Route(type);
		
		//Assert
		assertEquals(type, route.getType());
	}
	
	public void test_initialize_all(){
		//Arrange
		RouteType type = RouteType.CAR;
		Location start = new Location(LocationManager.GPS_PROVIDER);
		Location destination = new Location(LocationManager.GPS_PROVIDER);
		long duration = 150000;
		
		//Act
		Route route = new Route(type, start, destination, duration);
		
		//Assert
		assertEquals(type, route.getType());
		assertEquals(start, route.getStart());
		assertEquals(destination, route.getDestination());
		assertEquals(duration, route.getDuration());
	}
}
