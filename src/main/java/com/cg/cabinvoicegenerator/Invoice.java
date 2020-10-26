package com.cg.cabinvoicegenerator;

public class Invoice {

	public static InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			if (ride.rideType == Ride.RideType.NORMAL)
				totalFare += new InvoiceGenerator().calculateFare(ride.distnce, ride.time);
			else if (ride.rideType == Ride.RideType.PREMIUM)
				totalFare += new PremiumInvoiceGenerator().calculateFare(ride.distnce, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}
