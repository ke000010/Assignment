package cst8284.lab05.test;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.lab05.*;

public class TriangleTest {
	
	private static final double WIDTH1 = 1.0;
	private static final double WIDTH2 = 2.0;
	private static Triangle triangle;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	triangle = new Triangle(WIDTH1);

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
		double result = triangle.getArea();
		double area = (Math.sqrt(3)/4)*WIDTH1*WIDTH1;
		assertTrue(Double.compare(result, area) == 0);
		
	}
	@Test
	public void testGetArea_False() {
		double result = triangle.getArea();
		double area = (Math.sqrt(3)/4)*WIDTH2*WIDTH2;
		assertFalse(Double.compare(result, area) == 0);
	}
	@Test
	public void testGetPerimeter_Ture() {
		double result = triangle.getPerimeter();
		double perimeter = 3*WIDTH1;
		assertTrue(Double.compare(result, perimeter) == 0);

	}
	@Test
	public void testGetPerimeter_False() {
		double result = triangle.getPerimeter();
		double perimeter = 3*WIDTH2;
		assertFalse(Double.compare(result, perimeter) == 0);
	}
}
