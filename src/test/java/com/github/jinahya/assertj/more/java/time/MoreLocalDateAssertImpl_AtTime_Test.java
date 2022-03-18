package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

class MoreLocalDateAssertImpl_AtTime_Test
        extends MoreLocalDateAssertImplTest {

    @Test
    void extractingAtTime__LocalTime() {
        final LocalDate actual = LocalDate.now();
        final LocalTime localTime = LocalTime.now();
        final MoreLocalDateAssertImpl assertInstance = assertInstance(actual);
        Assertions.assertThatCode(() -> assertInstance.extractingAtTime(localTime))
                .doesNotThrowAnyException();
        Assertions.assertThat(assertInstance.extractingAtTime(localTime))
                .isInstanceOf(AbstractMoreLocalDateTimeAssert.class);
    }
}