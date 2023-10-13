package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleGradeConstructor {

	@Test
	void testCreateSimpleGradeConstructor() {
		Grade grade = new SimpleGrade(95.00);
		assertEquals(95.00, grade.getValue());
	}
	
	@Test
	void testCreateSimpleGradeLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new SimpleGrade(-5);
	    });
	}
	
	@Test
	void testCreateSimpleGradeLessThan100() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new SimpleGrade(101);
	    });
	}

}
