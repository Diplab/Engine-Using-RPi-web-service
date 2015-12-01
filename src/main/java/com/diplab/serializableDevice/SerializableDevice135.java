package com.diplab.serializableDevice;

import java.io.Serializable;

import com.diplab.webservice.Device135Service;
import com.diplab.webservice.PinState;

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
	
	public String getDevice(){
		return "Device135";
		
	}
	
	public String getTypeCO(){
		return "CO";
		
	}
	
	public String getTypeCO2(){
		return "CO2";
		
	}

	public double cOppm() {
		return new Device135Service().getDevice135Port().cOppm();
	}

	public double co2Ppm() {
		return new Device135Service().getDevice135Port().co2Ppm();
	}

	public double getSmokePpm() {
		return new Device135Service().getDevice135Port().getSmokePpm();
	}

	public double readTemperature() {
		return new Device135Service().getDevice135Port().readTemperature();
	}

	public void off() {
		new Device135Service().getDevice135Port().off();
	}

	public void on() {
		new Device135Service().getDevice135Port().on();
	}

	public void toggle() {
		new Device135Service().getDevice135Port().toggle();
	}

	public PinState getState() {
		return new Device135Service().getDevice135Port().getState();
	}

}
