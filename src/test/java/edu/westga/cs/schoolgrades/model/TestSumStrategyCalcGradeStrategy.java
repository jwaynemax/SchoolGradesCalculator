package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSumStrategyCalcGradeStrategy {

	@Test
	void testStrategyWithSmallGradesList() {
		Grade grade1 = new SimpleGrade(10.00);
		Grade grade2 = new SimpleGrade(20.00);
		Grade grade3 = new SimpleGrade(30.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		GradeStrategy strategy = new SumStrategy();
		
		assertEquals(60.00, comp.gradeStrategy(strategy));

	}

}
