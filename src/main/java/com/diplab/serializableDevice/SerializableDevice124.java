package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device124Service;
import com.diplab.webservice.PinState;

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

	public void executeAC() {
		new Device124Service().getDevice124Port().executeAC();
	}
	
	public void setACtemperature28() {
		new Device124Service().getDevice124Port().setACtemperature28();
		
	}
	
	public void off() {
		new Device124Service().getDevice124Port().off();
	}

	public void on() {
		new Device124Service().getDevice124Port().on();
	}

	public void toggle() {
		new Device124Service().getDevice124Port().toggle();
	}

	public PinState getState() {
		return new Device124Service().getDevice124Port().getState();
	}

}
