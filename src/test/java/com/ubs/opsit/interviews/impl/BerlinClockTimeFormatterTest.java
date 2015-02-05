package com.ubs.opsit.interviews.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTimeFormatterTest {
    private BerlinClockTimeFormatter sut;

    @Before
    public void setUp() throws Exception {
        sut = new BerlinClockTimeFormatter();

    }

    @Test
    public void shouldSecondsBeTurnedOn() throws Exception {
        String actual = sut.getSecondsLine(54);
        Assert.assertEquals("Y", actual);
    }

    @Test
    public void shouldSecondsBeTurnedOff() throws Exception {
        String actual = sut.getSecondsLine(1);

        Assert.assertEquals("O", actual);
    }

    @Test
    public void shouldGetFiveMinutesLine() throws Exception {
        String expected = "YYRYYRYYRYO";

        String actual = sut.getFiveMinutesLine(50);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetOneHourLine() throws Exception {
        String expected = "ROOO";

        String actual = sut.getOneHoursLine(16);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFiveHoursLine() throws Exception {
        String expected = "RRRO";

        String actual = sut.getFiveHoursLine(16);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetOneMinuteLine() throws Exception {
        String expected = "YYOO";

        String actual = sut.getOneMinuteLine(17);

        Assert.assertEquals(expected, actual);
    }
}
