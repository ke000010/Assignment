package cst8284.junit.lab4.test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cst8284.junit.lab4.Currency;
import cst8284.junit.lab4.Money;
/**
 *Class Name: CST8284_21S
 *Author Name: Jie Ke
 *Professor Name: Samira Ouaaz
 *Class Name: CounterTest
 *Date: June 16, 2021 
 *Description: This program solution the 
 *lab4 task. 
 */


public class MoneyTest {

    private static final BigDecimal PRICE = new BigDecimal("47");
    private Currency currency;
    private Money money;
    private Currency differentCurrency;
	private static final BigDecimal DIFFERENT_PRICE = new BigDecimal("1337");

    @Before
    public void initMoney() throws Exception {
        currency = new Currency("USD");
        differentCurrency = new Currency("CAD");
        money = new Money(PRICE, currency);
    }

    @Test
    public void testGetPrice_True() {
    	BigDecimal result = money.getPrice();
    	assertTrue(PRICE.equals(result));

    }
    
    @Test
    public void testGetPrice_False() {
    	BigDecimal result = money.getPrice();
    	assertFalse(DIFFERENT_PRICE.equals(result));

    }

    @Test
    public void testGetCurrency_True() {
    	Currency result = money.getCurrency();
    	assertTrue(currency.equals(result));

    }

    @Test
    public void testGetCurrency_False() {
       	Currency result = money.getCurrency();
    	assertFalse(differentCurrency.equals(result));

    }
    
    @Test
    public void testEquals_WhenEquals() {
        Money secondMoney = new Money(PRICE, currency);

        assertTrue(money.equals(secondMoney));
    }

    @Test
    public void testEquals_WhenNotEquals() {
    	// Create another money object 
    	// Verify that the hash code for money is different
    	// from the hash code of this new object
        Money secondMoney = new Money(DIFFERENT_PRICE, currency);

        assertFalse(money.equals(secondMoney));

    }

    @Test
    public void testHashCode_Equal() {
    	// Create a money object  with a different currency
    	// Verify that the hash code for money is different
    	// from the hash code of this new object
    	Money secondMoney = new Money(PRICE, currency);
    	assertTrue(money.hashCode() == secondMoney.hashCode());

    }
    
    @Test
    public void testHashCode_NotEqual() {
    	Money secondMoney = new Money(DIFFERENT_PRICE, currency);
    	assertFalse(money.hashCode() == secondMoney.hashCode());

    }
}
