package com.github.jinahya.assertj.more;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.temporal.ValueRange;

class MoreAssertions_AssertMore_ValueRange_Test {

    @Test
    void assertMore__ValueRange() {
        final var actual = Mockito.mock(ValueRange.class);
        Assertions.assertThat(MoreAssertions.assertMore(actual))
                .isNotNull();
    }
}