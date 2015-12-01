package com.diplab;

import java.net.MalformedURLException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

public class SaveEnergy {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		config.setJobExecutorActivate(true);

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/SaveEnergy.bpmn")
				.addClasspathResource("bpmn/FireEscape.bpmn").deploy();

		processEngine.getRuntimeService().startProcessInstanceByKey(
				"process_pool1");

	}

}
