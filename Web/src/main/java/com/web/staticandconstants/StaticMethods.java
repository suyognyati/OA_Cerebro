package com.web.staticandconstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;

public class StaticMethods {
	
	@SuppressWarnings("unchecked")
	public static JSONObject ResponseJson(Boolean success, String successMessage, String errorMessage) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("successMessage", successMessage);
		jsonObject.put("errorMessage", errorMessage);
		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject ResponseJson(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject AddToJsonObject(JSONObject obj, String key, Object value) {
		obj.put(key, value);
		return obj;
	}
	
	public static String GetCurrentDateString(String format) {
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(today);
	}
	
	public static Date GetCurrentDate() {
		Date today = new Date();
		return today;
	}
	
	public static Integer GetCourseStartYear() {
		Calendar today = Calendar.getInstance();
		return today.get(Calendar.YEAR);
	}
}
