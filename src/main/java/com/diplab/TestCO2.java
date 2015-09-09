package com.diplab;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

public class TestCO2 {

	public static void main(String[] args) throws InterruptedException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/rpi_light_co2.bpmn").deploy();

		processEngine.getRuntimeService()
				.startProcessInstanceByKey("myProcess");

	}

}
