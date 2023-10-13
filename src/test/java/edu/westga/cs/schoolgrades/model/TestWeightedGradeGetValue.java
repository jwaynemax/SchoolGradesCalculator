package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HelperClass extends WeightedGrade {
	public HelperClass() {}

}

class TestWeightedGradeGetValue {
	HelperClass helper = new HelperClass();

	@Test
	void test() {
		
		assertEquals(0.0, helper.getValue());
	}

}
