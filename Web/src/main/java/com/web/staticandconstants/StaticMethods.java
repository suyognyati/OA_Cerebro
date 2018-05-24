package com.web.staticandconstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;

public class StaticMethods {
	
	//public static String UploadDocumentPath = "D:\\admissions\\";
	
	@SuppressWarnings("unchecked")
	public static JSONObject ResponseJson(Boolean success, String successMessage, String errorMessage) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("successMessage", successMessage);
		jsonObject.put("errorMessage", errorMessage);
		return jsonObject;
	}
	
	public static String GetCurrentDateString(String format) {
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(today);
	}
	
	public static Integer GetCourseStartYear() {
		Calendar today = Calendar.getInstance();
		return today.get(Calendar.YEAR);
	}
}
