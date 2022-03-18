package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.zone.AbstractZoneIdAssert;
import com.github.jinahya.assertj.more.java.time.zone.MoreJavaTimeZoneAssertions;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public interface MoreClockAssert<S extends MoreClockAssert<S, A>, A extends Clock>
        extends MoreJavaTimeAssert<S, A> {

    // ------------------------------------------------------------------------------------------------- getZone()ZoneId
    default AbstractZoneIdAssert<?, ZoneId> extractingZone() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeZoneAssertions.assertMore(a.getZone())
        );
    }

    default S hasZone(final ZoneId expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    MoreJavaTimeZoneAssertions.assertMore(a.getZone())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------- withZone(ZoneId)Clock
    default AbstractMoreClockAssert<?, Clock> extractingWithZone(final ZoneId zone) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.withZone(zone))
        );
    }

    // ------------------------------------------------------------------------------------------------------- millis()J
    default AbstractLongAssert<?> extractingMillis() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.millis())
        );
    }

    default S hasMillis(final long expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.millis()).isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------ instant()Instant
    default AbstractMoreInstantAssert<?> extractingInstant() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.instant())
        );
    }

    default S hasInstant(final Instant expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    MoreJavaTimeAssertions.assertMore(a.instant())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }
}
