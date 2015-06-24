package com.ubs.opsit.interviews.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanNumericConverter {
    private static final Map<Character, Integer> MAPPING = new HashMap<>();

    static {
        MAPPING.put('I', 1);
        MAPPING.put('V', 5);
        MAPPING.put('X', 10);
        MAPPING.put('L', 50);
        MAPPING.put('C', 100);
        MAPPING.put('D', 500);
        MAPPING.put('M', 1000);
    }

    public Integer convert(String romanValue) {

        char[] symbols = romanValue.toCharArray();
        int[] digitalValues = new int[symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            char symbol = symbols[i];
            Integer value = MAPPING.get(symbol);

            if (value == null) {
                throw new IllegalArgumentException("Symbol " + symbol + " isn't allowed");
            }
            digitalValues[i] = value;
        }


        boolean substrackt = false;
        int previous = digitalValues[digitalValues.length - 1];
        int result = previous;

        for (int i = digitalValues.length - 2; i >= 0; i--) {
            int current = digitalValues[i];

            if (current > previous) {
                result += current;
                substrackt = false;
            } else if (current < previous) {
                result -= current;
                substrackt = true;
            } else {
                if (substrackt) {
                    result -= current;
                } else {
                    result += current;
                }
            }

            previous = current;
        }

        return result;
    }
}
