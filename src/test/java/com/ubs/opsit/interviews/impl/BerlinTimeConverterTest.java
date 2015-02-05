package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.ClockTime;
import com.ubs.opsit.interviews.ClockTimeFormatter;
import com.ubs.opsit.interviews.ClockTimeParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class BerlinTimeConverterTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private BerlinTimeConverter sut;

    private ClockTimeParser clockTimeParserMock;
    private ClockTimeFormatter clockTimeFormatterMock;

    @Before
    public void setUp() {
        clockTimeParserMock = Mockito.mock(ClockTimeParser.class);
        clockTimeFormatterMock = Mockito.mock(ClockTimeFormatter.class);
        sut = new BerlinTimeConverter(clockTimeParserMock, clockTimeFormatterMock);

        Mockito.reset(clockTimeParserMock, clockTimeFormatterMock);
    }

    @After
    public void tearDown() throws Exception {
        InOrder inOrder = Mockito.inOrder(clockTimeParserMock, clockTimeFormatterMock);

        inOrder.verify(clockTimeParserMock).parse(Mockito.anyString());
        inOrder.verify(clockTimeFormatterMock).format(Mockito.any(ClockTime.class));
    }

    @Test
    public void shouldConvertStandardTimeToBerlinTime() {
        String timeToConvert = "16:50:00";
        ClockTime clockTime = new ClockTime(16, 50, 0);
        String expectedTime = createBerlinClockOutput("Y", "RRRO", "ROOO", "YYRYYRYYRYO", "OOOO");

        Mockito.when(clockTimeParserMock.parse(timeToConvert)).thenReturn(clockTime);
        Mockito.when(clockTimeFormatterMock.format(clockTime)).thenReturn(expectedTime);

        String actualTime = sut.convertTime(timeToConvert);

        Assert.assertEquals(expectedTime, actualTime);
    }


    private static String createBerlinClockOutput(String firstLine, String secondLine, String thirdLine,
                                                  String fourthLine, String fifthLine) {
        StringBuilder berlinClockTime = new StringBuilder().
                append(firstLine).append(LINE_SEPARATOR).
                append(secondLine).append(LINE_SEPARATOR).
                append(thirdLine).append(LINE_SEPARATOR).
                append(fourthLine).append(LINE_SEPARATOR).
                append(fifthLine);

        return berlinClockTime.toString();
    }

}
