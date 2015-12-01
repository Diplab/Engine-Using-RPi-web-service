package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device137Service;

public class SerializableDevice137 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973043010430106924L;

	private SerializableDevice137() {
	}

	private static SerializableDevice137 device = new SerializableDevice137();

	public static SerializableDevice137 getInstanceOfSerializableDevice137() {
		return device;
	}

	public double cOppm() {
		return new Device137Service().getDevice137Port().cOppm();
	}

	public double getSmokePpm() {
		return new Device137Service().getDevice137Port().getSmokePpm();
	}

	public double readTemperature() {
		return new Device137Service().getDevice137Port().readTemperature();
	}

}
