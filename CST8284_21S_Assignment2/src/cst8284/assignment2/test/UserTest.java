package cst8284.assignment2.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.assignment2.*;

public class UserTest {
	private String DEFAULT_FIRST = "Raja";
	private String DEFAULT_LAST = "Singh";
	private String DEFAULT_ADRESS = "45 Wood Dr";
	private int DEFAULT_AGE = 20;
	
	private String OTHER_FIRST = "Jeff";
	private String OTHER_LAST = "Smith";
	User theUser;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		theUser = new User(DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADRESS, DEFAULT_AGE);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser_True() {
		String first = theUser.getFirstName();
		String last = theUser.getLastName();
		assertTrue(first.equals(DEFAULT_FIRST)&&last.equals(DEFAULT_LAST));
		
	}
	@Test
	public void testUser_False() {
		String first = theUser.getFirstName();
		String last = theUser.getLastName();
		assertFalse(first.equals(OTHER_FIRST)||last.equals(OTHER_LAST));
	
	}

}