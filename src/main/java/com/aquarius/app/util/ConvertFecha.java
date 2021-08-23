package com.aquarius.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertFecha {
	
	public String getConvertFechaToText(Date fecha) {
		
		String pattern = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		String todayAsString = df.format(fecha);
		return todayAsString;
	}

}
