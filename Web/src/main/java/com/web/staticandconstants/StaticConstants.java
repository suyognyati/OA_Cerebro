package com.web.staticandconstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import config.web.WebConfig;

public class StaticConstants {
	
	public static final String StrINDIA = "India";
	public static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);
	
	private static final Integer secondsInMinute = 60;
	private static final Integer secondsInHour = (60 * secondsInMinute);
	private static final Integer secondsInDay = (24 * secondsInHour);
	
	public static final Integer httpSessionTimeOut = 4 * secondsInHour;
	
	public static final Integer ProgramCategoryTotalName = 0;
	
	public static class ROLE {
		
		public static final String SUPERADMIN = "SUPERADMIN";
		public static final String ADMIN = "ADMIN";
		public static final String COLLEGEADMIN = "COLLEGEADMIN";
		public static final String VENDOR = "VENDOR";
		public static final String STUDENT = "STUDENT";
		
		public static final String DatabaseRolePrefix = "ROLE_";

		public static final String ROLE_SUPERADMIN = DatabaseRolePrefix + SUPERADMIN;
		public static final String ROLE_ADMIN = DatabaseRolePrefix + ADMIN;
		public static final String ROLE_COLLEGEADMIN = DatabaseRolePrefix + COLLEGEADMIN;
		public static final String ROLE_VENDOR = DatabaseRolePrefix + VENDOR;
		public static final String ROLE_STUDENT = DatabaseRolePrefix + STUDENT;
	}
	
	/*Date formats*/
	public static class DATEFORMAT {
		public static final String ddMMyyyy = "dd-MM-yyyy";
		public static final String yyyyMMdd = "yyyy-MM-dd";
		
	}
	
	
}