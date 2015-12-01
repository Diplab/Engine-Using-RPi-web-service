package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device129;
import com.diplab.webservice.Device129Service;
import com.diplab.webservice.PinState;

public class SerializableDevice129 implements Serializable, Device129 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1899059621734420049L;

	private SerializableDevice129() {
	}

	private static SerializableDevice129 device = new SerializableDevice129();

	public static SerializableDevice129 getInstanceOfSerializableDevice129() {
		return device;
	}
	
	public String getDevice(){
		return "Device129";
		
	}
	
	public String getTypeCO(){
		return "CO";
		
	}
	
	public String getTypeCO2(){
		return "CO2";
		
	}

	public double cOppm() {
		return new Device129Service().getDevice129Port().cOppm();
	}

	public double co2Ppm() {
		return new Device129Service().getDevice129Port().co2Ppm();
	}

	public double getSmokePpm() {
		return new Device129Service().getDevice129Port().getSmokePpm();
	}

	public double readTemperature() {
		return new Device129Service().getDevice129Port().readTemperature();
	}

	public void off() {
		new Device129Service().getDevice129Port().off();
	}

	public void on() {
		new Device129Service().getDevice129Port().on();
	}

	public void toggle() {
		new Device129Service().getDevice129Port().toggle();
	}

	public PinState getState() {
		return new Device129Service().getDevice129Port().getState();
	}

	public void lock() {
		new Device129Service().getDevice129Port().lock();
	}

	public void unlock() {
		new Device129Service().getDevice129Port().unlock();
	}
	
}