package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractLocalDateAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ForAbstractAssertTest {

    @Test
    void getActual__() {
        final LocalDate expected = LocalDate.now();
        final AbstractLocalDateAssert<?> a = assertThat(expected);
        final LocalDate actual = ForAbstractAssert.getActual(a);
        assertThat(actual).isSameAs(expected);
    }
}