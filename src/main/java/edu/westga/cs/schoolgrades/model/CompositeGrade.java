package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

public class CompositeGrade implements Grade {
	
	private ArrayList<Grade> grades;
	private double grade;
	
	public CompositeGrade() {
		grades = new ArrayList<Grade>();
	}

	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	public double gradeStrategy(GradeStrategy strategy){
		return grade;
	}
	
	@Override
	public double getValue() {
		grade = 0;
		for (int i = 0; i < grades.size(); i++) {
			grade += grades.get(i).getValue();
		}
		
		return grade;
	}
}
