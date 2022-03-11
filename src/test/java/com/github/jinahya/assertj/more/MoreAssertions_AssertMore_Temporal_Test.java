package com.github.jinahya.assertj.more;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.temporal.Temporal;

class MoreAssertions_AssertMore_Temporal_Test {

    @Test
    void assertMore__Temporal() {
        final var actual = Mockito.mock(Temporal.class);
        Assertions.assertThat(MoreAssertions.assertMore(actual))
                .isNotNull();
    }
}