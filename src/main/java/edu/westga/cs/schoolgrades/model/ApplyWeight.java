package edu.westga.cs.schoolgrades.model;

public class ApplyWeight extends WeightedGrade {
	
	Grade grade;
	double weight;

	public ApplyWeight(Grade grade, double weight) {
		this.grade = grade;
		this.weight = weight;
	}
	
	@Override
	public double getValue() {
		return grade.getValue() * weight;
	}
}