package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.LocalTime;

final class MoreLocalTimeAssertHelper {

    static <S extends Assert<S, LocalTime>> AbstractIntegerAssert<?> extractingHour(final S self) {
        return ForAssert.applyActual2(
                self.isNotNull(),
                s -> a -> Assertions.assertThat(a.getHour())
        );
    }

    private MoreLocalTimeAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}