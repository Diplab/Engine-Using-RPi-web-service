package com.diplab;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

import com.diplab.serviceimp.HelloService129;
import com.diplab.serviceimp.HelloService129ImplService;
import com.diplab.serviceimp.HelloService131;
import com.diplab.serviceimp.HelloService131ImplService;
import com.diplab.serviceimp.IOException;

public class EscapeClient {

	private static HelloService129 helloService_129ImplPort = new HelloService129ImplService()
			.getHelloService129ImplPort();
	private static HelloService131 helloService_131ImplPort = new HelloService131ImplService()
			.getHelloService131ImplPort();

	public static void main(String[] args) throws InterruptedException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		config.setJobExecutorActivate(true);

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/escape.bpmn").deploy();

		processEngine.getRuntimeService()
				.startProcessInstanceByKey("myProcess");

	}

	public static double co2Ppm129() {
		return helloService_129ImplPort.co2Ppm();
	}

	public static double co2Ppm131() {
		return helloService_131ImplPort.co2Ppm();
	}

	public static double temperature() {

		return helloService_129ImplPort.random();
	}

	public static String sayHello129(String arg0) {
		return helloService_129ImplPort.sayHello(arg0);
	}

	public static void off_129() {
		helloService_129ImplPort.off();
		return;
	}

	public static void on_129() {
		helloService_129ImplPort.on();
		return;
	}

	public static void toggle_129() {
		helloService_129ImplPort.toggle();
		return;
	}

	public static void executeAC_131() {
		helloService_131ImplPort.executeAC();
		return;
	}

	public static double read() throws IOException {
		return helloService_129ImplPort.readTemperature();
	}

}
