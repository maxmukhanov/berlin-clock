package com.ubs.opsit.interviews.support;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanNumericConverterTest {


    private RomanNumericConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new RomanNumericConverter();
    }

    @Test
    @Parameters({
            "I, 1",
            "V, 5",
            "X, 10",
            "L, 50",
            "C, 100",
            "D, 500",
            "M, 1000",
            "MDCC, 1700"


    })
    public void shouldConvertRomanNumericToDigit(String romanValue, Integer expected) throws Exception {

        Integer actual = converter.convert(romanValue);

        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void shouldAdding() throws Exception {
        Integer expected = 12;

        Integer actual = converter.convert("XII");

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldSubstrackt() throws Exception {
        Integer expected = 19;

        Integer actual = converter.convert("XIX");

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
