package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

public class CompositeGrade implements Grade {
	
	private ArrayList<Grade> grades;
	
	public CompositeGrade() {
		grades = new ArrayList<Grade>();
	}

	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	@Override
	public double getValue() {
		double value = 0;
		for (int i = 0; i < grades.size(); i++) {
			value += grades.get(i).getValue();
		}
		
		return value;
	}
}