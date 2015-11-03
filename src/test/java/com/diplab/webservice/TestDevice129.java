package com.diplab.webservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diplab.webservice.Device129;
import com.diplab.webservice.Device129Service;
import com.diplab.webservice.PinState;

public class TestDevice129 {
	Device129 device129Service;

	@Before
	public void initialize() {
		device129Service = new Device129Service().getDevice129Port();
	}

	@Test
	public void testCo2Ppm() {
		double co2Ppm = device129Service.co2Ppm();
		Assert.assertTrue("should above 400", co2Ppm >= 400);
		Assert.assertTrue("should above 2000", co2Ppm <= 2000);
	}

	@Test
	public void testCoPpm(){
		double coPpm = device129Service.cOppm();
		Assert.assertTrue("should above 0", coPpm >= 0);
		Assert.assertTrue("should above 2000", coPpm <= 2000);
	}

	@Test
	public void testLock() {
		device129Service.lock();
	}

	@Test
	public void testUnlock() {
		device129Service.unlock();
	}
	
	@Test
	public void testSmokePpm(){
		double smokePpm = device129Service.getSmokePpm();
		Assert.assertTrue("should above 0", smokePpm >= 0);
		Assert.assertTrue("should above 2000", smokePpm <= 2000);
	}

	@Test
	public void testOff() {
		device129Service.off();
		Assert.assertEquals("should be off", PinState.LOW,
				device129Service.getState());
	}

	@Test
	public void testOn() {
		device129Service.on();
		Assert.assertEquals("should be on", PinState.HIGH,
				device129Service.getState());
	}

	@Test
	public void testToggle() {
		device129Service.on();
		device129Service.toggle();
		Assert.assertEquals("should be off", PinState.LOW,
				device129Service.getState());
		device129Service.toggle();
		Assert.assertEquals("should be on", PinState.HIGH,
				device129Service.getState());

	}

	@Test
	public void testReadTemperature() {
		double temp = device129Service.readTemperature();
		Assert.assertTrue("should be room temp", Math.abs(temp - 35) < 30);
	}

}
