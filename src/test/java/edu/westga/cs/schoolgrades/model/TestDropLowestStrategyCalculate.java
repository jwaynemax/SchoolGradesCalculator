package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	private List<Grade> gradesMinusLowest;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(SimpleGrade.class);
		mockGrade1 = mock(SimpleGrade.class);
		mockGrade2 = mock(SimpleGrade.class);
		
		when(mockGrade0.getValue()).thenReturn(10.00);
		when(mockGrade1.getValue()).thenReturn(20.00);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		grades = new ArrayList<Grade>();
		gradesMinusLowest = new ArrayList<Grade>();
		
		childStrategy = mock(SumOfGradesStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(mockGrade0);
		
		dropLowestStrategy.calculate(grades);
		
        verify(childStrategy).calculate(gradesMinusLowest);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		
		dropLowestStrategy.calculate(grades);

		gradesMinusLowest.add(mockGrade1);
		gradesMinusLowest.add(mockGrade2);
		
        verify(childStrategy).calculate(gradesMinusLowest);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		
		dropLowestStrategy.calculate(grades);

		gradesMinusLowest.add(mockGrade1);
		gradesMinusLowest.add(mockGrade2);
		
        verify(childStrategy).calculate(gradesMinusLowest);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
				
		dropLowestStrategy.calculate(grades);
		
		gradesMinusLowest.add(mockGrade1);
		gradesMinusLowest.add(mockGrade2);

        verify(childStrategy).calculate(gradesMinusLowest);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		
		dropLowestStrategy.calculate(grades);
		
		gradesMinusLowest.add(mockGrade1);
		gradesMinusLowest.add(mockGrade2);
		gradesMinusLowest.add(mockGrade0);
		
        verify(childStrategy).calculate(gradesMinusLowest);
	}
}
