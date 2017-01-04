package com.data.entities;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enums {
		
	public static class KeyValuePair {
		int key;
		String value;
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	
	public enum Gender {
		Male(1, "Male"), 
		Female(2, "Female");

		private int id;
		private String value;
		private static final Map<Integer, Gender> lookup = new HashMap<Integer, Gender>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();

		private Gender(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (Gender s : EnumSet.allOf(Gender.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static Gender get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum MaritalStatus {
		Unmarried(1, "Unmarried"),
		Married(2, "Married"),
		Divorced(3, "Divorced"),
		Widowed(4, "Widowed"),
		Deserted(5, "Deserted");
		
		
		private int id;
		private String value;
		private static final Map<Integer, MaritalStatus> lookup = new HashMap<Integer, MaritalStatus>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private MaritalStatus(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (MaritalStatus s : EnumSet.allOf(MaritalStatus.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static MaritalStatus get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum BloodGroup {
		A_positive(1, "A +ve"),
		A_negative(2, "A -ve"),
		B_positive(3, "B +ve"),
		B_negative(4, "B -ve"),
		AB_positive(5, "AB +ve"),
		AB_negative(6, "AB -ve"),
		O_positive(7, "O +ve"),
		O_negative(8, "O -ve");
		
		
		private int id;
		private String value;
		private static final Map<Integer, BloodGroup> lookup = new HashMap<Integer, BloodGroup>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private BloodGroup(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (BloodGroup s : EnumSet.allOf(BloodGroup.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static BloodGroup get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum NameChangeReason {
		Willingly(1, "Willingly"),
		AfterMarriage(2, "After Marriage");
		
		
		private int id;
		private String value;
		private static final Map<Integer, NameChangeReason> lookup = new HashMap<Integer, NameChangeReason>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private NameChangeReason(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (NameChangeReason s : EnumSet.allOf(NameChangeReason.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static NameChangeReason get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum Category {
		GEN(1, "GEN"),
		SC(2, "SC"),
		ST(3, "GEN"),
		VJDTA(4, "VJ/DT(A)"),
		NT1NTB(5, "NT-1 (NT-B)"),
		NT2NTC(6, "NT-2 (NT-C)"),
		NT3NTD(7, "NT-3 (NT-D)"),
		OBC(8, "OBC"),
		SBC(9, "SBC"),
		ESBC(10, "ESBC");
		
		
		private int id;
		private String value;
		private static final Map<Integer, Category> lookup = new HashMap<Integer, Category>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private Category(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (Category s : EnumSet.allOf(Category.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static Category get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum SpeciallyAbled {
		VisuallyImpaired(1, "Visually Impaired"),
		SpeechandorHearingImpaired(2, "Speech and/or Hearing Impaired"),
		OrthopedicDisorderorMentallyRetarded(3, "Orthopedic Disorder or Mentally Retarded"),
		LearningDisability(4, "Learning Disability"),
		Dyslexia(5, "Dyslexia");
		
		
		private int id;
		private String value;
		private static final Map<Integer, SpeciallyAbled> lookup = new HashMap<Integer, SpeciallyAbled>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private SpeciallyAbled(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (SpeciallyAbled s : EnumSet.allOf(SpeciallyAbled.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static SpeciallyAbled get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum Occupation
	{
		Service(1, "Service"),
		Business(2, "Business"),
		Professional(3, "Professional"),
		Farmer(4, "Farmer"),
		Laborer(5, "Laborer"),
		Retired(6, "Retired");
		
		private int id;
		private String value;
		private static final Map<Integer, Occupation> lookup = new HashMap<Integer, Occupation>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private Occupation(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (Occupation s : EnumSet.allOf(Occupation.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static Occupation get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
}
