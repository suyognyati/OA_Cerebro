package com.web.session;

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
}
