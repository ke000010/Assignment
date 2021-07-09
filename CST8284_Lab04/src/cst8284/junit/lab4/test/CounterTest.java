package cst8284.junit.lab4.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.junit.lab4.Counter;
/**
 *Class Name: CST8284_21S
 *Author Name: Jie Ke
 *Professor Name: Samira Ouaaz
 *Class Name: CounterTest
 *Date: June 16, 2021 
 *Description: This program solution the 
 *lab4 task. 
 */

public class CounterTest {

	private static final int COUNT1 = 50;
	private static final int COUNT2 = 1;
	private static Counter counter;

	private static Counter counterM;
	private static Counter firstCounter;
	private static Counter secondCounter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		counterM = new Counter(Integer.MAX_VALUE-1);
		secondCounter = new Counter(COUNT2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	firstCounter = new Counter(COUNT1);	
	counter = new Counter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCounter() {

		assertTrue(counter.getCount()== 0); 
	}

	@Test
	public void testCounterInt() {

		assertTrue(firstCounter.getCount()== COUNT1); 

	}

	@Test
	public void testIncrement() {
		int result = firstCounter.increment();//50+1
		assertEquals(result,COUNT1+1);//51
		
		int result1 = (new Counter(Integer.MAX_VALUE)).increment();
		assertEquals(result1,0);
		
	}



	@Test
	public void testDecrement() {
		
		int result = firstCounter.decrement();//50-1
		assertEquals(result,(COUNT1-1));

		int result1 = counter.decrement();//0-1
		assertEquals(result1,0);
		

	}

	@Test
	public void testGetCount() {
		int result = firstCounter.getCount();//50
		assertEquals(COUNT1, result);

	}

	@Test
	public void testAdd() {
		int result = counter.add(firstCounter).getCount();
		int i = counter.getCount() + COUNT1;//0+50
		assertEquals(i,result);

		int result1 = secondCounter.add(counterM).getCount();//1+(integer.maxvalue-1)
		assertEquals(0,result1);

	}

	@Test
	public void testSub() {

		int result = firstCounter.sub(secondCounter).getCount();//50-1
		int i = COUNT1 - COUNT2;//50-1
		assertEquals(i,result);
		
		int result1 = counter.sub(firstCounter).getCount();//0-50
		assertEquals(0,result1);

	}

	@Test
	public void testToString() {
		String result = "Count is " + counter.getCount();
		assertTrue(result.equals(counter.toString()));

	}

}
