package com.diplab;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.apache.ibatis.session.SqlSession;

import com.diplab.db.Sensor;
import com.diplab.db.SensorMapper;

import com.diplab.serializableDevice.SerializableDevice129;

public class CopyOfEscape {

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		ProcessEngineConfigurationImpl config = new StandaloneProcessEngineConfiguration();
		config.setDatabaseSchemaUpdate("drop-create");
		Set<Class<?>> customMybatisMappers = new HashSet<>();
		customMybatisMappers.add(SensorMapper.class);
		config.setCustomMybatisMappers(customMybatisMappers);
		ProcessEngine enginge = config.buildProcessEngine();

		enginge.getManagementService().executeCommand(
				(commandContext) -> {
					SqlSession sqlSession = commandContext.getDbSqlSession()
							.getSqlSession();
					SensorMapper mapper = sqlSession
							.getMapper(SensorMapper.class);

//					Sensor sensor = new Sensor();
//					sensor.setDevice(SerializableDevice129
//							.getInstanceOfSerializableDevice129().getDevice());
//					sensor.setType(SerializableDevice129
//							.getInstanceOfSerializableDevice129().getTypeCO());
//					sensor.setData(SerializableDevice129
//							.getInstanceOfSerializableDevice129().cOppm());
//					sensor.setTime(new Date());
//					mapper.insert(sensor);
					System.out.println(mapper.selectType("CO", "Device129"));
					float avg = mapper.selectAVG("CO", "Device129");
					System.out.println(avg);
					return commandContext;

				});
	}

}
