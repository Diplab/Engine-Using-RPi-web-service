package com.diplab.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.glassfish.gmbal.ParameterNames;

public interface SensorMapper {

	@Results({ @Result(property = "rank", column = "RANK"),
			@Result(property = "device", column = "DEVICE"),
			@Result(property = "type", column = "TYPE"),
			@Result(property = "data", column = "DATA"),
			@Result(property = "time", column = "TIME") })
	@Insert("INSERT INTO SENSOR (DEVICE ,TYPE ,DATA ,TIME) VALUES (#{device},#{type},#{data},#{time})")
	void insert(Sensor sensor);

	@Select("SELECT * from SENSOR WHERE RANK = #{rank}")
	Sensor selectSensor(int rank);

	@Select("SELECT * from SENSOR WHERE TYPE = #{type} and Device = #{device} ORDER BY TYPE LIMIT 2")
	public List<Sensor> selectType(@Param("type") String type, @Param("device") String device);

	@Select("SELECT AVG(DATA) FROM SENSOR WHERE TYPE = #{type} and Device = #{device} ORDER BY TYPE LIMIT 30")
	float selectAVG(@Param("type") String type, @Param("device") String device);

	@Delete("DELETE FROM SENSOR WHERE RANK =#{rank}")
	void delete(int rank);

	@Update("UPDATE SENSOR SET DEVICE=#{device}, TYPE=#{type}, DATA=#{data}, TIME=#{time}  WHERE RANK =#{rank}")
	void update(Sensor sensor);

}
