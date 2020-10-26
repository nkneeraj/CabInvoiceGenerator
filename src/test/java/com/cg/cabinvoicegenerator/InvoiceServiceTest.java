package com.cg.cabinvoicegenerator;

import org.junit.Test;

import com.cg.cabinvoicegenerator.Ride.RideType;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator;
	PremiumInvoiceGenerator premiumGenerator;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
		premiumGenerator = new PremiumInvoiceGenerator();
	}

	@Test
	public void givenDistanceTimeReturnFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceTimeReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL ),
				        new Ride(0.1, 1, RideType.NORMAL)
		                };
		InvoiceSummary summary = Invoice.calculateFare(rides);
		InvoiceSummary expected = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expected,summary);
	}
	
	@Test
	public void givenUserIdReturnInvoiceSummary(){
		String userId = "Neeraj";
		RideRepository rideRepository = new RideRepository();
		Ride[] rides = {new Ride(2.0, 5, RideType.NORMAL),
		        new Ride(0.1, 1, RideType.NORMAL)};
         rideRepository.addUserRide(userId, rides);   
        Ride[] userRides = rideRepository.getUserRides(userId);
        Assert.assertEquals(rides[1], userRides[1]);
	}
	
	@Test
	public void givenPremiumRidesReturnInvoiceSummary(){
		
		Ride[] rides = {new Ride(2.0, 5, RideType.PREMIUM),
		        new Ride(0.1, 1, RideType.PREMIUM)};   
        double summary = Invoice.calculateFare(rides).totalFare;
 		double expected = new InvoiceSummary(2, 60.0).totalFare;
        Assert.assertEquals(expected, summary,0.0);
	}
}