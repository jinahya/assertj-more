package com.github.jinahya.assertj.more;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.temporal.TemporalAccessor;

class MoreAssertions_AssertMore_TemporalAccessor_Test {

    @Test
    void assertMore__TemporalAccessor() {
        final var actual = Mockito.mock(TemporalAccessor.class);
        Assertions.assertThat(MoreAssertions.assertMore(actual))
                .isNotNull();
    }
}