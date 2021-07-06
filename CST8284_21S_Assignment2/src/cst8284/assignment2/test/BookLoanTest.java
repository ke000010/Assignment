package cst8284.assignment2.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cst8284.assignment2.*;

public class BookLoanTest {
	private String DEFAULT_ISBN = "1234567890";
	private String DEFAULT_TITLE = "Harry Potter";
	private String DEFAULT_AUTHOR = "J K Rowing";
	private String DEFAULT_YEAR = "2000";
	
	private String DEFAULT_FIRST = "Raja";
	private String DEFAULT_LAST = "Singh";
	private String DEFAULT_ADRESS = "45 Wood Dr";
	private int DEFAULT_AGE = 20;

 	private String DEFAULT_DUE = "2021-05-29";
	private Book book1;
	private Book book2;
	private User user1;
	private User user2;
	BookLoan loan;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user1 = new User(DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_ADRESS, DEFAULT_AGE);
		book1 = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_YEAR, DEFAULT_ISBN);
		loan = new BookLoan(user1, book1, DEFAULT_DUE);
		book2 = new Book();
		user2 = new User();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBookLoan_True() {

		assertTrue(book1.equals(loan.getBook())
				&&user1.equals(loan.getUser()));
		
	}
	@Test
	public void testBookLoan_False() {

		assertFalse(book2.equals(loan.getBook())
				||user2.equals(loan.getUser()));
	
	}

}