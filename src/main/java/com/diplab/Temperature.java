package com.diplab;

import java.net.MalformedURLException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

public class Temperature {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		config.setJobExecutorActivate(true);

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/temperature.bpmn").deploy();

		// TODO NOT FINISH

		processEngine.getRuntimeService()
				.startProcessInstanceByKey("myProcess");

	}

}
