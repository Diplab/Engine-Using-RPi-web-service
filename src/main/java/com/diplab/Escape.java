package com.diplab;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

import com.diplab.webservice.Device129;
import com.diplab.webservice.Device129Service;
import com.diplab.webservice.Device131;
import com.diplab.webservice.Device131Service;
import com.diplab.webservice.PinState;

public class Escape {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		config.setJobExecutorActivate(true);

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/escape.bpmn").deploy();

		Map<String, Object> processVariable = new HashMap<>();
		Device129 device129 = new SerializableDevice129();
		Device131 device131 = new SerializableDevice131();
		processVariable.put("device129", device129);
		processVariable.put("device131", device131);

		processEngine.getRuntimeService().startProcessInstanceByKey(
				"myProcess", processVariable);

	}

}

class SerializableDevice129 implements Serializable, Device129 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1899059621734420049L;

	public void off() {
		new Device129Service().getDevice129Port().off();
	}

	public void on() {
		new Device129Service().getDevice129Port().on();
	}

	public void toggle() {
		new Device129Service().getDevice129Port().toggle();
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

	public double cOppm() {
		return new Device129Service().getDevice129Port().cOppm();
	}

	public void lock() {
		new Device129Service().getDevice129Port().lock();
	}

	public PinState getState() {
		return new Device129Service().getDevice129Port().getState();
	}

	public void unlock() {
		new Device129Service().getDevice129Port().unlock();
	}
}

class SerializableDevice131 implements Serializable, Device131 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2319477314319117003L;

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
}
