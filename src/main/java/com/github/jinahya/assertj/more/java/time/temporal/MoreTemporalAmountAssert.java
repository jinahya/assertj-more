package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public interface MoreTemporalAmountAssert<S extends MoreTemporalAmountAssert<S, A>, A extends TemporalAmount>
        extends MoreJavaTimeTemporalAssert<S, A> {

    // ----------------------------------------------------------------------------------------- addTo(Temporal)Temporal
    default AbstractMoreTemporalAssert<?, Temporal> extractingAddTo(final Temporal temporal) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeTemporalAssertions.assertMore(a.addTo(temporal))
        );
    }

    default AbstractLongAssert<?> extracting(final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.get(unit))
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
                s -> a -> MoreJavaTimeTemporalAssertions.assertMore(a.subtractFrom(temporal))
        );
    }
}
