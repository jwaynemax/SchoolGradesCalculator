package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestApplyWeightConstructor {

	@Test
	void testApplyWeightWith1() {
		Grade grade = new SimpleGrade(10.00);
		Grade weightedGrade = new ApplyWeight(grade, 1);
		
		assertEquals(10.00, weightedGrade.getValue());
	}
	
	@Test
	void testApplyWeightWith10() {
		Grade grade = new SimpleGrade(98.00);
		Grade weightedGrade = new ApplyWeight(grade, .10);
		
		assertEquals(9.8, weightedGrade.getValue());
	}
	
	@Test
	void testApplyWeightWithToCompositeGrade() {
		Grade grade1 = new SimpleGrade(90.00);
		Grade grade2 = new SimpleGrade(70.00);
		Grade grade3 = new SimpleGrade(60.00);
		
		CompositeGrade comp = new CompositeGrade();
		comp.addGrade(grade1);
		comp.addGrade(grade2);
		comp.addGrade(grade3);

		Grade weightedGrade = new ApplyWeight(comp, .10);
		
		assertEquals(22.00, weightedGrade.getValue());
	}

}
