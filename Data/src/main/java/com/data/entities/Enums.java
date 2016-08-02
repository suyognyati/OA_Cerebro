package com.data.entities;

public class Enums {
	
	public static GenderType[] GenderTypes = GenderType.values();
	public static MaritalStatusType[] MaritalStatusTypes = MaritalStatusType.values();
	public static FirstAttemptType[] FirstAttemptTypes = FirstAttemptType.values();
	public static MathsTypeType[] MathsTypeTypes = MathsTypeType.values();
	
	
	public enum GenderType {
		Male(1),
		Female(2);
		
		private final int id;
		GenderType(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
	
	public enum MaritalStatusType {
		Married(1),
		Unmarried(2);
		
		private final int id;
		private MaritalStatusType(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
	
	public enum FirstAttemptType {
		Yes(1),
		No(2);
		
		private final int id;
		FirstAttemptType(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
	
	public enum MathsTypeType {
		Regular(1),
		Easy(2);
		
		private final int id;
		private MathsTypeType(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
}
