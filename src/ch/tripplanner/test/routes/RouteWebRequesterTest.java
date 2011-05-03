package ch.tripplanner.test.routes;

import junit.framework.Assert;
import android.location.Location;
import ch.tripplanner.routes.Route;
import ch.tripplanner.routes.RouteRequest;
import ch.tripplanner.routes.RouteWebRequester;

public class RouteWebRequesterTest {

	public void testWebRequest(){		
		Location start = new LocationMock(46.57, 7.28);
		Location destination = new LocationMock(47.35, 7.35);
		/*
		RouteRequest request = new RouteRequest(start, destination, Route.Type.PUBLIC_TRANSPORTATION);
		RouteWebRequester requester = new RouteWebRequester(request);
		Route route = requester.executeWebRequest();
		Assert.assertNotNull(route);*/
	}
}
