package com.github.jinahya.assertj.more.java.time.temporal;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class MoreJavaTimeTemporalAssertionsTest {

    @Test
    void assertMore__() {
        final LocalDate actual = LocalDate.now();
        MoreJavaTimeTemporalAssertions.assertMore(actual)
                .isNotNull()
//                .isBefore(actual.plusYears(1L))
                .supports(ChronoUnit.YEARS);
        ;
    }
}