package com.web.session;

import org.json.simple.JSONObject;

public class StaticMethods {
	
	public final static String StrINDIA = "India";
	public static String UploadDocumentPath = "D:\\admissions\\";
	
	@SuppressWarnings("unchecked")
	public static JSONObject ResponseJson(Boolean success, String successMessage, String errorMessage) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("successMessage", successMessage);
		jsonObject.put("errorMessage", errorMessage);
		return jsonObject;
	}
}
