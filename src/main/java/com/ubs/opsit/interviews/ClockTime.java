package com.ubs.opsit.interviews;

public class ClockTime {
    private int hours;
    private int minutes;
    private int seconds;

    public ClockTime(int hours, int minutes, int seconds) {
        if (hours > 24 || hours < 0) {
            throw new IllegalArgumentException("Hours should be in range from 0 to 24");
        }

        if (minutes >= 60 || minutes < 0) {
            throw new IllegalArgumentException("Minutes should be in range from 0 to 59");
        }

        if (seconds >= 60 || seconds < 0) {
            throw new IllegalArgumentException("Second should be in range from 0 to 59");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return "Hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().isInstance(this)) {
            return false;
        }

        ClockTime other = (ClockTime) obj;

        return this.hours == other.getHours() &&
                this.minutes == other.getMinutes() &&
                this.seconds == other.getSeconds();
    }

    @Override
    public int hashCode() {
        int result = hours;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        return result;
    }
}
