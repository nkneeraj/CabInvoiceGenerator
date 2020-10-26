package com.cg.cabinvoicegenerator;

public class InvoiceGenerator {
	public static final double MIN_COST_PER_KM = 10.0;
    public static final int COST_PER_TIME = 1;
    public static final double MIN_FARE = 5.0;
    
    public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
	 return Math.max(totalFare, MIN_FARE);
	}
    
    public double calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
}
