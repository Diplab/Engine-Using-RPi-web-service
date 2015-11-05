package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device124Service;


public class SerializableDevice124 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2397670423070881010L;

	private SerializableDevice124() {
	}

	private static SerializableDevice124 device = new SerializableDevice124();

	public static SerializableDevice124 getInstanceOfSerializableDevice124() {
		return device;
	}

	public double co2Ppm() {
		return new Device124Service().getDevice124Port().co2Ppm();
	}

	public void executeAC() {
		new Device124Service().getDevice124Port().executeAC();
	}
	
	public double readTemperature() {
		return new Device124Service().getDevice124Port().readTemperature();
	}

}
