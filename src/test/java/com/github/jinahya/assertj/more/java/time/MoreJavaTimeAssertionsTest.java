package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.AbstractMoreAssertionsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Period;

class MoreJavaTimeAssertionsTest
        extends AbstractMoreAssertionsTest<MoreJavaTimeAssertions> {

    MoreJavaTimeAssertionsTest() {
        super(MoreJavaTimeAssertions.class);
    }

    @Test
    void assertMore_DoesNotThrow_Duration() {
        Assertions.assertThatCode(() -> {
                    MoreJavaTimeAssertions.assertMore(Duration.ofDays(1L));
                })
                .doesNotThrowAnyException();
    }

    @Test
    void assertMore_DoesNotThrow_Period() {
        Assertions.assertThatCode(() -> {
                    MoreJavaTimeAssertions.assertMore(Period.ofYears(1));
                })
                .doesNotThrowAnyException();
    }
}