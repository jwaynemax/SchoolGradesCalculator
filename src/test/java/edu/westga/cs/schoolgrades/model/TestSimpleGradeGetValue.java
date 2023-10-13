package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGradeGetValue {

	@Test
	void testSimpleGradeGetValue() {
		Grade grade = new SimpleGrade(95.00);
		
		assertEquals(95.00, grade.getValue());
	}

}
