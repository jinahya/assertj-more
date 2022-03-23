package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractLocalDateAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ForAbstractAssertTest {

    @Test
    void getActual__() {
        final LocalDate expected = LocalDate.now();
        final AbstractLocalDateAssert<?> a = Assertions.assertThat(expected);
        final LocalDate actual = ForAbstractAssert.getActual(a);
        Assertions.assertThat(actual).isSameAs(expected);
    }
}