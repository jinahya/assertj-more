package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractLocalDateTimeAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ForAssertTest {

    @Test
    void invokeIsNotNull__() {
        final AbstractLocalDateTimeAssert<?> self
                = ForAssert.assertActualIsNotNull(Assertions.assertThat(LocalDateTime.now()));
        Assertions.assertThat(self).isNotNull();
    }
}