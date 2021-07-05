package cst8284.lab05.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.lab05.*;

public class SquareTest {
	
	private static final double WIDTH1 = 1.0;
	private static final double WIDTH2 = 2.0;
	private static Square square;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	square = new Square(WIDTH1);

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
		double result = square.getArea();
		double area = WIDTH1*WIDTH1;
		assertTrue(Double.compare(result, area) == 0);
		
	}
	@Test
	public void testGetArea_False() {
		double result = square.getArea();
		double area = WIDTH2*WIDTH2;
		assertFalse(Double.compare(result, area) == 0);
	}
	@Test
	public void testGetPerimeter_Ture() {
		double result = square.getPerimeter();
		double perimeter = 4*WIDTH1;
		assertTrue(Double.compare(result, perimeter) == 0);

	}
	@Test
	public void testGetPerimeter_False() {
		double result = square.getPerimeter();
		double perimeter = 4*WIDTH2;
		assertFalse(Double.compare(result, perimeter) == 0);
	}
}