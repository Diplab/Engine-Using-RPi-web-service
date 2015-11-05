package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device127Service;

public class SerializableDevice127 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5126070719037126362L;

	private SerializableDevice127() {
	}

	private static SerializableDevice127 device = new SerializableDevice127();

	public static SerializableDevice127 getInstanceOfSerializableDevice127() {
		return device;
	}

	public double cOppm() {
		return new Device127Service().getDevice127Port().cOppm();
	}

	public double getSmokePpm() {
		return new Device127Service().getDevice127Port().getSmokePpm();
	}

	public double co2Ppm() {
		return new Device127Service().getDevice127Port().co2Ppm();
	}
	
	public double readTemperature() {
		return new Device127Service().getDevice127Port().readTemperature();
	}

}
