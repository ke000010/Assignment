package cst8284.lab05.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.lab05.*;

public class CircleTest {
	
	private static final double WIDTH1 = 1.0;
	private static final double WIDTH2 = 2.0;
	private static Circle circle;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	circle = new Circle(WIDTH1);

	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetArea_True() {
		double result = circle.getArea();
		double area = Math.PI*WIDTH1*WIDTH1/4;
		assertTrue(Double.compare(result, area) == 0);
		
	}
	@Test
	public void testGetArea_False() {
		double result = circle.getArea();
		double area = Math.PI*WIDTH2*WIDTH2/4;
		assertFalse(Double.compare(result, area) == 0);
	}
	@Test
	public void testGetPerimeter_Ture() {
		double result = circle.getPerimeter();
		double perimeter = Math.PI*WIDTH1;
		assertTrue(Double.compare(result, perimeter) == 0);

	}
	@Test
	public void testGetPerimeter_False() {
		double result = circle.getPerimeter();
		double perimeter = Math.PI*WIDTH2;
		assertFalse(Double.compare(result, perimeter) == 0);
	}
}