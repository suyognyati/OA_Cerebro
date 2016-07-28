package com.data.entities;

public class Enums {
	
	public static GenderType GenderType;
	
	
	public enum GenderType {
		Male(1),
		Female(2);
		
		private final int id;
		GenderType(int id) { this.id = id; }
	    public int getValue() { return id; }
	}
}
