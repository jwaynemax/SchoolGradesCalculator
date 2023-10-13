package edu.westga.cs.schoolgrades.model;

public class SimpleGrade implements Grade {
	
	private double grade;

	public SimpleGrade(double grade) {
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("Grade must be between 0 and 100");
		}
		
		this.grade= grade;
	}
	
	@Override
	public double getValue() {
		return grade;
	}

}
