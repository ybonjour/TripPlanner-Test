package ch.tripplanner.test.routes;

import junit.framework.TestCase;
import android.location.Location;
import ch.tripplanner.routes.Route;
import ch.tripplanner.routes.RouteRequest;
import ch.tripplanner.routes.RouteType;
import ch.tripplanner.routes.RouteWebRequester;

public class RouteWebRequesterTest extends TestCase{

	public void test_WebRequest(){
		//Arrange
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		RouteType type = RouteType.PUBLIC_TRANSPORTATION;
		RouteRequest request = new RouteRequest(start, destination, type);
		
		//Act
		RouteWebRequester requester = new RouteWebRequester(request);
		Route route = requester.executeWebRequest();
		
		//Assert
		assertNotNull(route);
		assertEquals(start.getLongitude(), route.getStart().getLongitude());
		assertEquals(start.getLatitude(), route.getStart().getLatitude());
		assertEquals(destination.getLongitude(), route.getDestination().getLongitude());
		assertEquals(destination.getLatitude(), route.getDestination().getLatitude());
		assertEquals(route.getType(), type);
		assertTrue(route.getDuration() > 0);
	}
}
