package com.example.efarmoghgiaodontiatrous.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * The type System date stub test.
 */
public class SystemDateStubTest {
    /**
     * The Year stub.
     */
    int YEAR_STUB = 1971;
    /**
     * The Month stub.
     */
    int MONTH_STUB = 11;
    /**
     * The Date stub.
     */
    int DATE_STUB = 30;

    /**
     * The Stub.
     */
    SimpleCalendar stub;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        SystemDateStub.reset();
        stub = new SimpleCalendar(YEAR_STUB, MONTH_STUB, DATE_STUB);
    }

    /**
     * Reset.
     */
    @After
    public void reset() {
        SystemDateStub.reset();
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        SystemDate testPurposesOnly = new SystemDate();
    }

    /**
     * Test without stub.
     */
    @Test
    public void testWithoutStub() {
        SimpleCalendar realNow = new SimpleCalendar(Calendar.getInstance());
        Assert.assertEquals(SystemDate.now(), realNow);
    }

    /**
     * Test with stub.
     */
    @Test
    public void testWithStub() {
        SystemDateStub.setStub(stub);
        Assert.assertEquals(stub, SystemDate.now());
    }

    /**
     * Switch stub usage.
     */
    @Test
    public void switchStubUsage() {
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());
        SystemDateStub.setStub(stub);
        Assert.assertEquals(stub, SystemDate.now());
        SystemDateStub.reset();
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());
    }
}