package com.diplab.webservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDevice127 {
	Device127 device127Service;

	@Before
	public void initialize() {
		device127Service = new Device127Service().getDevice127Port();
	}

	@Test
	public void testCo2Ppm() {
		double co2Ppm = device127Service.co2Ppm();
		Assert.assertTrue("should above 400", co2Ppm >= 400);
		Assert.assertTrue("should above 2000", co2Ppm <= 2000);
	}

	@Test
	public void testCoPpm() {
		double coPpm = device127Service.cOppm();
		Assert.assertTrue("should above 0", coPpm >= 0);
		Assert.assertTrue("should above 2000", coPpm <= 2000);
	}

	@Test
	public void testSmokePpm() {
		double smokePpm = device127Service.getSmokePpm();
		Assert.assertTrue("should above 0", smokePpm >= 0);
		Assert.assertTrue("should above 2000", smokePpm <= 2000);
	}
	
	@Test
	public void testReadTemperature() {
		double temp = device127Service.readTemperature();
		Assert.assertTrue("should be room temp", Math.abs(temp - 35) < 30);
	}

}
