package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAvgStrategyCalcGradeStrategy {

	@Test
	void testAvgStrategyWithGradesList() {
		Grade grade1 = new SimpleGrade(10.00);
		Grade grade2 = new SimpleGrade(20.00);
		Grade grade3 = new SimpleGrade(30.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		GradeCalculationStrategy strategy = new AverageOfGradesStrategy();
		
		assertEquals(20.00, comp.gradeStrategy(strategy));

	}
	
	@Test
	void testStrategyWithOneGrade() {
		Grade grade1 = new SimpleGrade(10.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		
		GradeCalculationStrategy strategy = new AverageOfGradesStrategy();
		
		assertEquals(10.00, comp.gradeStrategy(strategy));

	}

}
