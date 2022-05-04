package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public interface MoreTemporalAmountAssert<S extends MoreTemporalAmountAssert<S, A>, A extends TemporalAmount>
        extends MoreJavaTimeTemporalAssert<S, A> {

    default AbstractMoreTemporalAssert<?, Temporal> extractingAddTo(final Temporal temporal) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.addTo(temporal),
                        MoreJavaTimeTemporalAssertions::assertMore
                )
        );
    }

    default S has(final TemporalUnit unit, final long expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.get(unit),
                        r -> {
                            Assertions.assertThat(r)
                                    .isEqualTo(expected);
                            return s;
                        }
                )
        );
    }

    default ListAssert<TemporalUnit> extractingUnits() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getUnits())
        );
    }

    default AbstractMoreTemporalAssert<?, Temporal> extractingSubtractFrom(final Temporal temporal) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.subtractFrom(temporal),
                        MoreJavaTimeTemporalAssertions::assertMore
                )
        );
    }
}
