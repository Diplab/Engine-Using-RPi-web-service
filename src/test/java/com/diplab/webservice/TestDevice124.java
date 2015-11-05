package com.diplab.webservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDevice124 {
	Device124 device124Service;

	@Before
	public void initialize() {
		device124Service = new Device124Service().getDevice124Port();
	}

	@Test
	public void testCo2Ppm() {
		double co2Ppm = device124Service.co2Ppm();
		Assert.assertTrue("should above 400", co2Ppm >= 400);
		Assert.assertTrue("should above 2000", co2Ppm <= 2000);
	}

	@Test
	public void testExecuteAC() {
		device124Service.executeAC();
	}
	
	@Test
	public void testReadTemperature() {
		double temp = device124Service.readTemperature();
		Assert.assertTrue("should be room temp", Math.abs(temp - 35) < 30);
	}

}
