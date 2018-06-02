package com.web.staticandconstants;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public static DateFormat GetDateFormat(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat;
	}
	
	/**
	 * This function will convert object to json string
	 * @param object
	 * @return String
	 */
	public static String GetJsonStringFromObject(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		return convertToJsonString(objectMapper, object);
	}
	
	/**
	 * This function will convert object to json string by replacing dates in given format
	 * @param object
	 * @param dateFormat
	 * @return String
	 */
	public static String GetJsonStringFromObject(Object object, String dateFormat) {
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setDateFormat(GetDateFormat(dateFormat));
		return convertToJsonString(objectMapper, object);
	}
	
	/**
	 * This function will convert object to json string by replacing dates in given format
	 * @param object
	 * @param dateFormat
	 * @return String
	 */
	public static String GetJsonStringFromObject(Object object, DateFormat dateFormat) {
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setDateFormat(dateFormat);
		return convertToJsonString(objectMapper, object);
	}
	
	
	
	/* ---------------------------------- Private functions -------------------------------------*/	
	
	private static String convertToJsonString(ObjectMapper objectMapper, Object object) {
		String returnJson = ""; 
		try {
			returnJson = objectMapper.writeValueAsString(object);
		} catch(IOException e) {
			
		}
		return returnJson;
	}
}
