package com.cg.cabinvoicegenerator;

public class PremiumInvoiceGenerator {
	public static final double MIN_COST_PER_KM = 15.0;
	public static final int COST_PER_TIME = 2;
	public static final double MIN_FARE = 20.0;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MIN_FARE);
	}
}