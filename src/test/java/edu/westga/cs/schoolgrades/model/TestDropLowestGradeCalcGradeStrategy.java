package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestDropLowestGradeCalcGradeStrategy {

	@Test
	void testSumStrategyCalled() {
		Grade grade1 = new SimpleGrade(20.00);
		Grade grade2 = new SimpleGrade(30.00);
		Grade grade3 = new SimpleGrade(50.00);
		
		ArrayList comp = new ArrayList<Grade>();
		
		comp.add(grade1);
		comp.add(grade2);
		comp.add(grade3);
		
		GradeStrategy strategy = new SumStrategy();
		GradeStrategyDecorator decoration = new DropLowestGrade(strategy);

		assertEquals(80.00, decoration.calcGradeStrategy(comp));

	}

	@Test
	void testAvgStrategyCalled() {
		Grade grade1 = new SimpleGrade(50.00);
		Grade grade2 = new SimpleGrade(30.00);
		Grade grade3 = new SimpleGrade(30.00);
		
		ArrayList comp = new ArrayList<Grade>();
		
		comp.add(grade1);
		comp.add(grade2);
		comp.add(grade3);
		
		GradeStrategy strategy = new AvgStrategy();
		GradeStrategyDecorator decoration = new DropLowestGrade(strategy);

		assertEquals(40.00, decoration.calcGradeStrategy(comp));

	}
	
	@Test
	void testSumStrategyCalledWithDuplicateLowGrade() {
		Grade grade1 = new SimpleGrade(30.00);
		Grade grade2 = new SimpleGrade(30.00);
		Grade grade3 = new SimpleGrade(50.00);
		
		ArrayList comp = new ArrayList<Grade>();
		
		comp.add(grade1);
		comp.add(grade2);
		comp.add(grade3);
		
		GradeStrategy strategy = new SumStrategy();
		GradeStrategyDecorator decoration = new DropLowestGrade(strategy);

		assertEquals(80.00, decoration.calcGradeStrategy(comp));

	}
}
