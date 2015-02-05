package com.ubs.opsit.interviews.impl;


import com.ubs.opsit.interviews.ClockTime;
import com.ubs.opsit.interviews.ClockTimeFormatter;
import com.ubs.opsit.interviews.ClockTimeParser;
import com.ubs.opsit.interviews.TimeConverter;

public class BerlinTimeConverter implements TimeConverter {
    private ClockTimeParser clockTimeParser;
    private ClockTimeFormatter formatter;

    public BerlinTimeConverter(ClockTimeParser clockTimeParser, ClockTimeFormatter formatter) {
        this.clockTimeParser = clockTimeParser;
        this.formatter = formatter;
    }

    @Override
    public String convertTime(String aTime) {
        ClockTime clockTime = clockTimeParser.parse(aTime);
        String formattedTime = formatter.format(clockTime);

        return formattedTime;
    }
}
