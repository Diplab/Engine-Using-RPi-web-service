package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device131;
import com.diplab.webservice.Device131Service;
import com.diplab.webservice.PinState;

public class SerializableDevice131 implements Serializable, Device131{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2319477314319117003L;

	private SerializableDevice131() {
	}

	private static SerializableDevice131 device = new SerializableDevice131();

	public static SerializableDevice131 getInstanceOfSerializableDevice131() {
		return device;
	}

	public void off() {
		new Device131Service().getDevice131Port().off();
	}

	public void on() {
		new Device131Service().getDevice131Port().on();
	}

	public double getSmokePpm() {
		return new Device131Service().getDevice131Port().getSmokePpm();
	}

	public void executeAC() {
		new Device131Service().getDevice131Port().executeAC();
	}

	public double cOppm() {
		return new Device131Service().getDevice131Port().cOppm();
	}

	public void toggle() {
		new Device131Service().getDevice131Port().toggle();
	}

	public PinState getState() {
		return new Device131Service().getDevice131Port().getState();
	}
	
	public double readTemperature() {
		return new Device131Service().getDevice131Port().readTemperature();
	}
}