package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

public class DropLowestGrade extends GradeStrategyDecorator {	
	
	private GradeStrategy gradeStrategy;
	
	public DropLowestGrade(GradeStrategy strategy) {
		this.gradeStrategy = strategy;
	}

	@Override
	public double calcGradeStrategy(ArrayList<Grade> grades) {
		Grade lowest = grades.get(0);
		int index = 0;
		
		for(int i = 0; i <= grades.size()-1; i++) {
			if (grades.get(i).getValue() < lowest.getValue()) {
				lowest = grades.get(i);
				index = i;
			}
		}
		
		grades.remove(index);
		
		return this.gradeStrategy.calcGradeStrategy(grades);
	}
	
	

}
