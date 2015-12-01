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
	public void testExecuteAC() {
		device124Service.executeAC();
	}
	
	@Test
	public void testSetACTemperature28() {
		device124Service.setACtemperature28();
	}

	@Test
	public void testOff() {
		device124Service.off();
		Assert.assertEquals("should be off", PinState.LOW,
				device124Service.getState());
	}

	@Test
	public void testOn() {
		device124Service.on();
		Assert.assertEquals("should be on", PinState.HIGH,
				device124Service.getState());
	}

	@Test
	public void testToggle() {
		device124Service.on();
		device124Service.toggle();
		Assert.assertEquals("should be off", PinState.LOW,
				device124Service.getState());
		device124Service.toggle();
		Assert.assertEquals("should be on", PinState.HIGH,
				device124Service.getState());
	
	}

}
