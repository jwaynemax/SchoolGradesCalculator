package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGradeStrategyDecoratorDropLowestGrade {

	@Test
	void tesDropLowestGradeWithSumStrategyt() {
		Grade grade1 = new SimpleGrade(30.00);
		Grade grade2 = new SimpleGrade(50.00);
		Grade grade3 = new SimpleGrade(50.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		GradeStrategy strategy = new SumStrategy();
		strategy = new DropLowestGrade(strategy);
		

		assertEquals(100.00, comp.gradeStrategy(strategy));

	}
	
	@Test
	void tesDropLowestGradeWithAvgStrategy() {
		Grade grade1 = new SimpleGrade(10.00);
		Grade grade2 = new SimpleGrade(30.00);
		Grade grade3 = new SimpleGrade(50.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		GradeStrategy strategy = new AvgStrategy();
		strategy = new DropLowestGrade(strategy);
		

		assertEquals(40.00, comp.gradeStrategy(strategy));

	}
	
	@Test
	void tesDropLowestGradeWithDuplicateLowGrade() {
		Grade grade1 = new SimpleGrade(30.00);
		Grade grade2 = new SimpleGrade(30.00);
		Grade grade3 = new SimpleGrade(50.00);
		
		CompositeGrade comp = new CompositeGrade();
		
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		GradeStrategy strategy = new AvgStrategy();
		strategy = new DropLowestGrade(strategy);
		

		assertEquals(40.00, comp.gradeStrategy(strategy));

	}
}
