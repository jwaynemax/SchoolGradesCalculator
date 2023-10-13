package edu.westga.cs.schoolgrades.model;

public abstract class WeightedGrade implements Grade {
	
	private double value;
	
	@Override
	public double getValue() {
		return value;
	}
}
