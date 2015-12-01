package com.diplab;

import java.net.MalformedURLException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnvironmentControl {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		// ProcessEngineConfiguration configuration = new
		// StandaloneInMemProcessEngineConfiguration();
		// configuration.setAsyncExecutorActivate(true);
		// configuration.setAsyncExecutorEnabled(true);
		// ProcessEngine engine = configuration.buildProcessEngine();
		// engine.getRepositoryService().createDeployment()
		// .addClasspathResource("bpmn/ts1.bpmn").deploy();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");

		// context.getBean(RuntimeService.class).startProcessInstanceByKey(
		// "process_pool1");

		// sqlSession.close();
		// context.close();
	}

}
