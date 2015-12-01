package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device133Service;

public class SerializableDevice133 implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4476090144633752033L;

	private SerializableDevice133() {
	}
	
	private static SerializableDevice133 device = new SerializableDevice133();

	public static SerializableDevice133 getInstanceOfSerializableDevice133() {
		return device;
	}

	public double cOppm() {
		return new Device133Service().getDevice133Port().cOppm();
	}

	public double co2Ppm() {
		return new Device133Service().getDevice133Port().co2Ppm();
	}

	public double getSmokePpm() {
		return new Device133Service().getDevice133Port().getSmokePpm();
	}

	public double readTemperature() {
		return new Device133Service().getDevice133Port().readTemperature();
	}

}
