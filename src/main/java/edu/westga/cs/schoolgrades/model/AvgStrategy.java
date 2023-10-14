package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

public class AvgStrategy implements GradeStrategy{
	
	@Override
	public double calcGradeStrategy(ArrayList<Grade> grades) {
		double grade = 0;
		for (int i = 0; i < grades.size(); i++) {
			grade += grades.get(i).getValue();
		}
		
		return grade / grades.size();
	}
}
