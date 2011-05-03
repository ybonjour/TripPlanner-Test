package ch.tripplanner.test.routes;

import android.location.Location;
import ch.tripplanner.routes.RouteRequest;
import ch.tripplanner.routes.RouteType;
import junit.framework.TestCase;

public class RouteRequestTest extends TestCase {

	public void test_initialize_start_null(){
		Location destination = new LocationMock(47.35, 7.35);
		RouteType type = RouteType.CAR;
		
		try{
			new RouteRequest(null, destination, type);
			fail();
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_initialize_destination_null(){
		Location start = new LocationMock(46.57, 7.28);
		RouteType type = RouteType.CAR;
		
		try{
			new RouteRequest(start, null, type);
			fail();
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_initialize_type_null(){
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		
		try{
			new RouteRequest(start, destination, null);
			fail();
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_initialize(){	
		//Arrange
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		RouteType type = RouteType.CAR;
			
		//Act
		RouteRequest request = new RouteRequest(start, destination, type);
		
		//Assert
		assertEquals(start, request.getStart());
		assertEquals(destination, request.getDestination());
		assertEquals(type, request.getType());
	}
}