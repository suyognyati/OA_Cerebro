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
		Select(0, "-- Select Gender --"),
		Male(1, "Male"), 
		Female(2, "Female"),
		Transgender(3, "Transgender");

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
		Select(0, "-- Select Marital Status --"),
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
		Select(0, "-- Select Blood Group --"),
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
		Select(0, "-- Select Reason --"),
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
	
	public enum Occupation
	{
		Select(0, "-- Select Occupation --"),
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
	
	public enum Category {
		Select(0, "-- Select Category --"),
		GEN(1, "GEN"),
		SC(2, "SC"),
		ST(3, "ST"),
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
	
	public enum Religion
	{
		Select(0, "-- Select Religion --"),
		Hindu(1, "Hindu"),
		Muslim(2, "Muslim"),
		Christian(3, "Christian"),
		Sikh(4, "Sikh"),
		Jain(5, "Jain"),
		Parsi(6, "Parsi"),
		Buddhist(6, "Buddhist"),
		IndigenousFaith(7, "Indigenous Faith");
		
		
		private int id;
		private String value;
		private static final Map<Integer, Religion> lookup = new HashMap<Integer, Religion>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private Religion(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (Religion s : EnumSet.allOf(Religion.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static Religion get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
	
	public enum MotherTongue
	{
		Select(0, "-- Select Mother Tongue --"),
		/*Assamese(1,"Assamese"),
		Bengali(2,"Bengali"),
		Bodo(3,"Bodo"),
		Dogri(4,"Dogri"),
		English(5,"English"),
		Gujarati(6,"Gujarati"),
		Hindi(7,"Hindi"),
		Kannada(8,"Kannada"),
		Kashmiri(9,"Kashmiri"),
		Konkani(10,"Konkani"),
		Maithili(11,"Maithili"),
		Malayalee(12,"Malayalam"),
		MeiteiManipuri(13,"Meitei (Manipuri)"),
		Marathi(14,"Marathi"),
		Nepali(15,"Nepali"),
		Oriya(16,"Odia"),
		Punjabi(17,"Punjabi"),
		Sanskrit(18,"Sanskrit"),
		Santhali(19,"Santhali"),
		Sindhi(20,"Sindhi"),
		Tamil(21,"Tamil"),
		Telugu(22,"Telugu"),
		Urdu(23,"Urdu"),
		Other(24, "Other"),*/
		
		Assamese(1, "Assamese"),
		Bengali(2, "Bengali"),
		English(3, "English"),
		Gujarati(4, "Gujarati"),
		Hindi(5, "Hindi"),
		Kannada(6, "Kannada"),
		Malayalee(7, "Malayalee"),
		Marathi(8, "Marathi"),
		Marwadi(9, "Marwadi"),
		Oriya(10, "Oriya"),
		Parsi(11, "Parsi"),
		Punjabi(12, "Punjabi"),
		Sindhi(13, "Sindhi"),
		Sanskrit(14, "Sanskrit"),
		Tamil(15, "Tamil"),
		Telugu(16, "Telugu"),
		Urdu(17, "Urdu"),
		Other(18, "Other");
		
		private int id;
		private String value;
		private static final Map<Integer, MotherTongue> lookup = new HashMap<Integer, MotherTongue>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private MotherTongue(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (MotherTongue s : EnumSet.allOf(MotherTongue.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static MotherTongue get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}

	public enum SpeciallyAbled {
		Select(0, "-- Not Applicable --"),
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
	
	public enum ResultStatus {
		Passed(1, "Passed"),
		ResultAwaited(2, "Result Awaited"),
		Failed(3, "Failed");
				
		private int id;
		private String value;
		private static final Map<Integer, ResultStatus> lookup = new HashMap<Integer, ResultStatus>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private ResultStatus(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (ResultStatus s : EnumSet.allOf(ResultStatus.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static ResultStatus get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}

	public enum CertifyingBody {
		Board(1, "Board"),
		University(2, "University"),
		Other(3, "Other");
				
		private int id;
		private String value;
		private static final Map<Integer, CertifyingBody> lookup = new HashMap<Integer, CertifyingBody>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private CertifyingBody(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (CertifyingBody s : EnumSet.allOf(CertifyingBody.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static CertifyingBody get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}

	public enum Month {
		January(1, "January"),
		February(2, "February"),
		March(3, "March"),
		April(4, "April"),
		May(5, "May"),
		June(6, "June"),
		July(7, "July"),
		August(8, "August"),
		September(9, "September"),
		October(10, "October"),
		November(11, "November"),
		December(12, "December");
				
		private int id;
		private String value;
		private static final Map<Integer, Month> lookup = new HashMap<Integer, Month>();
		private static final List<KeyValuePair> enumList = new ArrayList<KeyValuePair>();
		
		private Month(int id, String value) { this.id = id; this.value = value; }
		
		static {
			for (Month s : EnumSet.allOf(Month.class)) {
				lookup.put(s.getId(), s);
				KeyValuePair ms = new KeyValuePair();
				ms.key = s.getId();
				ms.value = s.getValue();
				enumList.add(ms);
			}
		}

		public int getId() { return id; }
		public String getValue() { return value; }
		public static Month get(int id) { return lookup.get(id); }
		public static List<KeyValuePair> getEnumList() { return enumList; }
	}
}
