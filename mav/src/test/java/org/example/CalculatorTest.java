package org.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    int a, b;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before ");
        a = 2;
        b = 0;
        //super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After ");
    }

    @Test
    public void sum()
    {
        Calculator calculator = new Calculator();
        System.out.println("Test add");
        int res = 2;
        Assert.assertEquals("2 + 0 = 2 - check...", res, calculator.sum(a, b));
    }

    @Test
    public void testDiv() {
        Calculator calculator = new Calculator();
        System.out.println("Test div");
        double res = 1;
        Assert.assertEquals("2 / 2.", res, calculator.div(a, b), 0.001);
    }
}