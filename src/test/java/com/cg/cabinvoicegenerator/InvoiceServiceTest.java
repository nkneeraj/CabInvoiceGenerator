package com.cg.cabinvoicegenerator;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
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
		Ride[] rides = {new Ride(2.0, 5),
				        new Ride(0.1, 1)
		                };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expected = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expected,summary);
	}
}