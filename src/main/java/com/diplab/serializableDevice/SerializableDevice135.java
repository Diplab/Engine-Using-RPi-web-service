package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device135Service;

public class SerializableDevice135 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8653220884398224973L;

	private SerializableDevice135() {
	}

	private static SerializableDevice135 device = new SerializableDevice135();

	public static SerializableDevice135 getInstanceOfSerializableDevice135() {
		return device;
	}

	public double cOppm() {
		return new Device135Service().getDevice135Port().cOppm();
	}

	public double getSmokePpm() {
		return new Device135Service().getDevice135Port().getSmokePpm();
	}

	public double co2Ppm() {
		return new Device135Service().getDevice135Port().co2Ppm();
	}
	
	public double readTemperature() {
		return new Device135Service().getDevice135Port().readTemperature();
	}

}
