package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCompositeGradeAddGrade {

	@Test
	void testAddGradeToGradesList() {
		Grade grade = new SimpleGrade(10.00);
		CompositeGrade compositeGrade = new CompositeGrade();
		compositeGrade.addGrade(grade);
		
		assertEquals(10.00, compositeGrade.getValue());
	}
	
	@Test
	void testAddMultipleGradesToGradesList() {
		Grade grade1 = new SimpleGrade(10.00);
		Grade grade2 = new SimpleGrade(90.00);
		Grade grade3 = new SimpleGrade(88.00);

		CompositeGrade compositeGrade = new CompositeGrade();
		compositeGrade.addGrade(grade1);
		compositeGrade.addGrade(grade2);
		compositeGrade.addGrade(grade3);
		
		assertEquals(188.00, compositeGrade.getValue());
	}

}
