package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractLocalDateTimeAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ForAssertTest {

    @Test
    void invokeIsNotNull__() {
        final AbstractLocalDateTimeAssert<?> self = ForAssert.invokeIsNotNull(assertThat(LocalDateTime.now()));
        assertThat(self).isNotNull();
    }
}