package com.diplab;

import java.net.MalformedURLException;
import java.net.URL;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;

import com.diplab.serviceimp.EscapeService;
import com.diplab.serviceimp.EscapeServiceImplService;

public class Escape {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		ProcessEngineConfigurationImpl config = new StandaloneInMemProcessEngineConfiguration();

		config.setJobExecutorActivate(true);

		final ProcessEngine processEngine = config.buildProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.disableSchemaValidation().disableBpmnValidation()
				.addClasspathResource("bpmn/escape.bpmn").deploy();

		processEngine.getRuntimeService()
				.startProcessInstanceByKey("myProcess");
		

	}

	public static double co2Ppm129() throws MalformedURLException {
		Double co2 = new EscapeServiceImplService(new URL(
				"http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort().co2Ppm();
		return co2;
	}

	public static double co2Ppm131() throws MalformedURLException {
		Double co2 = new EscapeServiceImplService(new URL(
				"http://192.168.0.131:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort().co2Ppm();
		return co2;
	}

	public static void off_129() throws MalformedURLException {
		EscapeService EscapeService_129ImplPort = new EscapeServiceImplService(
				new URL("http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort();
		EscapeService_129ImplPort.off();
		return;
	}

	public static void on_129() throws MalformedURLException {
		EscapeService EscapeService_129ImplPort = new EscapeServiceImplService(
				new URL("http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort();
		EscapeService_129ImplPort.on();
		return;
	}

	public static void executeAC_131() throws MalformedURLException {
		EscapeService EscapeService_131ImplPort = new EscapeServiceImplService(
				new URL("http://192.168.0.131:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort();
		EscapeService_131ImplPort.executeAC();
		return;
	}

	public static double read() throws MalformedURLException {
		Double temperatuer = new EscapeServiceImplService(new URL(
				"http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort().readTemperature();
		return temperatuer;
	}

	public static void lock() throws MalformedURLException {
		new EscapeServiceImplService(new URL(
				"http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort().lock();
	}

	public static void unlock() throws MalformedURLException {
		new EscapeServiceImplService(new URL(
				"http://192.168.0.129:9005/webservice/Escape?wsdl"))
				.getEscapeServiceImplPort().unlock();
	}

}
