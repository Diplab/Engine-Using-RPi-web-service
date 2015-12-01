package com.diplab.webservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDevice137 {
	Device137 device137Service;

	@Before
	public void initialize() {
		device137Service = new Device137Service().getDevice137Port();
	}

	@Test
	public void testCoPpm() {
		double coPpm = device137Service.cOppm();
		Assert.assertTrue("should above 0", coPpm >= 0);
		Assert.assertTrue("should above 2000", coPpm <= 2000);
	}

	@Test
	public void testSmokePpm() {
		double smokePpm = device137Service.getSmokePpm();
		Assert.assertTrue("should above 0", smokePpm >= 0);
		Assert.assertTrue("should above 2000", smokePpm <= 2000);
	}

	@Test
	public void testReadTemperature() {
		double temp = device137Service.readTemperature();
		Assert.assertTrue("should be room temp", Math.abs(temp - 35) < 30);
	}

}
