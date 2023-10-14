package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCompositeGradeGradeStrategy {

	@Test
	void testGradeStrategyWithSumAndNoGrades() {
		
		CompositeGrade comp = new CompositeGrade();
		
		GradeStrategy strategy = new SumStrategy();
		
		assertEquals(0.00, comp.gradeStrategy(strategy));
	}
	
	@Test
	void testGradeStrategyWithSum() {
		
		Grade grade1 = new SimpleGrade(80);
		Grade grade2 = new SimpleGrade(80);
		Grade grade3 = new SimpleGrade(80);
		
		CompositeGrade comp = new CompositeGrade();
		comp.addGrade(grade3);
		comp.addGrade(grade2);
		comp.addGrade(grade1);
		
		GradeStrategy strategy = new SumStrategy();
		
		assertEquals(240.00, comp.gradeStrategy(strategy));
	}
	
}
