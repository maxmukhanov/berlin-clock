package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.ClockTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClockTimeParserImplTest {
    private ClockTimeParserImpl sut;

    @Before
    public void setUp() throws Exception {
        sut = new ClockTimeParserImpl();
    }

    @Test
    public void shouldParseStringToClockTime() throws Exception {
        ClockTime expectedClockTime = new ClockTime(17, 23, 1);
        ClockTime actual = sut.parse("17:23:01");

        Assert.assertEquals(expectedClockTime, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfDoesNotMatchTimePattern() throws Exception {
        sut.parse("wrong_pattern");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfTimeAreNotDigits() throws Exception {
        sut.parse("ab:11:cd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfHoursIsNotInRange() throws Exception {
        sut.parse("25:17:20");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfMinutesIsNotInRange() throws Exception {
        sut.parse("13:60:01");

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfSecondIsNotInRange() throws Exception {
        sut.parse("13:23:77");

    }
}
