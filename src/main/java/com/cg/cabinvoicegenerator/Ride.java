package com.cg.cabinvoicegenerator;

public class Ride {
	public double distnce;
	public int time;

	enum RideType {
		NORMAL, PREMIUM
	}

	public RideType rideType;

	public Ride(double distance, int time, RideType rideType) {
		this.distnce = distance;
		this.time = time;
		this.rideType = rideType;
	}
}
