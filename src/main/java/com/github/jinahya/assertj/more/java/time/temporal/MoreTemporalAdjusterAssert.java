package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Objects;

public interface MoreTemporalAdjusterAssert<S extends MoreTemporalAdjusterAssert<S, A>, A extends TemporalAdjuster>
        extends MoreJavaTimeTemporalAssert<S, A> {

    default AbstractMoreTemporalAssert<?, Temporal> extractingAdjustInto(final Temporal temporal) {
        Objects.requireNonNull(temporal, "temporal is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.adjustInto(temporal),
                        MoreJavaTimeTemporalAssertions::assertMore
                )
        );
    }
}
