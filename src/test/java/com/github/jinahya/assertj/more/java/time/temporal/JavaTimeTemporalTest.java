package com.github.jinahya.assertj.more.java.time.temporal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.temporal.Temporal;

@Slf4j
class JavaTimeTemporalTest {

    @MethodSource({"com.github.jinahya.assertj.more.java.time.temporal.MoreJavaTimeTemporalTests#temporalStream"})
    @ParameterizedTest
    void print__(final Temporal temporal) {
        System.out.printf("%1$16s: %2$s%n", temporal.getClass().getSimpleName(), temporal);
    }
}
