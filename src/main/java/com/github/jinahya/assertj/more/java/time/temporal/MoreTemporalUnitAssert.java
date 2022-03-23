package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.AbstractMoreDurationAssert;
import com.github.jinahya.assertj.more.java.time.MoreJavaTimeAssertions;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public interface MoreTemporalUnitAssert<S extends MoreTemporalUnitAssert<S, A>, A extends TemporalUnit>
        extends MoreJavaTimeTemporalAssert<S, A> {

    default <R extends Temporal> AbstractMoreTemporalAssert<?, R> extractingAddTo(
            final R temporal, final long amount,
            final AssertFactory<? super R, ? extends AbstractMoreTemporalAssert<?, R>> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> factory.createAssert(a.addTo(temporal, amount))
        );
    }

    default AbstractLongAssert<?> between(final Temporal temporal1Inclusive,
                                          final Temporal temporal2Exclusive) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.between(temporal1Inclusive, temporal2Exclusive))
        );
    }

    default AbstractMoreDurationAssert<?> extractingDuration() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.getDuration())
        );
    }

    default S isDateBased() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isDateBased())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotDateBased() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isDateBased())
                            .isFalse();
                    return s;
                }
        );
    }

    default S isDurationEstimated() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isDurationEstimated())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isDurationNotEstimated() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isDurationEstimated())
                            .isFalse();
                    return s;
                }
        );
    }

    default S isSupportedBy(final Temporal temporal) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isSupportedBy(temporal))
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotSupportedBy(final Temporal temporal) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isSupportedBy(temporal))
                            .isFalse();
                    return s;
                }
        );
    }

    default S isTimeBased() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isTimeBased())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotTimeBased() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isTimeBased())
                            .isFalse();
                    return s;
                }
        );
    }
}
