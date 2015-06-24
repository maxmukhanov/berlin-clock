package com.ubs.opsit.interviews;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringConcatTest {
    @Test
    public void shouldConcatNullToString() throws Exception {
        String origin = "abc";

        String result = origin + null;

        Assertions.assertThat(result).isEqualTo("abcnull");

    }
}
