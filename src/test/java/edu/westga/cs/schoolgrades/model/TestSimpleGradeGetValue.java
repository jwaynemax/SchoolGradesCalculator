package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGradeGetValue {

	@Test
	void testSimpleGradeGetValue() {
		Grade grade = new SimpleGrade(95.00);
		
		assertEquals(95.00, grade.getValue());
	}
	
	@Test
	void testSimpleGradeGetValue100() {
		Grade grade = new SimpleGrade(100.00);
		
		assertEquals(100.00, grade.getValue());
	}
	
	@Test
	void testSimpleGradeGetValue0() {
		Grade grade = new SimpleGrade(0.00);
		
		assertEquals(0.00, grade.getValue());
	}

}
