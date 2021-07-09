package cst8284.lab05.test;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra Iroakazi
 * Date: July 11, 2021 
 * Class Name: IsoscelesTriangleTest 
 * Description: This program solution the Lab5 task.
 */
import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.lab05.*;

public class IsoscelesTriangleTest {
	private static final double EPSILON = 1E-12;
	private static final double WIDTH = 1.0;
	private static IsoscelesTriangle isos;
	private static Triangle triangle;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		isos = new IsoscelesTriangle(WIDTH, WIDTH);
		triangle = new Triangle(WIDTH);

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
	public void testGetArea_Ture() {
		Triangle triangle1 = new Triangle();
		IsoscelesTriangle isos1 = new IsoscelesTriangle();
		double result1 = triangle1.getArea();
		double result2 = isos1.getArea();
		assertEquals(result1, result2, EPSILON);

	}

	@Test
	public void testGetPerimeter_Ture() {
		double result1 = triangle.getPerimeter();
		double result2 = isos.getPerimeter();
		assertEquals(result1, result2, EPSILON);

	}

}