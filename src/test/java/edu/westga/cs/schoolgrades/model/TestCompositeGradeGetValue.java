package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCompositeGradeGetValue {

	@Test
	void testGetValueWithNoGradeAddedToList() {
		CompositeGrade comp = new CompositeGrade();
		
		assertEquals(0.0, comp.getValue());
	}
	
	@Test
	void testGetValueWithOneGradeAddedToList() {
		Grade grade = new SimpleGrade(88.00);
		CompositeGrade comp = new CompositeGrade();
		comp.addGrade(grade);
		
		assertEquals(88.00, comp.getValue());
	}
	
	@Test
	void testGetValueWithMultipleGradesAddedToList() {
		Grade grade1 = new SimpleGrade(88.00);
		Grade grade2 = new SimpleGrade(98.00);
		Grade grade3 = new SimpleGrade(75.00);

		CompositeGrade comp = new CompositeGrade();
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);
		
		assertEquals(261.00, comp.getValue());
	}

}
