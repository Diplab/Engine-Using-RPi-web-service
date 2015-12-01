package com.diplab.serializableDevice;

import org.joda.time.DateTime;


public class ReadTime {

	public static int readtime() {
		int timehour = DateTime.now().getHourOfDay();
		System.out.println(timehour);
		return timehour;
	}

}
