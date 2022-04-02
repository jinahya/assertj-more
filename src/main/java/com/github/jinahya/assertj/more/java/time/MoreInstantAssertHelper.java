package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.Instant;
import java.util.Objects;

final class MoreInstantAssertHelper {

    // ----------------------------------------------------------------------------------------------- getEpochSecond()J
    static <S extends Assert<S, A>, A extends Instant> AbstractLongAssert<?> extractingEpochSecond(final S self) {
        Objects.requireNonNull(self, "self is null");
        return ForAssert.applyActual2(
                self.isNotNull(),
                s -> a -> Assertions.assertThat(a.getEpochSecond())
        );
    }

    static <S extends Assert<S, A>, A extends Instant> AbstractIntegerAssert<?> extractingNano(final S self) {
        Objects.requireNonNull(self, "self is null");
        return ForAssert.applyActual2(
                self.isNotNull(),
                s -> a -> Assertions.assertThat(a.getNano())
        );
    }

    static <S extends Assert<S, A>, A extends Instant> AbstractBooleanAssert<?> extractingIsAfter(
            S self, final Instant otherInstant) {
        return ForAssert.applyActual2(
                self.isNotNull(),
                s -> a -> Assertions.assertThat(a.isAfter(otherInstant))
        );
    }

    static <S extends Assert<S, A>, A extends Instant> AbstractBooleanAssert<?> extractingIsBefore(
            S self, final Instant otherInstant) {
        return ForAssert.applyActual2(
                self.isNotNull(),
                s -> a -> Assertions.assertThat(a.isBefore(otherInstant))
        );
    }

    private MoreInstantAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
