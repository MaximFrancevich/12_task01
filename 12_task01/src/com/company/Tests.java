package com.company;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void emptyStringTest() {
        Integer.decode("");
    }

    @Test
    public void negativeNumberTest() {
        Assert.assertEquals(Integer.decode("-1"), Integer.valueOf(-1));
    }

    @Test
    public void numberWithPlusTest() {
        Assert.assertEquals(Integer.decode("+1"), Integer.valueOf(1));
    }

    @Test
    public void hexNumberTest() {
        Assert.assertEquals(Integer.decode("0xa"), Integer.valueOf(10));
        Assert.assertEquals(Integer.decode("-0X10bA"), Integer.valueOf(-4282));
        Assert.assertEquals(Integer.decode("#7C2"), Integer.valueOf(1986));
    }

    @Test
    public void octNumberTest() {
        Assert.assertEquals(Integer.decode("0553"), Integer.valueOf(363));
    }

    @Test(expected = NumberFormatException.class)
    public void plusAfterPrefixNumberTest() {
        Integer.decode("0x+234");
    }

    @Test(expected = NumberFormatException.class)
    public void minusAfterPrefixNumberTest() {
        Integer.decode("0-357");
    }

    @Test
    public void minValueTest() {
        Assert.assertEquals(Integer.decode("-2147483648"), Integer.valueOf(0x80000000));
    }
}
