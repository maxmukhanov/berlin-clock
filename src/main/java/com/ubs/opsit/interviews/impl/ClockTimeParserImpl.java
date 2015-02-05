package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.ClockTime;
import com.ubs.opsit.interviews.ClockTimeParser;

public class ClockTimeParserImpl implements ClockTimeParser {
    private static final String DEFAULT_DELIMITER = ":";
    private static final int TIME_ARRAY_LENGTH = 3;
    private static final int INDEX_OF_HOURS = 0;
    private static final int INDEX_OF_MINUTES = 1;
    private static final int INDEX_OF_SECONDS = 2;

    @Override
    public ClockTime parse(String time) {
        String [] values = time.split(DEFAULT_DELIMITER);

        if (values.length != TIME_ARRAY_LENGTH) {
            throw new IllegalArgumentException("Input time doesn't match to following pattern [hh:mm:ss]");
        }

        try {
            return new ClockTime(Integer.valueOf(values[INDEX_OF_HOURS]),
                    Integer.valueOf(values[INDEX_OF_MINUTES]),
                    Integer.valueOf(values[INDEX_OF_SECONDS]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hours [0-24], minutes [0-59] and seconds[0-59] should be digits");
        }
    }
}
