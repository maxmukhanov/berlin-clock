package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.ClockTime;
import com.ubs.opsit.interviews.ClockTimeFormatter;

public class BerlinClockTimeFormatter implements ClockTimeFormatter {
    private static final String YELLOW_COLOR = "Y";
    private static final String RED_COLOR = "R";
    private static final String OFF_COLOR = "O";

    private static final int FIVE_HOUR_LINE_NUMBER_LIGHTS = 4;
    private static final int ONE_HOUR_LINE_NUMBER_LIGHTS = 4;
    private static final int FIVE_MINUTE_LINE_NUMBER_LIGHTS = 11;
    private static final int ONE_MINUTE_LINE_NUMBER_LIGHTS = 4;
    private static final int HOURS_SCALE = 5;
    private static final int MINUTES_SCALE = 5;

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String format(ClockTime clockTime) {
        StringBuilder berlinTimeOutput = new StringBuilder();

        berlinTimeOutput.append(getSecondsLine(clockTime.getSeconds()));
        berlinTimeOutput.append(LINE_SEPARATOR);
        berlinTimeOutput.append(getFiveHoursLine(clockTime.getHours()));
        berlinTimeOutput.append(LINE_SEPARATOR);
        berlinTimeOutput.append(getOneHoursLine(clockTime.getHours()));
        berlinTimeOutput.append(LINE_SEPARATOR);
        berlinTimeOutput.append(getFiveMinutesLine(clockTime.getMinutes()));
        berlinTimeOutput.append(LINE_SEPARATOR);
        berlinTimeOutput.append(getOneMinuteLine(clockTime.getMinutes()));

        return berlinTimeOutput.toString();
    }

    protected String getSecondsLine(int seconds) {
        return seconds % 2 == 0 ? YELLOW_COLOR : OFF_COLOR;
    }

    protected String getFiveHoursLine(int hours) {
        return getOutputForLine(FIVE_HOUR_LINE_NUMBER_LIGHTS, hours / HOURS_SCALE, RED_COLOR);
    }

    protected String getOneHoursLine(int hours) {
        return getOutputForLine(ONE_HOUR_LINE_NUMBER_LIGHTS, hours % HOURS_SCALE, RED_COLOR);
    }

    protected String getFiveMinutesLine(int minutes) {
        return getOutputForLine(FIVE_MINUTE_LINE_NUMBER_LIGHTS, minutes / MINUTES_SCALE, YELLOW_COLOR).
                replace("YYY", "YYR");
    }

    protected String getOneMinuteLine(int minutes) {
        return getOutputForLine(ONE_MINUTE_LINE_NUMBER_LIGHTS, minutes % MINUTES_SCALE, YELLOW_COLOR);

    }

    private String getOutputForLine(int numberOfLights, int onLights, String onColor) {
        String output = "";
        for (int i = 0; i < onLights; i++) {
            output += onColor;
        }
        for (int i = 0; i < (numberOfLights - onLights); i++) {
            output += OFF_COLOR;
        }
        return output;
    }

}
