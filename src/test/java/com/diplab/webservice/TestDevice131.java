package com.diplab.webservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDevice131 {

	Device131 device131Service;

	@Before
	public void setUp() throws Exception {
		device131Service = new Device131Service().getDevice131Port();
	}

//	@Test
//	public void testExecuteAC() {
//		device131Service.executeAC();
//	}
//
//	@Test
//	public void testOff() {
//		device131Service.off();
//		Assert.assertEquals("should be off", PinState.LOW,
//				device131Service.getState());
//	}
//
//	@Test
//	public void testOn() {
//		device131Service.on();
//		Assert.assertEquals("should be on", PinState.HIGH,
//				device131Service.getState());
//	}
//
//	@Test
//	public void testToggle() {
//		device131Service.on();
//		device131Service.toggle();
//		Assert.assertEquals("should be off", PinState.LOW,
//				device131Service.getState());
//		device131Service.toggle();
//		Assert.assertEquals("should be on", PinState.HIGH,
//				device131Service.getState());
//
//	}
	
//	@Test
//	public void testAlertOn() {
//		device131Service.alerton();
//		Assert.assertEquals("should be on", PinState.HIGH,
//				device131Service.getAlertState());
//	}
	
	@Test
	public void testalertOff() {
		device131Service.alertoff();
		Assert.assertEquals("should be off", PinState.LOW,
				device131Service.getState());
	}

}
