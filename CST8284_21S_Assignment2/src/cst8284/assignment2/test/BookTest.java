package cst8284.assignment2.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.assignment2.*;

public class BookTest {
	private String DEFAULT_ISBN = "1234567890";
	private String DEFAULT_TITLE = "Harry Potter";
	private String DEFAULT_AUTHOR = "J K Rowing";
	private String DEFAULT_YEAR = "2000";
	
	private String OTHER_ISBN = "9876543210";
	Book myOnlyBook;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myOnlyBook = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_YEAR, DEFAULT_ISBN);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBook_True() {
		String isbn = myOnlyBook.getIsbnNumber();
		assertTrue(isbn.equals(DEFAULT_ISBN));
		
	}
	@Test
	public void testBook_False() {
		String isbn = myOnlyBook.getIsbnNumber();
		assertFalse(isbn.equals(OTHER_ISBN));
	}

}
