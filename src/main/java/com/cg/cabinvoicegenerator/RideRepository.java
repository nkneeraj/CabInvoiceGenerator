package com.cg.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
 Map<String, ArrayList<Ride>> rideMap;

 public RideRepository() {
	 this.rideMap = new HashMap<>();
 }

 public void addUserRide(String userId, Ride[] rides) {
		if (userId != null)
			rideMap.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
	}

 public Ride[] getUserRides(String userId) {
	 if(rideMap.containsKey(userId))
		return rideMap.get(userId).toArray(new Ride[0]);
	 return null;
	}
}
