package com.web.staticandconstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import config.web.WebConfig;

public class StaticConstants {
	
	public static final String StrINDIA = "India";
	public static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);
	
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
	
}