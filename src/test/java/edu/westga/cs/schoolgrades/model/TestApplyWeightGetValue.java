package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestApplyWeightGetValue {

	@Test
	void testGetValueWitNoWeightProvided() {
		Grade grade = new SimpleGrade(98.00);
		Grade weightedGrade = new ApplyWeight(grade, 0);
		
		assertEquals(0.0, weightedGrade.getValue());
	}
	
	@Test
	void testGetValueWithApplyWeight() {
		Grade grade = new SimpleGrade(98.00);
		Grade weightedGrade = new ApplyWeight(grade, .10);
		
		assertEquals(9.8, weightedGrade.getValue());
	}

}
