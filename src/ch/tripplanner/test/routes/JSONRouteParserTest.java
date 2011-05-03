package ch.tripplanner.test.routes;

import junit.framework.TestCase;
import android.location.Location;
import ch.tripplanner.routes.JSONRouteParser;
import ch.tripplanner.routes.Route;
import ch.tripplanner.routes.RouteType;

public class JSONRouteParserTest extends TestCase {
	
	public void test_initialize_null(){
		try{
			new JSONRouteParser(null);
			fail();
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_initialize_emptyString(){
		try{
			new JSONRouteParser("");
			fail();
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_initialize_non_JSON(){
		try{
			new JSONRouteParser("blabla");
		}catch(IllegalArgumentException e){
			//Test succeeded
		}
	}
	
	public void test_parse_route(){
		//Arrange
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		RouteType type = RouteType.CAR;
		int duration = 5000;
		String input = createJSONRouteString(start, destination, type, duration);
		
		//Act
		JSONRouteParser parser = new JSONRouteParser(input);
		Route route = parser.parseRoute();
		
		//Assert
		assertNotNull(route);
		assertEquals(type, route.getType());
		assertEquals(start.getLongitude(), route.getStart().getLongitude());
		assertEquals(start.getLatitude(), route.getStart().getLatitude());
		assertEquals(destination.getLongitude(), route.getDestination().getLongitude());
		assertEquals(destination.getLatitude(), route.getDestination().getLatitude());
		assertEquals(duration, route.getDuration());
	}
	
	public void test_isStatusOk(){
		//Arrange
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		RouteType type = RouteType.CAR;
		int duration = 5000;
		String input = createJSONRouteString(start, destination, type, duration);
		
		//Act
		JSONRouteParser parser = new JSONRouteParser(input);
		boolean statusOk = parser.isStatusOk();
		
		//Assert
		assertTrue(statusOk);
	}
	
	public void test_isStatusOk_with_error(){
		//Arrange
		String input = createJSONErrorString();
		
		//Act
		JSONRouteParser parser = new JSONRouteParser(input);
		boolean statusOk = parser.isStatusOk();
		
		//Assert
		assertFalse(statusOk);
	}
	
	public void test_isStatusOk_with_no_status(){
		//Arrange
		String input = "{\"foo\":\"true\"}";
		
		//Act
		JSONRouteParser parser = new JSONRouteParser(input);
		try{
			parser.isStatusOk();
			fail();
		}catch(RuntimeException e){
			//Test succeeded
		}
		
	}
	
	private String createJSONErrorString(){
		return "{\"status\":\"ERROR\",\"message\":\"Some error description\"}";
	}
	
	private String createJSONRouteString(Location start, Location destination, RouteType type, int duration){
		return "{\"status\":\"OK\",\"route\":{\"startLongitude\":\"" + start.getLongitude() + "\","
		+ "\"startLatitude\":\"" + start.getLatitude() + "\","
		+ "\"destinationLongitude\":\"" + destination.getLongitude() + "\","
		+ "\"destinationLatitude\":\"" + destination.getLatitude() + "\","
		+ "\"type\":\"" + type.getCode() + "\","
		+ "\"duration\":\"" + duration + "\"}}";
	}
	
}
